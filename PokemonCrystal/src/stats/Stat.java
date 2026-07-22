package stats;

import com.fasterxml.jackson.annotation.JsonProperty;

import stages.AccuracyEvasionStages;
import stages.CritStages;
import stages.StageRules;
import stages.StatStages;

public enum Stat {
	@JsonProperty("HP") HP(null, StatType.PRIMARY, "Lifepoints"),
	@JsonProperty("ATK") ATK(StatStages.INSTANCE, StatType.PRIMARY, "Attack"),
	@JsonProperty("DEF") DEF(StatStages.INSTANCE, StatType.PRIMARY, "Defense"),
	@JsonProperty("SPATK") SPATK(StatStages.INSTANCE, StatType.PRIMARY, "Special Attack"),
	@JsonProperty("SPDEF") SPDEF(StatStages.INSTANCE, StatType.PRIMARY, "Special Defense"),
	@JsonProperty("SPEED") SPEED(StatStages.INSTANCE, StatType.PRIMARY, "Speed"),
	ACCURACY(AccuracyEvasionStages.INSTANCE, StatType.DERIVATIVE, "Accuracy"),
	EVASION(AccuracyEvasionStages.INSTANCE, StatType.DERIVATIVE, "Evasion"),
	CRIT(CritStages.INSTANCE, StatType.DERIVATIVE, "Crit Chance");

	private final StageRules stages;
	private final StatType type;
	private final String string;

	Stat(StageRules stages, StatType type, String string) {
		this.stages = stages;
		this.type = type;
		this.string = string;
	}

	public StageRules getRules() {
		return stages;
	}

	public boolean isPrimary() {
		return type.equals(StatType.PRIMARY);
	}
	
	public boolean isDerivative() {
		return type.equals(StatType.DERIVATIVE);
	}
	
	public String getString() {
		return string;
	}
}