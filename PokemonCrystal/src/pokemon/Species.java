package pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;

import stats.BaseStats;
import stats.EffortValues;

//	//learnset
//	private final Gender[] genderRatio;
//	private final Abilites[] abilities;
//	private final Species[] evolutions; -level or special condition?
//	private final int captureRate;
//	private final ExperienceGroup experienceGroup;
//	private final EggGroup eggGroup;

public record Species(
		@JsonProperty("pokedexId") int pokedexId,
		@JsonProperty("name") String name,
		@JsonProperty("types") Type[] types,
		@JsonProperty("baseStats") BaseStats base,
		@JsonProperty("effortValues") EffortValues evOnFaint){

	public boolean hasTwoTypes() {
		return types.length > 1;
	}

	public Type getPrimaryType() {
		return types[0];
	}

	public Type getSecondaryType() {
		return (hasTwoTypes()) ? types[1] : Type.NO_TYPE;
	}
}