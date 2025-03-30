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

}