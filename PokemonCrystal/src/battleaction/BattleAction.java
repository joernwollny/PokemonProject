package battleaction;

import java.util.function.Supplier;

import game.UserSelection;

public enum BattleAction {
	FIGHT(Fight::new),
	SWITCH(Switch::new),
	BAG(Bag::new),
	FLEE(Flee::new);
	
	private final Supplier<IBattleAction> factory;
	
	BattleAction(Supplier<IBattleAction> factory) {
		this.factory = factory;
	}
	
	public IBattleAction create() {
		return factory.get();
	}
	
	public static IBattleAction getAction() {
		return BattleAction.values()[UserSelection.userInput(BattleAction.FLEE.ordinal())].create();
	}
}
