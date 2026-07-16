package stats;

import com.fasterxml.jackson.annotation.JsonProperty;

import stages.AccuracyEvasionStages;
import stages.CritStages;
import stages.StageRules;
import stages.StatStages;

public enum Stat {
	@JsonProperty("HP") HP(null, "Leben"),
	@JsonProperty("ATK") ATK(StatStages.INSTANCE, "Angriff"),
	@JsonProperty("DEF") DEF(StatStages.INSTANCE, "Verteidigung"),
	@JsonProperty("SPATK") SPATK(StatStages.INSTANCE, "Spezial-Angriff"),
	@JsonProperty("SPDEF") SPDEF(StatStages.INSTANCE, "Spezial-Verteidigung"),
	@JsonProperty("SPEED") SPEED(StatStages.INSTANCE, "Initiative"),
	ACCURACY(AccuracyEvasionStages.INSTANCE, null),
	EVASION(AccuracyEvasionStages.INSTANCE, null),
	CRIT(CritStages.INSTANCE, null);

	private final StageRules stages;
	private final String string;

	Stat(StageRules stages, String string) {
		this.stages = stages;
		this.string = string;
	}

	public StageRules getStages() {
		return stages;
	}

	public String getString() {
		return string;
	}
	
	public boolean isPrimary() {
		return string != null;
	}
	
	public boolean isDerivative() {
		return string == null;
	}
}