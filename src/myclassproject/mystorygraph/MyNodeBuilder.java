package myclassproject.mystorygraph;

import static myclassproject.questexample.QuestStoryEntities.chair;
import static myclassproject.questexample.QuestStoryEntities.cityDoor;
import static myclassproject.questexample.QuestStoryEntities.cityExit;
import static myclassproject.questexample.QuestStoryEntities.cottageDoor;
import static myclassproject.questexample.QuestStoryEntities.sword;
import static myclassproject.questexample.QuestStoryEntities.table;

import java.util.List;

import com.storygraph.*;

public class MyNodeBuilder extends NodeBuilder {
	public MyNodeBuilder(List<Node> list) {
		super(list);
	}

	/**
	 * Write a method for each node. 
	 * Use get to get a reference to the node using its label.
	 * The method adds Camelot actions that execute in order when visiting that node. 
	 * These methods must have a BuilderMethod annotation.
	 */

	@BuilderMethod

	// Kiet Huynh

    public void rootActions() {
        var root = get(MyNodeLabels.root.toString());
        root.add(new CreateAll(List.of(bedroom1, bedroom2, camp, town, lightforest, darkforest, ruins, library, hallway, sword, cottageDoor, table, chair, cityDoor, cityExit, forestEnd)))
		// initiating each character
        .add(new CreateCharacterSequence(edmona))
        .add(new CreateCharacterSequence(garry))
        .add(new CreateCharacterSequence(delphine))
        .add(new CreateCharacterSequence(quentin))
        .add(new CreateCharacterSequence(grimspire))
        .add(new CreateCharacterSequence(brother))
        .add(new CreateCharacterSequence(father))

        // position each character
        .add(new SetPosition(edmona, bedroom1))
        .add(new SetPosition(garry, bedroom1))
        .add(new SetPosition(delphine, lightforest))
        .add(new SetPosition(quentin, lightforest))
        .add(new SetPosition(grimspire, bedroom2))
        .add(new SetPosition(brother, hallway))
        .add(new SetPosition(father, hallway))

        // focus camera on Edmona and show menu
        .add(new SetCameraFocus(edmona))
        .add(new ShowMenu());
    }

	@BuilderMethod
	public void BeginningSceneActions() {
		var node = get(MyNodeLabels.BeginningScene.toString());
		node.add(new HideMenu())
			.add(new EnableInput())
			.add(new DialogSequence(grimspire, edmona, 
				List.of("Your brother and father have been accused of embezzlement. They will be executed unless the stolen amount is repaid."), 
				List.of("This can't be true! We will find a way to repay the debt.")))
			.add(new NarrationSequence("The amount is too grand for Edmona's family to repay."))
			.add(new DialogSequence(garry, edmona, 
				List.of("I will save your family and pay off the debt... if you agree to become my wife and come with me."), 
				List.of("I accept your offer.", "I cannot leave my family.")));
	}
	
	@BuilderMethod
	public void AcceptToGoActions() { // Tri Huynh
		var node = get(MyNodeLabels.AcceptToGo.toString());
		node.add(new SetPosition(edmona, hallway))
			.add(new SetPosition(Garry, hallway))
			.add(new DialogSequence(father, edmona,
				List.of("Edmona, I'm really sorry that things had to be like this. Thank you for your sacrifice.")))
	}
	
	@BuilderMethod
	public void RunAwayActions() {
		var node = get(MyNodeLabels.RunAway.toString());
		node.add(new NarrationSequence("Garry betrayed Edmona, selling her as a servant."))
			.add(new DialogSequence(edmona, garry, 
				List.of("You lied to me! I will not live this way."), 
				List.of("Don't you run away!")))
			.add(new SetPosition(edmona, lightforest))
			.add(new NarrationSequence("Edmona ran for days, hiding in the forest."))
			.add(new DialogSequence(delphine, edmona, 
				List.of("I am Delphine, a master of light magic. I will take you as my student."), 
				List.of("I accept your guidance.")))
			.add(new NarrationSequence("Edmona begins her training with Delphine."));
	}

    @BuilderMethod
    public void ConsequenceActions() {
        var node = get(MyNodeLabels.Consequence.toString());
		node.add(new NarrationSequence("Unable to repay the debt, Edmona's brother and father are executed."))
        .add(new NarrationSequence("Royal guards storm the castle, trying to capture Edmona."))
        .add(new DialogSequence(edmona, null, 
            List.of("I must escape now!"), 
            List.of()))
        .add(new SetPosition(edmona, lightforest))
        .add(new NarrationSequence("She wakes up in a strange forest the next morning."))
		.add(new EnableInput());
	}

    public void MagicForestActions() {
        var node = get(MyNodeLabels.MagicForest.toString());
        node.add(.add(new NarrationSequence("During her magical forest exploration, she encounters two omnipower beings: Quentin and Delphine."))
        .add(new SetCameraMode(quentin))
        .add(new NarrationSequence("Quentin, a master of dark magic, promises to help her take revenge and revive her beloved brother and father within a blink of an eye."))
        .add(new SetCameraMode(delphine))
        .add(new NarrationSequence("Delphine, a kindhearted witch who only employs light magic, promises to give her the power to change the rotten society she was born into.")))
        
        
        .add(new DialogSequence(delphine, quentin,edmona,
            List.of("I can give you power beyond imagination. You have potential, but the choice is yours."), 
			List.of("Come with me, and I will teach you the greatest power in the world."),
            List.of("I am ready to learn light magic.", "I am ready to learn dark magic.")));

    }
