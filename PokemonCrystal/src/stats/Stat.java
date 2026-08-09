package stats;

import com.fasterxml.jackson.annotation.JsonProperty;

import stages.AccuracyEvasionStages;
import stages.CritStages;
import stages.NoStages;
import stages.StageRules;
import stages.StatStages;

public enum Stat {
	@JsonProperty("HP") HP(NoStages.INSTANCE, StatType.BASE, "Lifepoints"),
	@JsonProperty("ATK") ATK(StatStages.INSTANCE, StatType.BASE, "Attack"),
	@JsonProperty("DEF") DEF(StatStages.INSTANCE, StatType.BASE, "Defense"),
	@JsonProperty("SPATK") SPATK(StatStages.INSTANCE, StatType.BASE, "Special Attack"),
	@JsonProperty("SPDEF") SPDEF(StatStages.INSTANCE, StatType.BASE, "Special Defense"),
	@JsonProperty("SPEED") SPEED(StatStages.INSTANCE, StatType.BASE, "Speed"),
	
	ACCURACY(AccuracyEvasionStages.INSTANCE, StatType.COMBAT, "Accuracy"),
	EVASION(AccuracyEvasionStages.INSTANCE, StatType.COMBAT, "Evasion"),
	CRIT(CritStages.INSTANCE, StatType.COMBAT, "Crit Chance");

	private final StageRules stages;
	private final StatType type;
	private final String displayName;

	Stat(StageRules stages, StatType type, String string) {
		this.stages = stages;
		this.type = type;
		this.displayName = string;
	}

	public StageRules getRules() {
		return stages;
	}

	public boolean isBase() {
		return type.equals(StatType.BASE);
	}
	
	public boolean isCombat() {
		return type.equals(StatType.COMBAT);
	}
	
	@Override
	public String toString() {
		return displayName;
	}
}