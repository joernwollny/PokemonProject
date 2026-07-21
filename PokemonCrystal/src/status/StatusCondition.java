package status;

import java.util.function.Supplier;

public enum StatusCondition {
	NO_EFFECT(null, StatusType.PERSISTENT),
	BURN(Burn::new, StatusType.PERSISTENT),
	FREEZE(Freeze::new, StatusType.PERSISTENT),
	PARALYSIS(Paralysis::new, StatusType.PERSISTENT),
	POISON(Poison::new, StatusType.PERSISTENT),
	BAD_POISON(BadPoison::new, StatusType.PERSISTENT),
	SLEEP(Sleep::new, StatusType.PERSISTENT),
	FLINCH(Flinch::new, StatusType.VOLATILE),
	CONFUSION(Confusion::new, StatusType.VOLATILE);

	private final Supplier<IStatusEffect> factory;
	private final StatusType type;

	StatusCondition(Supplier<IStatusEffect> factory, StatusType type) {
		this.factory = factory;
		this.type = type;
	}

	public IStatusEffect create() {
		return factory.get();
	}
	
	public boolean isPersistent() {
		return type.equals(StatusType.PERSISTENT);
	}
	
	public boolean isVolatile() {
		return type.equals(StatusType.VOLATILE);
	}
}
