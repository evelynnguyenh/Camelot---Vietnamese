// NODE BUILDER
@BuilderMethod
public void learnDarkMagicActions() {
	var node = get(MyNodeLabels.LearnDarkMagic.toString());
	node.add(new HideDialog())
		.add(new DialogSequence(
			quentin, 
			edmona, 
			List.of(
				"Time has blurred apprentice. You've spent countless days refining the art of darkness. Your final challenge awaits. Are you prepared to take the last steps?"
			), 
			List.of("Yes, Master. Tell me what I must do.")
		));
}

@BuilderMethod
public void learnDarkMagic1Actions() {
	var node = get(MyNodeLabels.LearnDarkMagic1.toString());
	node.add(new HideDialog())
		.add(new NarrationSequence(
			"Quentin’s voice echoes with dark power. He explains that you must complete two final tasks: Journey to the Forbidden Library and Drain the forest’s essence."
		));
}

@BuilderMethod
public void learnDarkMagic2Actions() {
	var node = get(MyNodeLabels.LearnDarkMagic2.toString());
	node.add(new HideNarration())
		.add(new DialogSequence(
			quentin,
			edmona,
			List.of("These paths are yours to walk. Which will you pursue first?"),
			List.of("I shall go to the library.")
		));
}

@BuilderMethod
public void DarkMagicTrial() {
	var node = get(MyNodeLabels.SoulbindingTrial.toString());
	node.add(new HideDialog())
		.add(new SetPosition(edmona, darkforest))
		.add(new NarrationSequence(
			"All of the magical power in this forest shall be mine!"
		));
}

@BuilderMethod
public void DarkMagicTrial1() {
	var node = get(MyNodeLabels.SoulBindingTrial1.toString());
	node.add(new HideNarration())
		.add(new EnableEffect(edmona, Effects.Aura))
		.add(new Cast(edmona, edmona, Spell.purple))
		.add(new NarrationSequence(
			"Finally... although the forest is dead I'm born anew! I shall head out of the forest and seek my revenge."
		));
}

@BuilderMethod
public void DarkMagicTrial2() {
	var node = get(MyNodeLabels.SoulBindingTrial2.toString());
	node.add(new HideNarration())
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
		));
}

@BuilderMethod
public void ForbiddenLibrary1() {
	var node = get(MyNodeLabels.ForbiddenLibrary1.toString());
	node.add(new HideNarration())
		.add(new EnableInput());
}


@BuilderMethod
public void InteractTome() {
	var node = get(MyNodeLabels.ReadTome.toString());
	node.add(new HideDialog())
		.add(new NarrationSequence(
			"The ancient pages detail a forbidden ritual: to resurrect the dead, one must sacrifice a living soul. The air around you crackles with dark energy as you realize the cost of this power."
		));
}

@BuilderMethod
public void InteractTome1() {
	var node = get(MyNodeLabels.ReadTome1.toString());
	node.add(new HideNarration())
		.add(new EnableInput());
}

@BuilderMethod
public void TakeRevenge() {
	var node = get(MyNodeLabels.TakeRevenge.toString());
	node.add(new SetPosition(edmona, bedroom2));
	node.add(new DialogSequence(grimspire, edmona,
	List.of("Edmona!? How can you be here!? Guards!"),
	List.of("Your life ends here!", "You are so pathetic...")
	));
}

@BuilderMethod
public void Spare() {
	var node = get(MyNodeLabels.Spare.toString());
	node.add(new HideDialog())
		.add(new DialogSequence(grimspire, edmona,
		List.of("What are you saying? HAHAHA! You are the pathetic one. I am the King!"),
		List.of("Not for much longer!")));
}

@BuilderMethod
public void Spare1() {
	var node = get(MyNodeLabels.Spare1.toString());
	node.add(new HideDialog())
		.add(new Cast(edmona, grimspire, Spell.red))
		.add(new Die(grimspire))
		.add(new NarrationSequence("I've taken him out. I cannot use dark magic. I need to accept that my family is truly gone... There's only one thing I need to do now. I shall crown myself Queen!"));
}

