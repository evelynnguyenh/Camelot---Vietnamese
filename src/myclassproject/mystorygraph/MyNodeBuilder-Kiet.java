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
	 public void KillActions() {
		 var node = get(MyNodeLabels.Kill.toString());
		 node.add(new HideDialog())
			 .add(new SetExpression(edmona, sad))
			 .add(new ShowNarration())
			 .add(new NarrationSequence("With the man dead, Edmona casts the spell to bring back her brother and father."))
			 .add(new HideNarration())
			 .add(new Cast(edmona, brother, red))
			 .add(new Cast(edmona, father, red))
			 .add(new Revive(brother))
			 .add(new Revive(father))
			 .add(new SetPosition(brother, darkforest))
			 .add(new SetPosition(father, darkforest))
			 .add(new ShowNarration())
			 .add(new NarrationSequence("Slowly, figures emerge from the light – her brother and father, returned to life."))
			 .add(new HideNarration())
			 .add(new Face(edmona, brother))
			 .add(new SetExpression(brother, surprised))
			 .add(new ShowDialog())
			 .add(new DialogSequence(brother, edmona, 
					List.of("Sister… Is this real? Are we truly back?"), 
					List.of("Yes, I did it. I brought you back.")))
			 .add(new HideDialog())
			 .add(new SetExpression(father, surprised))
			 .add(new ShowDialog())
			 .add(new DialogSequence(father, edmona, 
			 		List.of("My child… What have you done?"), 
					List.of("I saved you. No matter the cost.")))
			 .add(new HideDialog())
			 .add(new SetExpression(edmona, neutral))
			 .add(new SetExpression(brother, neutral))
			 .add(new SetExpression(father, neutral))
			 .add(new EnableInput());
	 }

	 @BuilderMethod
	 public void CorruptionEndingActions() {
		 var node = get(MyNodeLabels.CorruptionEnding.toString());
		 node.add(new HideDialog())
			 .add(new SetExpression(edmona, scared))
			 .add(new ShowNarration())
			 .add(new NarrationSequence("Edmona sees the shapes of her brother and father slowly forming from the blood of their nemesis."))
			 .add(new NarrationSequence("However, as the ritual completes, she feels something unnatural happening within her."))
			 .add(new NarrationSequence("A searing pain courses through her veins. Her eyes turn red, her hair turning gray, her body twisting into something unrecognizable."))
			 .add(new HideNarration())
			 .add(new SetEyeColor(edmona, red))
			 .add(new SetHairColor(edmona, gray))
			 .add(new SetClothing(edmona, Witch))
			 .add(new ShowNarration())
			 .add(new NarrationSequence("She kneels down, her once human form now decayed, Edmona turning a sickly witch."))
			 .add(new HideNarration())
			 .add(new Kneel(edmona))
			 .add(new SetExpression(brother, scared))
			 .add(new SetExpression(father, scared))
			 .add(new ShowDialog())
			 .add(new DialogSequence(brother, father, 
			 		List.of("What… What have you become?"), 
					List.of("This isn’t the sister we knew… Stay away!")))
			 .add(new HideDialog())
			 .add(new WalkTo(edmona, father))
			 .add(new MoveAway(edmona))
			 .add(new ShowNarration())
			 .add(new NarrationSequence("Edmona, now feared by the ones she loved most, realizes she has lost everything."))
			 .add(new HideNarration())
			 .add(new SetExpression(edmona, neutral))
			 .add(new SetExpression(brother, neutral))
			 .add(new SetExpression(father, neutral))
			 .add(new EnableInput());
	 }
	
	 @BuilderMethod
	 public void BecomeQueenEndingActions() {
		 var node = get(MyNodeLabels.BecomeQueenEnding.toString());
	 
		 node.add(new SetPosition(edmona, greathall.throne)) 
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
			 .add(new SetExpression(edmona, happy))
			 .add(new DanceTogether(edmona, noble1))
			 .add(new DanceTogether(noble2, noble3))
			 .add(new DanceTogether(noble4, noble5))
			 .add(new SetExpression(edmona, neutral));
	 }

	 @BuilderMethod
	 public void RileUpTheCrowdActions() {
		 var node = get(MyNodeLabels.RileUpTheCrowd.toString());
	 
		 node.add(new SetPosition(edmona, town)) 
			 .add(new ShowNarration())
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
			 .add(new SetExpression(edmona, neutral))
			 .add(new SetPosition(edmona, hallway))
			 .add(new EnableInput());
	 }

	 @BuilderMethod
	 public void PopulistRuleEndingActions() {
		 var node = get(MyNodeLabels.PopulistRuleEnding.toString());
	 
		 node.add(new SetPosition(edmona, bedroom1))
			 .add(new SetPosition(noble1, greathall.throne))
			 .add(new SetPosition(noble2, greathall.leftthrone))
			 .add(new SetPosition(noble3, greathall.rightthrone))
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
			 .add(new EnableInput());
	 }
}
	