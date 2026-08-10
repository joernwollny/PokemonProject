package battleaction;

import java.util.function.Supplier;

import game.UserSelection;

public enum BattleActionType{
	FIGHT(Fight::new),
	BAG(Bag::new),
	SWITCH(Switch::new),
	FLEE(Flee::new);
	
	private final Supplier<BattleAction> factory;
	
	BattleActionType(Supplier<BattleAction> factory) {
		this.factory = factory;
	}
	
	public BattleAction create() {
		return factory.get();
	}
	
	public static BattleAction getAction() {
		int selecion = UserSelection.userInput(BattleActionType.values().length);
		return BattleActionType.values()[selecion].create();
	}

}
