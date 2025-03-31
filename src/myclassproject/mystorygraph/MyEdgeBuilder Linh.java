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

	//Hoang Dieu Linh Nguyen
	@BuilderMethod
	public void LearnLightMagicEdges(){
		var node = get(MyNodeLabels.LearnLightMagic.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.TalkToDelphin.toString(), delphine, Icons.talk, "learn lightmagic grom Delphine");
		var nextNode = get(MyNodeLabels.LearnFireMagic.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void LearnFireMagicEdges(){
		var node = get(MyNodeLabels.LearnFireMagic.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.Exit.toString(), edmona, Icons.exit, "left forest and come to town");
		var nextNode = get(MyNodeLabels.Rally.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void RallyEdges(){
		var node = get(MyNodeLabels.Rally.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.TalkToNoble1.toString(), noble1, Icons.talk, "edmona convinces nobles to follow her");
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
}
