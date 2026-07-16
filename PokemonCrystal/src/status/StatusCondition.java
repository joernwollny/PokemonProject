package status;

import java.util.function.Supplier;

public enum StatusCondition {
	NO_EFFECT(NoEffect::new, true),
	BURN(Burn::new, true),
	FREEZE(Freeze::new, true),
	PARALYSIS(Paralysis::new, true),
	POISON(Poison::new, true),
	BAD_POISON(BadPoison::new, true),
	SLEEP(Sleep::new, true),
	FLINCH(Flinch::new, false),
	CONFUSION(Confusion::new, false);

	private final Supplier<IStatusEffect> factory;
	private final boolean persistent;
	//maybe enum statusCategory

	StatusCondition(Supplier<IStatusEffect> factory, boolean persistent) {
		this.factory = factory;
		this.persistent = persistent;
	}

	public IStatusEffect create() {
		return factory.get();
	}
	
	public boolean isPersistent() {
		return persistent;
	}
}
