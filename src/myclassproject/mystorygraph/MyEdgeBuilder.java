package myclassproject.mystorygraph;

import java.util.List;

import com.storygraph.BuilderMethod;
import com.storygraph.Node;
import com.storygraph.NodeBuilder;

import myclassproject.questexample.ChoiceLabels;
import myclassproject.questexample.NodeLabels;

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
<<<<<<< HEAD

=======
>>>>>>> f84c96368e7d9244aa672fb92f0861fbe90b7e85
	//Kiet Huynh
	@BuilderMethod
	public void rootEdges(){
		var root = get(MyNodeLabels.root.toString());
		var choice = new MenuChoice(MenuChoice.Options.Start);
		var nextNode = get(MyNodeLabels.BeginningScene.toString());
		root.add(new Edge(choice, nextNode));
	}

	public void BeginningSceneEdges(){
		var node = get(MyNodeLabels.BeginningScene.toString());
		var choice1 = new DialogChoice("I accept your offer.");
		var nextNode1 = get(MyNodeLabels.AcceptToGo.toString());
		node.add(new Edge(choice1, nextNode1));

		var choice2 = new DialogChoice("I cannot leave my family.");
		var nextNode2 = get(MyNodeLabels.Consequence.toString());
		node.add(new Edge(choice2, nextNode2));
	}

	public void ConsequenceEdges(){
		var node = get(MyNodeLabels.Consequence.toString());
		var choice = new PlayerInteraction(ChoiceLabels.Exit.toString(), edmona, Icons.exit,
				forestEnd);
		var nextNode = get(MyNodeLabels.MagicForest.toString());
		node.add(new Edge(choice, nextNode));
	}
	//Hoang Dieu Linh Nguyen
	public void MagicForestEdges(){
		var node = get(MyNodeLabels.MagicForest.toString());
		var choice1 = new DialogChoice("I accept your offer.");
		var nextNode1 = get(ChoiceLabels.QuentinStudent.toString());
		node.add(new Edge(choice1, nextNode1));

		var choice2 = new DialogChoice("I cannot leave my family.");
		var nextNode2 = get(ChoiceLabels.Consequence.toString());
		node.add(new Edge(choice2, nextNode2));
	}



	public void AcceptRunEdge(){ // Tri Huynh
		var node = get(MyNodeLabels.AcceptToGo.toString());
		var interactionChoice = new PlayerInteraction(MyChoiceLabels.TalkToGarry.toString(), garry, Icons.talk, "Ask Garry to finalize the deal."
    );
    	node.add(new Edge(interactionChoice, RunAway));
	}
}
