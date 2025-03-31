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
		.add(new ShowNarration())
		.add(new NarrationSequence("As the training commences, a flame suddenly ignites in Delphine's presence, dancing with a controlled intensity that fills the air with its heat."))
		.add(new HideNarration())
		.add(new CreateEffect(delphine, Spiralflame))
		.add(new ShowDialog())
		.add(new DialogSequence(delphine, edmona, 
            List.of("I will teach you the ancient art of fire magic, a force both pure and powerful, to conquer evil",
					"But remember, fire is not merely destruction; it is warmth, light, and rebirth. Mastering it requires discipline, for its power can either heal or consume. Are you prepared to harness its potential?"
			),
            List.of("Yes, Master Delphine, I am ready.")))
		.add(new HideDialog())
		.add(new EnableInput());
	}

	@BuilderMethod
	public void LearnFireMagicActions() {
		var node = get(MyNodeLabels.LearnFireMagic.toString());
		node.add(new HideDialog())
		.add(new ShowNarration())
        .add(new NarrationSequence("Edmona focuses, feeling the energy stir within her. The air shimmers as sparks flicker at her fingertips."))
		.add(new HideNarration())
		.add(new Cast(edmona))
		.add(new ShowNarration())
		.add(new NarrationSequence("The flames she conjures are wild, fueled by the pain of her past. With each passing lesson, her power intensifies."))
		.add(new HideNarration())
		.add(new Clap(delphine))
		.add(new ShowDialog())
		.add(new DialogSequence(delphine, edmona, 
            List.of(
                "You did really well. The flame is your tool, but be careful. Anger can consume even the strongest hearts.",
                "Harness its power, but do not let it control you, or you may lose yourself."
            ),
            List.of("I will control it, Master Delphine. I will not be consumed.")
        ))
		.add(new HideDialog())
		.add(new CreateEffect(edmona, Wildfire))
		.add(new ShowNarration())
        .add(new NarrationSequence("A sphere of flame forms in Edmona’s palm, growing hotter with her resolve."))
		.add(new HideNarration())
		.add(new ShowDialog())
		.add(new DialogSequence(delphine, edmona, 
            List.of(
                "I have taught you all that I can, but there are still many spells that require you to practice on your own.",
                "This is the book of inheritance, containing many powerful spells.",
				"Use it wisely."
            ),
            List.of("I am very grateful, and I will do my best.")
        ))
		.add(new HideDialog())
		.add(new Give(delphine, spellbook, edmona))
		.add(new ShowNarration())
        .add(new NarrationSequence("Edmona stands ready, flames at her fingertips, a fierce determination in her heart."))
		.add(new HideNarration())
		.add(new EnableInput());
	}

	@BuilderMethod
	public void RallyActions() {
		var node = get(MyNodeLabels.Rally.toString());
		node.add(new HideDialog())
		.add(new SetPosition(edmona, town))
		.add(new LookAt(edmona, noble1))
		.add(new LookAt(edmona, noble2))
		.add(new LookAt(edmona, noble3))
		.add(new LookAt(edmona, noble4))
		.add(new ShowNarration())
		.add(new NarrationSequence("She stands before the crowd, filled with hatred for the rule of the Grimpshire family."))
		.add(new NarrationSequence("She knows she cannot take on the kingdom alone. If her revolution is to succeed, she must gather allies—warriors, outcasts, and those who have suffered under the king's rule."))
		.add(new HideNarration())
		.add(new ShowDialog())
		.add(new DialogSequence(edmona, null, 
            List.of(
                "The time has come. But where do I begin?"
            ),
            List.of()))
		.add(new HideDialog())
		.add(new EnableInput());
	}

	@BuilderMethod
	public void PopulistFactionActions() {
		var node = get(MyNodeLabels.PopulistFaction.toString());
		node.add(new HideDialog())
		.add(new ShowNarration())
		.add(new NarrationSequence("In the heart of the bustling village square, Edmona stands before the leaders of the Populist Faction. Farmers, laborers, and artisans watch with wary yet hopeful eyes."))
		.add(new HideNarration())
		.add(new EnableInput())
		.add(new WalkTo(edmona, noble1))
		.add(new ShowDialog())
		.add(new DialogSequence(noble1, edmona, 
            List.of(
                "We have tilled these lands, built these homes, and forged the steel that fills the king's armory.",
                "And yet, we are treated as nothing more than expendable hands.",
                "If you truly wish to overthrow House Grimpshire, you must prove to us that you fight for the people-not just for your own vengeance."
            ),
            List.of("I do not seek vengeance alone. I seek justice for all who suffer under their rule."))
        )
		.add(new HideDialog())
		.add(new ShowNarration())
		.add(new NarrationSequence("Murmurs spread through the gathered crowd. Some nod in approval, while others cross their arms in doubt. The leader studies Edmona closely."))
		.add(new HideNarration())
		.add(new EnableInput());
	}

	@BuilderMethod
	public void PromisePopulistPowerActions() {
		var node = get(MyNodeLabels.PromisePopulistPower.toString());
		node.add(new HideDialog())
		.add(new Kneel(edmona))
		.add(new ShowNarration())
		.add(new NarrationSequence("Before the roaring crowd, Edmona kneels before the leaders of the Populist Faction, her voice steady."))
		.add(new HideNarration())
		.add(new ShowDialog())
		.add(new DialogSequence(edmona, noble1,
            List.of("I swear to you all—this land shall be ruled by its people, not by a tyrant’s bloodline."),
            List.of("Then let the banners rise. The time for chains is over!"))
        )
		.add(new HideDialog())
		.add(new Pickup(edmona, littorch))
		.add(new SetPosition(edmona, bedroom2))
		.add(new SetPosition(noble1, bedroom2))
		.add(new SetPosition(noble2, bedroom2))
		.add(new SetPosition(noble3, bedroom2))
		.add(new SetPosition(noble4, bedroom2))
		.add(new DialogSequence(grimspire, noble1, edmona,
            List.of("Who are you? How dare you come here?"),
            List.of("We have lived under your rule long enough. We will fight.")
			List.of("Let our revolution begin."))
		)
		.add(new HideDialog())
		.add(new Attack(noble1, grimspire))
		.add(new Attack(noble2, grimspire))
		.add(new Attack(noble3, grimspire))
		.add(new Attack(noble4, grimspire))
		.add(new Cast(edmona, grimspire))
		.add(new CreateEffect(edmona, Aura))
		.add(new CreateEffect(grimspire, Death))
		.add(new EnableInput());
	}
