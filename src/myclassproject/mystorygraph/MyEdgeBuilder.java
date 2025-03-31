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
	//Hoang Dieu Linh Nguyen
	@BuilderMethod
	public void MagicForestEdges(){
		var node = get(MyNodeLabels.MagicForest.toString());
		var choice1 = new DialogChoice("I will embrace the darkness and follow you, Quentin.");
		var nextNode1 = get(ChoiceLabels.QuentinStudent.toString());
		node.add(new Edge(choice1, nextNode1));

		var choice2 = new DialogChoice("I cannot abandon my morals. Delphine, teach me the way of light.");
		var nextNode2 = get(ChoiceLabels.DelphineStudent.toString());
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

}
