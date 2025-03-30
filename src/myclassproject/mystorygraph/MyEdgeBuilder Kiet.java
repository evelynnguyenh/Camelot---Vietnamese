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
	public void KillEdges(){
		var node = get(MyNodeLabels.Kill.toString());
		var choice = new PlayerInteraction(ChoiceLabels.Face.toString(), edmona, father);
		var nextNode = get(MyNodeLabels.CorruptionEnding.toString());
		node.add(new Edge(choice, nextNode));
	}

	public void RileUpTheCrowdEdges(){
		var node = get(MyNodeLabels.RileUpTheCrowd.toString());
		var choice = new PlayerInteraction(ChoiceLabels.Sit.toString(), edmona, bedroom1.bed);
		var nextNode = get(MyNodeLabels.BecomeQueenEnding.toString());
		node.add(new Edge(choice, nextNode));
	}
	
}
