package condition;

import pokemon.ActivePokemon;
import status.StatusCondition;

public record IsStatus(StatusCondition status) implements ICondition<ActivePokemon> {

	@Override
	public boolean check(ActivePokemon context) {
		return context.getStatus().contains(status);
	}

}
