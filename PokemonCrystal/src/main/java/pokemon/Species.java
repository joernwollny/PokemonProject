package pokemon;

import java.util.List;
import java.util.Objects;

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
		//maybe Name seperate
		@JsonProperty("name") String name,
		//maybe TypePair seperate
		@JsonProperty("types") List<Type> types,
		@JsonProperty("baseStats") BaseStats base,
		@JsonProperty("effortValues") EffortValues evOnFaint){

	public Species {
		types = List.copyOf(types);
		
		// ID can't be null as it is primitive
		Objects.requireNonNull(name, "name must not be null");
		Objects.requireNonNull(types, "types must not be null");
		Objects.requireNonNull(base, "base must not be null");
		Objects.requireNonNull(evOnFaint, "ev must not be null");
		
		if (pokedexId <= 0) {
			throw new IllegalArgumentException("ID can't be negative");
		}
		if (types.size() < 1 || types.size() > 2) {
			throw new IllegalArgumentException("Only 1 or 2 Types allowed");
		}
		if (types.get(0) == Type.NO_TYPE) {
			throw new IllegalArgumentException("No Type given");
		}
		if (types.size() == 2 && types.get(0) == types.get(1)) {
			throw new IllegalArgumentException("Both Types are identical");
		}
		if (name.length() <= 0) {
			throw new IllegalArgumentException("Name must contain characters");
		}
		if (!name.chars().allMatch(Character::isLetter)) {
			throw new IllegalArgumentException("Name must only contain letters");
		}
	}
	
	public boolean hasTwoTypes() {
		return types.size() > 1 && types.get(1) != Type.NO_TYPE;
	}

	public Type getPrimaryType() {
		return types.get(0);
	}

	public Type getSecondaryType() {
		return (hasTwoTypes()) ? types.get(1) : Type.NO_TYPE;
	}
}