@BuilderMethod
public void Spare2() {
	var node = get(MyNodeLabels.Spare2.toString());
	node.add(new HideNarration())
		.add(new EnableInput());
}

//EDGE BUILDER
@BuilderMethod
public void learnDarkMagicEdges() {
	var node = get(MyNodeLabels.LearnDarkMagic.toString());
	var choice = new DialogChoice("Yes, Master. Tell me what I must do.");
	var nextNode = get(MyNodeLabels.LearnDarkMagic1.toString());
	node.add(new Edge(choice, nextNode));
}

@BuilderMethod
public void learnDarkMagic1Edges() {
	var node = get(MyNodeLabels.LearnDarkMagic1.toString());
	var choice = new CloseNarrationChoice();
	var nextNode = get(MyNodeLabels.LearnDarkMagic2.toString());
	node.add(new Edge(choice, nextNode));
}

@BuilderMethod
public void learnDarkMagic2Edges() {
	var node = get(MyNodeLabels.LearnDarkMagic2.toString());
	var choice = new DialogChoice("I shall go to the library.");
	var nextNode = get(MyNodeLabels.ForbiddenLibrary.toString());
	node.add(new Edge(choice, nextNode));
}

// DIFFERENT PLACE IN EDGE BUILDER
@BuilderMethod
public void LeaveForest() {
	var node = get(MyNodeLabels.SoulbindingTrial.toString());
	var choice = new CloseNarrationChoice();
	var nextNode = get(MyNodeLabels.SoulBindingTrial1.toString());
	node.add(new Edge(choice, nextNode));
}

@BuilderMethod
public void LeaveForest1() {
	var node = get(MyNodeLabels.SoulBindingTrial1.toString());
	var choice = new CloseNarrationChoice();
	var nextNode = get(MyNodeLabels.SoulBindingTrial2.toString());
	node.add(new Edge(choice, nextNode));
}

@BuilderMethod
public void LeaveForest2() {
	var node = get(MyNodeLabels.SoulBindingTrial2.toString());
	var LeavePath = new PlayerInteraction(
		edmona,
		MyChoiceLabels.ToGrimspire.toString(),
		forestexit
	);
	var nextNode = get(MyNodeLabels.TakeRevenge.toString());
	node.add(new Edge(LeavePath, nextNode));
}

// DIFFERENT PLACE IN EDGE BUILDER

@BuilderMethod
public void forbiddenLibraryEdges() {
	var node = get(MyNodeLabels.ForbiddenLibrary.toString());
	var choice = new CloseNarrationChoice();
	var nextNode = get(MyNodeLabels.ForbiddenLibrary1.toString());
	node.add(new Edge(choice, nextNode));
}

@BuilderMethod
public void forbiddenLibrary1Edges() {
	var node = get(MyNodeLabels.ForbiddenLibrary1.toString());
	var readSpellbookChoice = new PlayerInteraction(
		MyChoiceLabels.Read.toString(), 
		libraryspellbook,
		PlayerInteraction.Icons.research,
		"Inspect the necromantic tome"
	);

	var nextNode = get(MyNodeLabels.ReadTome.toString());
	node.add(new Edge(readSpellbookChoice, nextNode));
}

@BuilderMethod
public void LeaveLibrary() {
	var node = get(MyNodeLabels.ReadTome.toString());
	var choice = new CloseNarrationChoice();
	var nextNode = get(MyNodeLabels.ReadTome1.toString());
	node.add(new Edge(choice, nextNode));
}

@BuilderMethod
public void LeaveLibrary1() {
	var node = get(MyNodeLabels.ReadTome1.toString());
	var DoorExit = new PlayerInteraction(
		MyChoiceLabels.LeaveLibrary.toString(), 
		door,
		PlayerInteraction.Icons.exit,
		"To the next trial"
	);

	var nextNode = get(MyNodeLabels.SoulbindingTrial.toString());
	node.add(new Edge(DoorExit, nextNode));
}

// NODE LABELS

LearnDarkMagic1, SoulBindingTrial1, SoulBindingTrial2, ForbiddenLibrary1, ReadTome1, Spare1, Spare2