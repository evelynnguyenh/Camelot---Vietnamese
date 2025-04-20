package myclassproject.mystorygraph;

import myclassproject.mystorygraph.MyChoiceLabels;
import myclassproject.mystorygraph.MyNodeLabels;

import static myclassproject.mystorygraph.MyStoryEntities.*;

import java.util.List;

import com.playerInput.*;
import com.playerInput.PlayerInteraction.Icons;
import com.playerInput.DialogChoice;
import com.storygraph.BuilderMethod;
import com.storygraph.Edge;
import com.storygraph.NodeBuilder;
import com.storygraph.Node;

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
		
		var choice = new DialogChoice("This can't be true! We will find a way to repay the debt.");
		var nextNode = get(MyNodeLabels.BeginningScene1.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void BeginningSceneEdges1() {
		var node = get(MyNodeLabels.BeginningScene1.toString());
		
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.BeginningScene2.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void BeginningSceneEdges2() {
		var node = get(MyNodeLabels.BeginningScene2.toString());
		
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
		var choice = new PlayerInteraction(MyChoiceLabels.Exit.toString(), forestEnd, Icons.exit, "Leave The Forest");
		var nextNode = get(MyNodeLabels.MagicForest.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void KillEdges() {
		var node = get(MyNodeLabels.Kill.toString());
		var choice = new PlayerInteraction(edmona, MyChoiceLabels.Face.toString(), father);
		var nextNode = get(MyNodeLabels.CorruptionEnding.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void RileUpTheCrowdEdges() {
		var node = get(MyNodeLabels.RileUpTheCrowd.toString());
		var choice = new PlayerInteraction(edmona, MyChoiceLabels.Sit.toString(), bed);
		var nextNode = get(MyNodeLabels.BecomeQueenEnding.toString());
		node.add(new Edge(choice, nextNode));
	}

	//Hoang Dieu Linh Nguyen
	@BuilderMethod
	public void MagicForestEdges(){
		var node = get(MyNodeLabels.MagicForest.toString());
		var choice1 = new DialogChoice("I will embrace the darkness and follow you, Quentin.");
		var nextNode1 = get(MyNodeLabels.QuentinStudent.toString());
		node.add(new Edge(choice1, nextNode1));

		var choice2 = new DialogChoice("I cannot abandon my morals. Delphine, teach me the way of light.");
		var nextNode2 = get(MyNodeLabels.DelphineStudent.toString());
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
		var nextNode1 = get(MyNodeLabels.PromisePopulistPower.toString());
		node.add(new Edge(choice1, nextNode1));

		var choice2 = new DialogChoice("Become the leader of the army");
		var nextNode2 = get(MyNodeLabels.RileUpTheCrowd.toString());
		node.add(new Edge(choice2, nextNode2));
	}


	// Tri Huynh
	@BuilderMethod
	public void FinishDealEdge() {
		var node = get(MyNodeLabels.AcceptToGo.toString());
		var choice = new DialogChoice("It's time you go with Garry, talk to him darling.");
		var nextNode = get(MyNodeLabels.AcceptToGo1.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void AcceptRunEdge(){ 
		var node = get(MyNodeLabels.AcceptToGo1.toString());
		var interactionChoice = new PlayerInteraction(MyChoiceLabels.TalkToGarry.toString(), garry, Icons.talk, "Ask Garry to finalize the deal."
    );
		var nextNode = get(MyNodeLabels.RunAway.toString());
    	node.add(new Edge(interactionChoice, nextNode));
	}

	@BuilderMethod
	public void runAwayEdges() {
		var node = get(MyNodeLabels.RunAway.toString());
		var choice = new DialogChoice("Oh no! I have to escape!");
		var nextNode = get(MyNodeLabels.RunAway1.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void runAway1Edges() {
		var node = get(MyNodeLabels.RunAway1.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.RunAway2.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	public void runAway2Edges() {
		var node = get(MyNodeLabels.RunAway2.toString());
		var meetDelphine = new PlayerInteraction(
			MyChoiceLabels.TalkToDelphin.toString(),
			delphine,
			Icons.talk,
			"Talk to the strange woman."
		);
		var nextNode = get(MyNodeLabels.DelphineTalk.toString());
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
		var nextNode1 = get(MyNodeLabels.Kill.toString());
		node.add(new Edge(choice1, nextNode1));

		var choice2 = new DialogChoice("You are so pathetic...");
		var nextNode2 = get(MyNodeLabels.Spare.toString());
		node.add(new Edge(choice2, nextNode2));
	}

	public void CrownSelf() {
		var node = get(MyNodeLabels.Spare.toString());
		var CrownDecision = new PlayerInteraction(MyChoiceLabels.CrownSelf.toString(), grimspire, PlayerInteraction.Icons.arrest, "Lock Grimspire and become Queen");
		var nextNode = get(MyNodeLabels.BecomeQueenEnding.toString());
		node.add(new Edge(CrownDecision, nextNode));
	}
}
