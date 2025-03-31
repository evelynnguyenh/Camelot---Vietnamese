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
	public void quentinStudentEdges() {
		var node = get(MyNodeLabels.QuentinStudent.toString());
		var choice = new DialogChoice("I am ready, Master Quentin.");
		var nextNode = get(MyNodeLabels.LearnDarkMagic.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void learnDarkMagicEdges() {
		var node = get(MyNodeLabels.LearnDarkMagic.toString());
		var choice = new DialogChoice("Visit The Forbidden Library");
		var nextNode = get(MyNodeLabels.ForbiddenLibrary.toString());
		node.add(new Edge(libraryChoice, libraryNode));
	}

	@BuilderMethod
	public void forbiddenLibraryEdges() {
		var node = get(MyNodeLabels.ForbiddenLibrary.toString());
		
		var readSpellbookChoice = new PlayerInteraction(
			MyChoiceLabels.Read.toString(), 
			spellbook,
			PlayerInteraction.Icons.research,
			"Inspect the necromantic tome"
		);

		var nextNode = get(MyNodeLabels.ReadTome.toString());
		node.add(new Edge(readSpellbookChoice, nextNode));
	}

	public void LeaveLibrary() {
		var node = get(MyNodeLabels.ReadTome.toString());
		
		var readSpellbookChoice = new PlayerInteraction(
			MyChoiceLabels.Read.toString(), 
			spellbook,
			PlayerInteraction.Icons.research,
			"Inspect the necromantic tome"
		);

		var nextNode = get(MyNodeLabels.ReadTome.toString());
		node.add(new Edge(readSpellbookChoice, nextNode));
	}


}
