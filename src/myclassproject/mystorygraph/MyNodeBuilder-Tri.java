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
	public void learnDarkMagicActions() {
		var node = get(MyNodeLabels.LearnDarkMagic.toString());
		node.add(new HideDialog())
			.add(new DialogSequence(
				quentin, 
				edmona, 
				List.of(
					"Time has blurred, apprentice. You've spent countless days refining the art of darkness.",
					"Your final challenge awaits. Are you prepared to take the last steps?"
				), 
				List.of("Yes, Master. Tell me what I must do.")
			))
			.add(new HideDialog())
			.add(new NarrationSequence(
				"Quentin’s voice echoes with dark power. He explains that you must complete two final tasks:\n"
				+ "1) Journey to the Forbidden Library to uncover a necromantic tome.\n"
				+ "2) Drain the forest’s essence, watching it wither as your own strength grows."
			))
			.add(new DialogSequence(
				quentin,
				edmona,
				List.of("These paths are yours to walk. Which will you pursue first?"),
				List.of("I shall go to the library.")
			))
			.add(new EnableInput());
	}



	@BuilderMethod
	public void DarkMagicTrial() {
		var node = get(MyNodeLabels.)
	}

	public void ForbiddenLibrary() {
		var node = get(MyNodeLabels.ForbiddenLibrary.toString());
		node.add(new HideDialog())
			.SetPosition(edmona, library, door)
			.add(new NarrationSequence(
				"I must find the tome!"
			)).add(new HideNarration)
			.add(new EnableInput());
	}

	public void InteractTome() {
		var node = get(MyNodeLabels.ReadTome.toString());
		node.add(new HideDialog())
			.add(new NarrationSequence(
				"The ancient pages detail a forbidden ritual: to resurrect the dead, one must sacrifice a living soul.\n" +
				"The air around you crackles with dark energy as you realize the cost of this power."
			))
			.add(new HideNarration())
			.add(new EnableInput());
	}

	public void TakeRevenge() {

	}

	public void Spare() {

	}
}