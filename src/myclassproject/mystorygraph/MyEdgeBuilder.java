package myclassproject.mystorygraph;

import myclassproject.mystorygraph.MyChoiceLabels;
import myclassproject.mystorygraph.MyNodeLabels;

import static myclassproject.mystorygraph.MyStoryEntities.*;

import java.util.List;

import com.playerInput.*;
import com.playerInput.PlayerInteraction.Icons;
import com.storygraph.BuilderMethod;
import com.storygraph.Edge;
import com.storygraph.NodeBuilder;
import com.storygraph.Node;
import java.lang.classfile.components.ClassPrinter;

public class MyEdgeBuilder extends NodeBuilder {
	/**
	 * Initializes the list of story graph nodes.
	 * @param list A list of all story graph nodes.
	 */
	public MyEdgeBuilder(List<Node> list) {
		super(list);
	}

	/**
	 * Write a method for each node. 
	 * Use get to get a reference to the node using its label.
	 * The method should add the edges of the node one by one. 
	 * These methods must have a BuilderMethod annotation.
	 */

	//Kiet Huynh
	@BuilderMethod
	public void rootEdges(){
		var root = get(MyNodeLabels.root.toString());
		var choice = new MenuChoice(MenuChoice.Options.Start);
		var nextNode = get(MyNodeLabels.BeginningScene.toString());
		root.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void BeginningSceneEdges(){
		var node = get(MyNodeLabels.BeginningScene.toString());
		var choice1 = new DialogChoice("I accept your offer.");
		var nextNode1 = get(MyNodeLabels.AcceptToGo.toString());
		node.add(new Edge(choice1, nextNode1));

		var choice2 = new DialogChoice("I cannot leave my family.");
		var nextNode2 = get(MyNodeLabels.Consequence.toString());
		node.add(new Edge(choice2, nextNode2));
	}

	@BuilderMethod
	public void ConsequenceEdges(){
		var node = get(MyNodeLabels.Consequence.toString());
		var choice = new PlayerInteraction(ChoiceLabels.Exit.toString(), edmona, Icons.exit, forestEnd);
		var nextNode = get(MyNodeLabels.MagicForest.toString());
		node.add(new Edge(choice, nextNode));
	}

		@BuilderMethod
	public void KillEdges() {
		var node = get(MyNodeLabels.Kill.toString());
		var choice = new PlayerInteraction(ChoiceLabels.Face.toString(), edmona, father);
		var nextNode = get(MyNodeLabels.CorruptionEnding.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void RileUpTheCrowdEdges() {
		var node = get(MyNodeLabels.RileUpTheCrowd.toString());
		var choice = new PlayerInteraction(ChoiceLabels.Sit.toString(), edmona, bedroom1.bed);
		var nextNode = get(MyNodeLabels.BecomeQueenEnding.toString());
		node.add(new Edge(choice, nextNode));
	}

	//Hoang Dieu Linh Nguyen
	@BuilderMethod
	public void MagicForestEdges(){
		var node = get(MyNodeLabels.MagicForest.toString());
		var choice1 = new DialogChoice("I will embrace the darkness and follow you, Quentin.");
		var nextNode1 = get(MyChoiceLabels.QuentinStudent.toString());
		node.add(new Edge(choice1, nextNode1));

		var choice2 = new DialogChoice("I cannot abandon my morals. Delphine, teach me the way of light.");
		var nextNode2 = get(MyChoiceLabels.DelphineStudent.toString());
		node.add(new Edge(choice2, nextNode2));
	}
	
		@BuilderMethod
	public void LearnLightMagicEdges(){
		var node = get(MyNodeLabels.LearnLightMagic.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.TalkToDelphin.toString(), delphine, Icons.talk, "Learn light magic from Delphine");
		var nextNode = get(MyNodeLabels.LearnFireMagic.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void LearnFireMagicEdges(){
		var node = get(MyNodeLabels.LearnFireMagic.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.Exit.toString(), edmona, Icons.exit, "Come to town");
		var nextNode = get(MyNodeLabels.Rally.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void RallyEdges(){
		var node = get(MyNodeLabels.Rally.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.TalkToNoble1.toString(), noble1, Icons.talk, "Convince nobles to follow");
		var nextNode = get(MyNodeLabels.PopulistFaction.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void PopulistFactionEdges(){
		var node = get(MyNodeLabels.PopulistFaction.toString());
		var choice1 = new DialogChoice("Become an indispensable supporter");
		var nextNode1 = get(MyChoiceLabels.PromisePopulistPower.toString());
		node.add(new Edge(choice1, nextNode1));

		var choice2 = new DialogChoice("Become the leader of the army");
		var nextNode2 = get(MyChoiceLabels.RileUpTheCrowd.toString());
		node.add(new Edge(choice2, nextNode2));
	}


	// Tri Huynh

	@BuilderMethod
	public void AcceptRunEdge(){ 
		var node = get(MyNodeLabels.AcceptToGo.toString());
		var interactionChoice = new PlayerInteraction(MyChoiceLabels.TalkToGarry.toString(), garry, Icons.talk, "Ask Garry to finalize the deal."
    );
    	node.add(new Edge(interactionChoice, RunAway));
	}

	@BuilderMethod
	public void runAwayEdges() {
		var node = get(MyNodeLabels.RunAway.toString());
		var nextNode = get(MyNodeLabels.DelphineTalk.toString());

		var meetDelphine = new PlayerInteraction(
			MyChoiceLabels.TalkToDelphin.toString(),
			delphine,
			Icons.talk,
			"Talk to the strange woman."
		);

		node.add(new Edge(meetDelphine, nextNode));
	}

	@BuilderMethod
	public void delphineTalkEdge() {
		var node = get(MyNodeLabels.DelphineTalk.toString());
		var studentNode = get(MyNodeLabels.DelphineStudent.toString());
		var acceptHelp = new DialogChoice("Please, teach me. I need your help!");
		node.add(new Edge(acceptHelp, studentNode));
	}

	@BuilderMethod
	public void quentinStudentEdges() {
		var node = get(MyNodeLabels.QuentinStudent.toString());
		var choice = new DialogChoice("I am ready, Master Quentin.");
		var nextNode = get(MyNodeLabels.LearnDarkMagic.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void delphineStudentEdges() {
		var node = get(MyNodeLabels.DelphineStudent.toString());
		var choice = new DialogChoice("Yes, Master Delphine, I am ready.");
		var nextNode = get(MyNodeLabels.LearnLightMagic.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void learnDarkMagicEdges() {
		var node = get(MyNodeLabels.LearnDarkMagic.toString());
		var choice = new DialogChoice("Visit The Forbidden Library");
		var nextNode = get(MyNodeLabels.ForbiddenLibrary.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void forbiddenLibraryEdges() {
		var node = get(MyNodeLabels.ForbiddenLibrary.toString());
		
		var readSpellbookChoice = new PlayerInteraction(
			MyChoiceLabels.Read.toString(), 
			libraryspellbook,
			PlayerInteraction.Icons.research,
			"Inspect the necromantic tome"
		);

		var nextNode = get(MyNodeLabels.ReadTome.toString());
		node.add(new Edge(readSpellbookChoice, nextNode));
	}

	public void LeaveLibrary() {
		var node = get(MyNodeLabels.ReadTome.toString());
		
		var DoorExit = new PlayerInteraction(
			MyChoiceLabels.LeaveLibrary.toString(), 
			door,
			PlayerInteraction.Icons.exit,
			"To the next trial"
		);

		var nextNode = get(MyNodeLabels.SoulbindingTrial.toString());
		node.add(new Edge(DoorExit, nextNode));
	}

	public void LeaveForest() {
		var node = get(MyNodeLabels.SoulbindingTrial.toString());
		var LeavePath = new PlayerInteraction(
			edmona,
			MyChoiceLabels.ToGrimspire.toString(),
			forestexit
		);
		var nextNode = get(MyNodeLabels.TakeRevenge.toString());
		node.add(new Edge(LeavePath, nextNode));
	}

	public void GrimspireFate() {
		var node = get(MyNodeLabels.TakeRevenge.toString());
		var choice1 = new DialogChoice("Your life ends here!");
		var nextNode1 = get(MyChoiceLabels.Kill.toString());
		node.add(new Edge(choice1, nextNode1));

		var choice2 = new DialogChoice("You are so pathetic...");
		var nextNode2 = get(MyChoiceLabels.Spare.toString());
		node.add(new Edge(choice2, nextNode2));
	}

	public void CrownSelf() {
		var node = get(MyNodeLabels.Spare.toString());
		var CrownDecision = new PlayerInteraction(MyChoiceLabels.CrownSelf.toString(), grimspire, PlayerInteraction.Icons.arrest, "Lock Grimspire and become Queen");
		var nextNode = get(MyNodeLabels.BecomeQueenEnding.toString());
		node.add(new Edge(CrownDecision, nextNode));
	}
}
