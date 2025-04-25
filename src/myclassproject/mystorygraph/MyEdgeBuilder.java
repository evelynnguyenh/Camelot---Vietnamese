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
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.Consequence1.toString());
		node.add(new Edge(choice, nextNode));
	}	
	
	@BuilderMethod
	public void Consequence1Edges() {
		var node = get(MyNodeLabels.Consequence1.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.Consequence2.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void Consequence2Edges() {
		var node = get(MyNodeLabels.Consequence2.toString());
		var choice = new DialogChoice("Let's go!");
		var nextNode = get(MyNodeLabels.Consequence3.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void Consequence3Edges() {
		var node = get(MyNodeLabels.Consequence3.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.Consequence4.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void Consequence4Edges() {
		var node = get(MyNodeLabels.Consequence4.toString());
		var choice = new PlayerInteraction(edmona, MyChoiceLabels.Exit.toString(), forestEnd);
		var nextNode = get(MyNodeLabels.MagicForest.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void KillEdges() {
		var node = get(MyNodeLabels.Kill.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.Kill1.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void Kill1Edges() {
		var node = get(MyNodeLabels.Kill1.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.Kill2.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void Kill2Edges() {
		var node = get(MyNodeLabels.Kill2.toString());
		var choice = new DialogChoice("Yes, I did it. I brought you back.");
		var nextNode = get(MyNodeLabels.Kill3.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void Kill3Edges() {
		var node = get(MyNodeLabels.Kill3.toString());
		var choice = new DialogChoice("I saved you. No matter the cost.");
		var nextNode = get(MyNodeLabels.Kill4.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void Kill4Edges() {
		var node = get(MyNodeLabels.Kill4.toString());
		var choice = new PlayerInteraction(edmona, MyChoiceLabels.Face.toString(), father);
		var nextNode = get(MyNodeLabels.CorruptionEnding.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void CorruptionEndingEdges() {
		var node = get(MyNodeLabels.CorruptionEnding.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.CorruptionEnding1.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void CorruptionEnding1Edges() {
		var node = get(MyNodeLabels.CorruptionEnding1.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.CorruptionEnding2.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void CorruptionEnding2Edges() {
		var node = get(MyNodeLabels.CorruptionEnding2.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.CorruptionEnding3.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void CorruptionEnding3Edges() {
		var node = get(MyNodeLabels.CorruptionEnding3.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.CorruptionEnding4.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void CorruptionEnding4Edges() {
		var node = get(MyNodeLabels.CorruptionEnding3.toString());
		var choice = new DialogChoice("This isn’t the sister we knew… Stay away!");
		var nextNode = get(MyNodeLabels.CorruptionEnding5.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void CorruptionEnding5Edges() {
		var node = get(MyNodeLabels.CorruptionEnding5.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.CorruptionEnding6.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void BecomeQueenEndingEdges() {
		var node = get(MyNodeLabels.BecomeQueenEnding.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.BecomeQueenEnding1.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void BecomeQueenEnding1Edges() {
		var node = get(MyNodeLabels.BecomeQueenEnding1.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.BecomeQueenEnding2.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void BecomeQueenEnding2Edges() {
		var node = get(MyNodeLabels.BecomeQueenEnding2.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.BecomeQueenEnding3.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void BecomeQueenEnding3Edges() {
		var node = get(MyNodeLabels.BecomeQueenEnding3.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.BecomeQueenEnding4.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void BecomeQueenEnding4Edges() {
		var node = get(MyNodeLabels.BecomeQueenEnding4.toString());
		var choice = new DialogChoice("I will help Your Majesty. The kingdom’s prosperity must come first.");
		var nextNode = get(MyNodeLabels.BecomeQueenEnding5.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void BecomeQueenEnding5Edges() {
		var node = get(MyNodeLabels.BecomeQueenEnding5.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.BecomeQueenEnding6.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void RileUpTheCrowdEdges() {
		var node = get(MyNodeLabels.RileUpTheCrowd.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.RileUpTheCrowd1.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void RileUpTheCrowdEdges1() {
		var node = get(MyNodeLabels.RileUpTheCrowd1.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.RileUpTheCrowd2.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void RileUpTheCrowdEdges2() {
		var node = get(MyNodeLabels.RileUpTheCrowd2.toString());
		var choice = new DialogChoice("For freedom! For justice!");
		var nextNode = get(MyNodeLabels.RileUpTheCrowd3.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void RileUpTheCrowdEdges3() {
		var node = get(MyNodeLabels.RileUpTheCrowd3.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.RileUpTheCrowd4.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void RileUpTheCrowdEdges4() {
		var node = get(MyNodeLabels.RileUpTheCrowd4.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.RileUpTheCrowd5.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void RileUpTheCrowdEdges5() {
		var node = get(MyNodeLabels.RileUpTheCrowd5.toString());
		var choice = new DialogChoice("Long live Queen Edmona!");
		var nextNode = get(MyNodeLabels.RileUpTheCrowd2.toString());
		node.add(new Edge(choice, nextNode));
	}
		
	@BuilderMethod
	public void RileUpTheCrowdEdges6() {
		var node = get(MyNodeLabels.RileUpTheCrowd6.toString());
		var choice = new PlayerInteraction(edmona, MyChoiceLabels.Sit.toString(), bed);
		var nextNode = get(MyNodeLabels.BecomeQueenEnding.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void PopulistRuleEndingEdges() {
		var node = get(MyNodeLabels.PopulistRuleEnding.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.PopulistRuleEnding1.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void PopulistRuleEndingEdges1() {
		var node = get(MyNodeLabels.PopulistRuleEnding1.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.PopulistRuleEnding2.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void PopulistRuleEndingEdges2() {
		var node = get(MyNodeLabels.PopulistRuleEnding2.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.PopulistRuleEnding3.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void PopulistRuleEndingEdges3() {
		var node = get(MyNodeLabels.PopulistRuleEnding3.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.PopulistRuleEnding4.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void PopulistRuleEndingEdges4() {
		var node = get(MyNodeLabels.PopulistRuleEnding4.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.PopulistRuleEnding5.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void PopulistRuleEndingEdges5() {
		var node = get(MyNodeLabels.PopulistRuleEnding5.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.PopulistRuleEnding6.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void PopulistRuleEndingEdges6() {
		var node = get(MyNodeLabels.PopulistRuleEnding6.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.PopulistRuleEnding7.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	//Hoang Dieu Linh Nguyen
	@BuilderMethod
	public void MagicForestEdges(){
		var node = get(MyNodeLabels.MagicForest.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.MagicForest1.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void MagicForestEdges1(){
		var node = get(MyNodeLabels.MagicForest1.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.MagicForest2.toString());
		node.add(new Edge(choice, nextNode));

	}

	@BuilderMethod
	public void MagicForestEdges2(){
		var node = get(MyNodeLabels.MagicForest2.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.MagicForest3.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void MagicForestEdges3(){
		var node = get(MyNodeLabels.MagicForest3.toString());
		var choice = new DialogChoice("This is a choice I cannot make lightly.");
		var nextNode = get(MyNodeLabels.MagicForest4.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void MagicForestEdges4() {
		var node = get(MyNodeLabels.MagicForest4.toString());
		var choice1 = new PlayerInteraction(MyChoiceLabels.chooseDelphine.toString(), delphine, Icons.kneel, "Learn light magic from Delphine");
		var nextNode1 = get(MyNodeLabels.DelphineStudent.toString());
		node.add(new Edge(choice1, nextNode1));

		var choice2 = new PlayerInteraction(MyChoiceLabels.chooseQuentin.toString(), quentin, Icons.kneel, "Learn dark magic from Quentin");
		var nextNode2 = get(MyNodeLabels.QuentinStudent.toString());
		node.add(new Edge(choice2, nextNode2));
	}

	@BuilderMethod
	public void LearnLightMagicEdges(){
		var node = get(MyNodeLabels.LearnLightMagic.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.LearnLightMagic1.toString());
		node.add(new Edge(choice, nextNode));
		// var choice = new PlayerInteraction(MyChoiceLabels.TalkToDelphin.toString(), delphine, Icons.talk, "Proceed with the training");
		// var nextNode = get(MyNodeLabels.LearnFireMagic.toString());
		// node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void LearnLightMagicEdges1(){
		var node = get(MyNodeLabels.LearnLightMagic1.toString());
		var choice = new DialogChoice("Yes Master Delphine. I am ready.");
		var nextNode = get(MyNodeLabels.LearnFireMagic.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void LearnFireMagicEdges(){
		var node = get(MyNodeLabels.LearnFireMagic.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.LearnFireMagic1.toString());
		node.add(new Edge(choice, nextNode));
	}

		@BuilderMethod
	public void LearnFireMagicEdges1(){
		var node = get(MyNodeLabels.LearnFireMagic1.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.LearnFireMagic2.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void LearnFireMagicEdges2(){
		var node = get(MyNodeLabels.LearnFireMagic2.toString());
		var choice = new DialogChoice("I will control it! Master Delphine.");
		var nextNode = get(MyNodeLabels.LearnFireMagic3.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void LearnFireMagicEdges3(){
		var node = get(MyNodeLabels.LearnFireMagic3.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.LearnFireMagic4.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void LearnFireMagicEdges4(){
		var node = get(MyNodeLabels.LearnFireMagic4.toString());
		var choice = new DialogChoice("I am very grateful for your help.");
		var nextNode = get(MyNodeLabels.LearnFireMagic5.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void LearnFireMagicEdges5(){
		var node = get(MyNodeLabels.LearnFireMagic5.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.LearnFireMagic6.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void LearnFireMagicEdges6(){
		var node = get(MyNodeLabels.LearnFireMagic6.toString());
		var choice = new PlayerInteraction(edmona, MyChoiceLabels.LeaveForest.toString(), forestexit2);
		var nextNode = get(MyNodeLabels.Rally.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void RallyEdges(){
		var node = get(MyNodeLabels.Rally.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.Rally1.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void RallyEdges1() {
		var node = get(MyNodeLabels.Rally1.toString());
		var nextNode1 = get(MyNodeLabels.RileUpTheCrowd.toString());
		var nextNode2 = get(MyNodeLabels.PromisePopulistPower.toString());
		// Noble 1
		var choice1A = new PlayerInteraction(MyChoiceLabels.TalkToNoble.toString(), noble1, Icons.swords, "Convince them to fight for you");
		var choice1B = new PlayerInteraction(MyChoiceLabels.TalkToNoble1.toString(), noble1, Icons.kneel, "Promise to give them power");
		node.add(new Edge(choice1A, nextNode1));
		node.add(new Edge(choice1B, nextNode2));
		// Noble 2
		var choice2A = new PlayerInteraction(MyChoiceLabels.TalkToNoble2.toString(), noble2, Icons.swords, "Convince them to fight for you");
		var choice2B = new PlayerInteraction(MyChoiceLabels.TalkToNoble3.toString(), noble2, Icons.kneel, "Promise to give them power");
		node.add(new Edge(choice1A, nextNode1));
		node.add(new Edge(choice1B, nextNode2));
		// Noble 3
		var choice3A = new PlayerInteraction(MyChoiceLabels.TalkToNoble4.toString(), noble3, Icons.swords, "Convince them to fight for you");
		var choice3B = new PlayerInteraction(MyChoiceLabels.TalkToNoble5.toString(), noble3, Icons.kneel, "Promise to give them power");
		node.add(new Edge(choice1A, nextNode1));
		node.add(new Edge(choice1B, nextNode2));
		// Noble 4
		var choice4A = new PlayerInteraction(MyChoiceLabels.TalkToNoble6.toString(), noble4, Icons.swords, "Convince them to fight for you");
		var choice4B = new PlayerInteraction(MyChoiceLabels.TalkToNoble7.toString(), noble4, Icons.kneel, "Promise to give them power");
		node.add(new Edge(choice1A, nextNode1));
		node.add(new Edge(choice1B, nextNode2));
		// Noble 5
		var choice5A = new PlayerInteraction(MyChoiceLabels.TalkToNoble8.toString(), noble5, Icons.swords, "Convince them to fight for you");
		var choice5B = new PlayerInteraction(MyChoiceLabels.TalkToNoble9.toString(), noble5, Icons.kneel, "Promise to give them power");
		node.add(new Edge(choice1A, nextNode1));
		node.add(new Edge(choice1B, nextNode2));
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
		var choice = new DialogChoice("Yes daddy...");
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
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.QuentinStudent1.toString());
		node.add(new Edge(choice, nextNode));
		// var choice = new DialogChoice("I am ready, Master Quentin.");
		// var nextNode = get(MyNodeLabels.LearnDarkMagic.toString());
		// node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void quentinStudentEdges1() {
		var node = get(MyNodeLabels.QuentinStudent1.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.QuentinStudent2.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void quentinStudentEdges2() {
		var node = get(MyNodeLabels.QuentinStudent2.toString());
		var choice = new DialogChoice("I am ready Master Quentin.");
		var nextNode = get(MyNodeLabels.LearnDarkMagic.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void delphineStudentEdges() {
		var node = get(MyNodeLabels.DelphineStudent.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.DelphineStudent1.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void delphineStudentEdges1() {
		var node = get(MyNodeLabels.DelphineStudent1.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.DelphineStudent2.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void delphineStudentEdges2() {
		var node = get(MyNodeLabels.DelphineStudent2.toString());
		var choice = new DialogChoice("Yes Master Delphine. I am ready.");
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