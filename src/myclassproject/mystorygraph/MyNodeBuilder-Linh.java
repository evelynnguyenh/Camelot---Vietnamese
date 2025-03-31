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
	//Hoang Dieu Linh Nguyen
	@BuilderMethod
	public void LearnLightMagicActions() {
		var node = get(MyNodeLabels.LearnLightMagic.toString());
		node.add(new HideDialog())
		.add(new NarrationSequence("As the training commences, a flame suddenly ignites in Delphine's presence, dancing with a controlled intensity that fills the air with its heat."))
		.add(new CreateEffect(delphine, Spiralflame))
		.add(new DialogSequence(delphine, edmona, 
            List.of("I will teach you the ancient art of fire magic, a force both pure and powerful, to conquer evil",
					"But remember, fire is not merely destruction; it is warmth, light, and rebirth. Mastering it requires discipline, for its power can either heal or consume. Are you prepared to harness its potential?"
			),
            List.of("Yes, Master Delphine, I am ready.")))
	}

	@BuilderMethod
	public void LearnFireMagicActions() {
		var node = get(MyNodeLabels.LearnFireMagic.toString());
		node.add(new HideDialog())
        .add(new NarrationSequence("Edmona focuses, feeling the energy stir within her. The air shimmers as sparks flicker at her fingertips."))
		.add(new Cast(edmona))
		.add(new NarrationSequence("The flames she conjures are wild, fueled by the pain of her past. With each passing lesson, her power intensifies."))
		.add(new Clap(delphine))
		.add(new DialogSequence(delphine, edmona, 
            List.of(
                "You did really well. The flame is your tool, but be careful. Anger can consume even the strongest hearts.",
                "Harness its power, but do not let it control you, or you may lose yourself."
            ),
            List.of("I will control it, Master Delphine. I will not be consumed.")
        ))
		.add(new CreateEffect(edmona, Wildfire))
        .add(new NarrationSequence("A sphere of flame forms in Edmona’s palm, growing hotter with her resolve."))
		.add(new DialogSequence(delphine, edmona, 
            List.of(
                "I have taught you all that I can, but there are still many spells that require you to practice on your own.",
                "This is the book of inheritance, containing many powerful spells.",
				"Use it wisely."
            ),
            List.of(" am very grateful, and I will do my best.")
            List.of("I am very grateful, and I will do my best.")
        ))
		.add(new Give(delphine, SpellBook, edmona))
        .add(new NarrationSequence("Edmona stands ready, flames at her fingertips, a fierce determination in her heart."))
		.add(new EnableInput())
	}

