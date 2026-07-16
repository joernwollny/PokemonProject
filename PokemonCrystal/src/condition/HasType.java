package condition;

import java.util.Arrays;

import pokemon.ActivePokemon;
import pokemon.Type;

public record HasType(Type type) implements ICondition<ActivePokemon> {

	@Override
	public boolean check(ActivePokemon context) {
		return Arrays.asList(context.getPokemon().getSpecies().types()).contains(type);
	}

}
