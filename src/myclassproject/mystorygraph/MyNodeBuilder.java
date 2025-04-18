package myclassproject.mystorygraph;

import myclassproject.mystorygraph.MyChoiceLabels;
import myclassproject.mystorygraph.MyNodeLabels;

import static myclassproject.mystorygraph.MyStoryEntities.*;

import java.util.ArrayList;
import java.util.List;

import com.actions.*;
import com.actions.Cast.Spell;
import com.actions.SetExpression.Expression;
import com.actions.utility.ShowCredits;
import com.actions.utility.ShowDialog;
import com.actions.utility.ShowNarration;
import com.sequences.*;
import com.storygraph.*;
import com.enums.*;


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

	// Kiet Huynh

    public void rootActions() {
        var root = get(MyNodeLabels.root.toString());
        root.add(new CreateAll(List.of(bedroom1, bedroom2, camp, town, lightforest, darkforest, ruins, library, hallway, sword, spellbook, littorch)))
		// initiating each character
        .add(new CreateCharacterSequence(edmona))
        .add(new CreateCharacterSequence(garry))
        .add(new CreateCharacterSequence(delphine))
        .add(new CreateCharacterSequence(quentin))
        .add(new CreateCharacterSequence(grimspire))
        .add(new CreateCharacterSequence(brother))
        .add(new CreateCharacterSequence(father))
		.add(new CreateCharacterSequence(noble1))
		.add(new CreateCharacterSequence(noble2))
		.add(new CreateCharacterSequence(noble3))
		.add(new CreateCharacterSequence(noble4))
		.add(new CreateCharacterSequence(noble5))

        // position each character
        .add(new SetPosition(edmona, bedroom1))
        .add(new SetPosition(garry, bedroom1))
        .add(new SetPosition(delphine, lightforest))
        .add(new SetPosition(quentin, lightforest))
        .add(new SetPosition(grimspire, bedroom2))
        .add(new SetPosition(brother, hallway))
        .add(new SetPosition(father, hallway))
		.add(new SetPosition(noble1, town))
		.add(new SetPosition(noble2, town))
		.add(new SetPosition(noble3, town))
		.add(new SetPosition(noble4, town))
		.add(new SetPosition(noble5, town))

        // focus camera on Edmona and show menu
        .add(new SetCameraFocus(edmona))
        .add(new ShowMenu());
    }

	@BuilderMethod
	public void BeginningSceneActions() {
		var node = get(MyNodeLabels.BeginningScene.toString());
		node.add(new HideMenu())
			.add(new EnableInput())
			.add(new DialogSequence(grimspire, edmona, 
				List.of("Your brother and father have been accused of embezzlement. They will be executed unless the stolen amount is repaid."), 
				List.of("This can't be true! We will find a way to repay the debt.")))
			.add(new NarrationSequence("The amount is too grand for Edmona's family to repay."))
			.add(new DialogSequence(garry, edmona, 
				List.of("I will save your family and pay off the debt... if you agree to become my wife and come with me."), 
				List.of("I accept your offer.", "I cannot leave my family.")));
	}

    @BuilderMethod
    public void ConsequenceActions() {
        var node = get(MyNodeLabels.Consequence.toString());
		node.add(new HideDialog()).add(new NarrationSequence("Unable to repay the debt, Edmona's brother and father are executed."))
        .add(new NarrationSequence("Royal guards storm the castle, trying to capture Edmona."))
        .add(new DialogSequence(edmona, null, 
            List.of("I must escape now!"), 
            List.of("Let's find a way...")))
        .add(new SetPosition(edmona, lightforest))
        .add(new NarrationSequence("She wakes up in a strange forest the next morning."))
		.add(new EnableInput());
	}

	 @BuilderMethod
	 public void KillActions() {
		 var node = get(MyNodeLabels.Kill.toString());
		 node.add(new HideDialog())
			 .add(new SetExpression(edmona, Expression.Sad))
			 .add(new ShowNarration())
			 .add(new NarrationSequence("With the man dead, Edmona casts the spell to bring back her brother and father."))
			 .add(new HideNarration())
			 .add(new Cast(edmona, brother, Spell.red))
			 .add(new Cast(edmona, father, Spell.red))
			 .add(new Revive(brother))
			 .add(new Revive(father))
			 .add(new SetPosition(brother, bedroom2))
			 .add(new SetPosition(father, bedroom2))
			 .add(new ShowNarration())
			 .add(new NarrationSequence("Slowly, figures emerge from the light – her brother and father, returned to life."))
			 .add(new HideNarration())
			 .add(new Face(edmona, brother))
			 .add(new SetExpression(brother, Expression.Surprised))
			 .add(new ShowDialog())
			 .add(new DialogSequence(brother, edmona, 
					List.of("Sister… Is this real? Are we truly back?"), 
					List.of("Yes, I did it. I brought you back.")))
			 .add(new HideDialog())
			 .add(new SetExpression(father, Expression.Surprised))
			 .add(new ShowDialog())
			 .add(new DialogSequence(father, edmona, 
			 		List.of("My child… What have you done?"), 
					List.of("I saved you. No matter the cost.")))
			 .add(new HideDialog())
			 .add(new SetExpression(edmona, Expression.Neutral))
			 .add(new SetExpression(brother, Expression.Neutral))
			 .add(new SetExpression(father, Expression.Neutral))
			 .add(new EnableInput());
	}

	@BuilderMethod
	 public void CorruptionEndingActions() {
		 var node = get(MyNodeLabels.CorruptionEnding.toString());
		 node.add(new HideDialog())
			 .add(new SetExpression(edmona, Expression.Scared))
			 .add(new ShowNarration())
			 .add(new NarrationSequence("Edmona sees the shapes of her brother and father slowly forming from the blood of their nemesis."))
			 .add(new NarrationSequence("However, as the ritual completes, she feels something unnatural happening within her."))
			 .add(new NarrationSequence("A searing pain courses through her veins. Her eyes turn red, her hair turning gray, her body twisting into something unrecognizable."))
			 .add(new HideNarration())
			 .add(new SetHairColor(edmona, Colors.Gray))
			 .add(new SetClothing(edmona, Clothing.Witch))
			 .add(new ShowNarration())
			 .add(new NarrationSequence("She kneels down, her once human form now decayed, Edmona turning a sickly witch."))
			 .add(new HideNarration())
			 .add(new Kneel(edmona))
			 .add(new SetExpression(brother, Expression.Scared))
			 .add(new SetExpression(father, Expression.Scared))
			 .add(new ShowDialog())
			 .add(new DialogSequence(brother, father, 
			 		List.of("What… What have you become?"), 
					List.of("This isn’t the sister we knew… Stay away!")))
			 .add(new HideDialog())
			 .add(new WalkTo(edmona, father))
			 .add(new ShowNarration())
			 .add(new NarrationSequence("Edmona, now feared by the ones she loved most, realizes she has lost everything."))
			 .add(new HideNarration())
			 .add(new SetExpression(edmona, Expression.Neutral))
			 .add(new SetExpression(brother, Expression.Neutral))
			 .add(new SetExpression(father,  Expression.Neutral))
			 .add(new ShowCredits());
	 }
	
	@BuilderMethod
	 public void BecomeQueenEndingActions() {
		 var node = get(MyNodeLabels.BecomeQueenEnding.toString());
	 
		 node.add(new SetPosition(edmona, greathall)) 
			 .add(new ShowNarration())
			 .add(new NarrationSequence("Edmona ascends the throne of Magna Vietia, her journey of struggle and sacrifice culminating in the crown."))
			 .add(new NarrationSequence("As Queen, she works tirelessly to rebuild the fractured kingdom, blending wisdom and grace into her rule."))
			 .add(new NarrationSequence("Her reign is marked by fairness and compassion, striving to heal the wounds left by House Grimpshire."))
			 .add(new NarrationSequence("Edmona begins to restore hope to her people, rebuilding the kingdom with determination."))
			 .add(new HideNarration())
			 .add(new EnableInput())
			 .add(new SetPosition(edmona, town))
			 .add(new Face(edmona, noble1))
			 .add(new ShowDialog())
			 .add(new DialogSequence(edmona, noble1, 
				 List.of("We need to restore our economy and trade routes. Your expertise will be vital."), 
				 List.of("I will help, Your Majesty. The kingdom’s prosperity must come first.")))
			 .add(new HideDialog())
			 .add(new ShowNarration())
			 .add(new NarrationSequence("Edmona works closely with her trusted nobles, putting plans into action to restore the kingdom."))
			 .add(new HideNarration())
			 .add(new SetExpression(edmona, Expression.Happy))
			 .add(new Dance(edmona, noble1))
			 .add(new Dance(noble2, noble3))
			 .add(new Dance(noble4, noble5))
			 .add(new SetExpression(edmona, Expression.Neutral))
			 .add(new ShowCredits());
	 }

	@BuilderMethod
	 public void RileUpTheCrowdActions() {
		 var node = get(MyNodeLabels.RileUpTheCrowd.toString());
	 
		 node.add(new ShowNarration())
			 .add(new NarrationSequence("Edmona stands before the gathered masses, her voice rising above the din of the market square."))
			 .add(new NarrationSequence("She speaks of freedom, justice, and a kingdom where they no longer live under the boot of House Grimpshire."))
			 .add(new HideNarration())
			 .add(new ShowDialog())
			 .add(new DialogSequence(edmona, noble1, 
				 List.of("We will no longer bow to House Grimpshire! We will fight for our freedom and justice!"), 
				 List.of("For freedom! For justice!")))
			 .add(new HideDialog())
			 .add(new ShowNarration())
			 .add(new NarrationSequence("The crowd erupts in cheers, their anger ignited into action. Armed with crude weapons but unshakable resolve, the people storm the gates."))
			 .add(new HideNarration())
			 .add(new Clap(noble1))
			 .add(new Clap(noble2))
			 .add(new Clap(noble3))
			 .add(new Clap(noble4))
			 .add(new Clap(noble5))
			 .add(new ShowNarration())
			 .add(new NarrationSequence("Edmona is crowned Queen, hailed as the people's champion who stood with them."))
			 .add(new HideNarration())
			 .add(new ShowDialog())
			 .add(new DialogSequence(edmona, noble1, 
				 List.of("Today, we begin anew. Together, we will rebuild Magna Vietia. We will rule with fairness and justice!"), 
				 List.of("Long live Queen Edmona!")))
			 .add(new HideDialog())
			 .add(new Wave(edmona))
			 .add(new SetExpression(edmona, Expression.Neutral))
			 .add(new SetPosition(edmona, bedroom1))
			 .add(new EnableInput());
	 }

	@BuilderMethod
	 public void PopulistRuleEndingActions() {
		 var node = get(MyNodeLabels.PopulistRuleEnding.toString());
	 
		 node.add(new SetPosition(noble1, greathall))
			 .add(new SetPosition(noble2, greathall))
			 .add(new SetPosition(noble3, greathall))
			 .add(new SetPosition(noble4, greathall))
			 .add(new SetPosition(noble5, greathall))
			 .add(new SetCameraFocus(noble1))
			 .add(new ShowNarration())
			 .add(new NarrationSequence("The Populist Faction keeps their promise, dismantling the remnants of House Grimpshire and abolishing the noble republic system."))
			 .add(new NarrationSequence("The kingdom becomes a council of the people, where farmers, laborers, and artisans shape its future."))
			 .add(new NarrationSequence("While the land enjoys newfound equality, conflicts arise as different factions vie for influence."))
			 .add(new NarrationSequence("Unity becomes a constant struggle as these factions fight for dominance, each with their own vision of the future."))
			 .add(new HideNarration())
			 .add(new SetPosition(edmona, town))
			 .add(new SetCameraFocus(edmona))
			 .add(new ShowNarration())
			 .add(new NarrationSequence("Edmona watches from afar, a shadow of her former self. She knows she gave the people the power they deserved,"))
			 .add(new NarrationSequence("even if it came at the cost of her own."))
			 .add(new NarrationSequence("The kingdom's fate now lies in the hands of those she once rallied, and Edmona wonders if this was truly the path to peace."))
			 .add(new HideNarration())
			 .add(new ShowCredits());
	 }


    // Hoang Dieu Linh Nguyen
    @BuilderMethod
    public void MagicForestActions() {
        var node = get(MyNodeLabels.MagicForest.toString());
        node.add(new HideDialog()).add(new NarrationSequence("During her magical forest exploration, she encounters two omnipower beings: Quentin and Delphine."))
        .add(new NarrationSequence("Quentin, a master of dark magic, promises to help her take revenge and revive her beloved brother and father within a blink of an eye."))
        .add(new DialogSequence(delphine, quentin,
            List.of("I can give you power beyond imagination. You have potential, but the choice is yours."),
			List.of("Come with me, and I will teach you the greatest power in the world."))
        .add(new DialogSequence(edmona, null,
        	List.of("I am ready to learn light magic.", "I am ready to learn dark magic."),
        	new ArrayList<String>())));

    }

    @BuilderMethod
    public void QuentinStudentActions() {
    var node = get(MyNodeLabels.QuentinStudent.toString());
    node.add(new HideDialog()).add(new NarrationSequence("Edmona has officially become Quentin's apprentice."))
        .add(new SetPosition(quentin, darkforest))
        .add(new SetPosition(edmona, darkforest))
        .add(new NarrationSequence("The air around her feels heavier, charged with dark energy as she takes her first step into the path of forbidden magic."))
        .add(new DialogSequence(quentin, edmona, 
            List.of("Now, you belong to the shadows. Your past pain will be your greatest weapon.", 
                    "Are you ready to embrace the darkness?"),
            List.of("I am ready, Master Quentin.")));
    }


	@BuilderMethod
	public void LearnLightMagicActions() {
		var node = get(MyNodeLabels.LearnLightMagic.toString());
		node.add(new HideDialog())
		.add(new ShowNarration())
		.add(new NarrationSequence("As the training commences, a flame suddenly ignites in Delphine's presence, dancing with a controlled intensity that fills the air with its heat."))
		.add(new HideNarration())
		.add(new CreateEffect(delphine, Effects.Spiralflame))
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
		.add(new CreateEffect(edmona, Effects.Wildfire))
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
		.add(new DialogSequence(grimspire, noble1,
            List.of("Who are you? How dare you come here?"),
            List.of("We have lived under your rule long enough. We will fight."))
		.add(new DialogSequence(edmona, null,
			List.of("Let our revolution begin."),
			List.of())))
		.add(new HideDialog())
		.add(new Attack(noble1, grimspire))
		.add(new Attack(noble2, grimspire))
		.add(new Attack(noble3, grimspire))
		.add(new Attack(noble4, grimspire))
		.add(new Cast(edmona, grimspire))
		.add(new CreateEffect(edmona, Effects.Aura))
		.add(new CreateEffect(grimspire, Effects.Death))
		.add(new EnableInput());
	}

	// Tri Huynh
	@BuilderMethod
	public void AcceptToGoActions() {
		var node = get(MyNodeLabels.AcceptToGo.toString());
		node.add(new HideDialog()).add(new SetPosition(edmona, hallway))
			.add(new SetPosition(garry, hallway))
			.add(new DialogSequence(father, edmona,
				List.of("Edmona, I'm really sorry that things had to be like this. Thank you for your sacrifice."),
				List.of("It's time you go with Garry, talk to him darling.")));
	}

	@BuilderMethod
	public void RunAwayActions() {
		var node = get(MyNodeLabels.RunAway.toString());
		node.add(new HideDialog())
			.add(new SetPosition(edmona, camp))
			.add(new SetPosition(garry, camp))
			.add(new SetPosition(delphine, camp))
			.add(new DialogSequence(garry, edmona,
				List.of("Do you really think I would take you as a wife? You are so stupid! HAHAHAHA"),
				List.of("I will take a nap, then I will bring you to Grimspire Castle to become a servant!")))
			.add(new NarrationSequence("I have to run!"))
			.add(new HideDialog())
			.add(new EnableInput());
	}

	@BuilderMethod
	public void DelphineTalkActions() {
		var node = get(MyNodeLabels.DelphineTalk.toString());
		
		node.add(
			new DisableInput())
			.add(new DialogSequence(
				delphine,
				edmona,
				List.of(
					"Oh you poor thing, I've been watching you from afar! I can help you, my name is Delphine.",
					"I practice the magic of light. If you become my student, I will teach you in my discipline."
				),
				List.of("Please, teach me. I need your help!")
			))
			.add(new EnableInput());
}

	@BuilderMethod
	public void DelphineStudent() {
		var node = get(MyNodeLabels.DelphineStudent.toString());
		node.add(new HideDialog()).add(new NarrationSequence("Edmona has officially become Delphine's student."))
			.add(new SetPosition(delphine, lightforest))
			.add(new SetPosition(edmona, lightforest))
			.add(new NarrationSequence("Soft sunlight filters through towering trees, and the forest hums with gentle magic. Delphine stands beside Edmona."))
			.add(new DialogSequence(quentin, edmona,
				List.of(
					"Welcome to this sacred glade. Your compassion will guide your magic here.",
					"Are you ready to learn for the good of all?"
				),
				List.of("Yes, Master Delphine, I am ready.")
			));
	}

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
		var node = get(MyNodeLabels.SoulbindingTrial.toString());
		node.add(new HideDialog())
			.add(new SetPosition(edmona, darkforest))
			.add(new NarrationSequence(
				"All of the magical power in this forest shall be mine!"
			)).add(new HideNarration())
			.add(new EnableEffect(edmona, Effects.Aura))
			.add(new Cast(edmona, edmona, Spell.purple))
			.add(new NarrationSequence(
				"Finally...although the forest is dead, I'm born anew! I shall head out of the forest and seek my revenge."
			)).add(new HideNarration())
			.add(new DisableEffect(edmona))
			.add(new EnableInput());
	}
	
	@BuilderMethod
	public void ForbiddenLibrary() {
		var node = get(MyNodeLabels.ForbiddenLibrary.toString());
		node.add(new HideDialog())
			.add(new SetPosition(edmona, library))
			.add(new NarrationSequence(
				"I must find the tome!"
			)).add(new HideNarration())
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
		var node = get(MyNodeLabels.TakeRevenge.toString());
		node.add(new SetPosition(edmona, bedroom2));
		node.add(new DialogSequence(grimspire, edmona,
		List.of("Edmona!? How can you be here!? Guards!"),
		List.of("Your life ends here!", "You are so pathetic...")
		));
	}

	public void Spare() {
		var node = get(MyNodeLabels.Spare.toString());
		node.add(new HideDialog())
			.add(new DialogSequence(grimspire, edmona,
			List.of("What are you saying? HAHAHA! You are the pathetic one. I am the King!"),
			List.of("Not for much longer!")))
			.add(new HideDialog())
			.add(new Cast(edmona, grimspire, Spell.red))
			.add(new Die(grimspire))
			.add(new NarrationSequence("I've taken him out. I cannot use dark magic, I need to accept that my family is truly gone...There's only one thing I need to do now. I shall crown myself Queen!"))
			.add(new EnableInput());
	}

}