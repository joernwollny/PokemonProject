package effect;

import pokemon.ActivePokemon;

public class StatusDamage implements IEffect<ActivePokemon> {

	@Override
	public void apply(ActivePokemon context) {
		context.getPokemon().incomingDamage(0);
		
	}

}
