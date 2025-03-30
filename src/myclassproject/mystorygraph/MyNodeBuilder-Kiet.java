package myclassproject.mystorygraph;

import myclassproject.mystorygraph.MyChoiceLabels;
import myclassproject.mystorygraph.MyNodeLabels;

import static myclassproject.mystorygraph.MyStoryEntities.*;

import java.util.List;

import com.actions.*;
import com.sequences.*;
import com.storygraph.*;

import javax.smartcardio.CardPermission;

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
	public void KillActions() {
		var node = get(MyNodeLabels.Kill.toString());
		node.add(new HideDialog())
			.add(new NarrationSequence("With the man dead, Edmona casts the spell to bring back her brother and father."))
			.add(new Cast(edmona, brother, red))
			.add(new Cast(edmona, father, red))
			.add(new Revive(brother))
			.add(new Revive(father))
			.add(new SetPosition(brother, darkforest))
			.add(new SetPosition(father, darkforest))
			.add(new NarrationSequence("Slowly, figures emerge from the light – her brother and father, returned to life."))
			.add(new Face(edmona, brother))
			.add(new DialogSequence(brother, edmona, 
				List.of("Sister… Is this real? Are we truly back?"), 
				List.of("Yes, I did it. I brought you back.")))
			.add(new Revive(father))
			.add(new DialogSequence(father, edmona, 
				List.of("My child… What have you done?"), 
				List.of("I saved you. No matter the cost.")))
			.add(new EnableInput());
	}

	@BuilderMethod
	public void CorruptionEndingActions() {
		var node = get(MyNodeLabels.CorruptionEnding.toString());
		node.add(new HideDialog())
			.add(new NarrationSequence("Edmona sees the shapes of her brother and father slowly forming from the blood of their nemesis."))
			.add(new NarrationSequence("However, as the ritual completes, she feels something unnatural happening within her."))
			.add(new NarrationSequence("A searing pain courses through her veins. Her eyes turn red, her hair turning gray, her body twisting into something unrecognizable."))
			.add(new SetEyeColor(edmona, red))
			.add(new SetHairColor(edmona, gray))
			.add(new SetClothing(edmona, Witch))
			.add(new NarrationSequence("She kneels down, her once human form now decayed, Edmona turning a sickly witch."))
			.add(new Kneel(edmona))
			.add(new DialogSequence(brother, father, 
				List.of("What… What have you become?"), 
				List.of("This isn’t the sister we knew… Stay away!")))
			.add(new WalkTo(edmona, father))
			.add(new MoveAway(edmona))
			.add(new NarrationSequence("Edmona, now feared by the ones she loved most, realizes she has lost everything."))
			.add(new EnableInput());
	}
	
	@BuilderMethod
	public void BecomeQueenEndingActions() {
		var node = get(MyNodeLabels.BecomeQueenEnding.toString());
	
		node.add(new SetPosition(edmona, hallway)) 
			.add(new NarrationSequence("Edmona ascends the throne of Magna Vietia, her journey of struggle and sacrifice culminating in the crown."))
			.add(new NarrationSequence("As Queen, she works tirelessly to rebuild the fractured kingdom, blending wisdom and grace into her rule."))
			.add(new NarrationSequence("Her reign is marked by fairness and compassion, striving to heal the wounds left by House Grimpshire."))
			.add(new NarrationSequence("Edmona begins to restore hope to her people, rebuilding the kingdom with determination."))
			.add(new EnableInput())
			.add(new SetPosition(edmona, town))
			.add(new Face(edmona, noble1))
			.add(new DialogSequence(edmona, noble1, 
            	List.of("We need to restore our economy and trade routes. Your expertise will be vital."), 
            	List.of("I will help, Your Majesty. The kingdom’s prosperity must come first."))
        	)
			.add(new NarrationSequence("Edmona works closely with her trusted nobles, putting plans into action to restore the kingdom."))
			.add(new DanceTogether(edmona, noble1))
			.add(new DanceTogether(noble2, noble3))
			.add(new DanceTogether(noble4, noble5));
	}
	