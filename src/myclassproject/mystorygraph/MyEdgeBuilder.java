package myclassproject.mystorygraph;

import java.util.List;

import com.storygraph.BuilderMethod;
import com.storygraph.Node;
import com.storygraph.NodeBuilder;

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
	@BuilderMethod
	public void rootEdges(){
		var root = get(NodeLabels.root.toString());
		var choice = new MenuChoice(MenuChoice.Options.Start);
		var nextNode = get(NodeLabels.BeginningScene.toString());
		root.add(new Edge(choice, nextNode));
	}

	public void BeginningSceneEdges(){
		var node = get(MyNodeLabels.BeginningScene.toString());
		var choice1 = new DialogChoice("I accept your offer.");
		var nextNode1 = get(NodeLabels.AcceptToGo.toString());
		node.add(new Edge(choice1, nextNode1));

		var choice2 = new DialogChoice("I cannot leave my family.");
		var nextNode2 = get(NodeLabels.Consequence.toString());
		node.add(new Edge(choice2, nextNode2));
	}

	public void Consequence(){
		var node = get(MyNodeLabels.Consequence.toString());
		
	}
}
