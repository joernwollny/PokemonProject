package effect;

import number.INumber;
import pokemon.ActivePokemon;

public record FlatDamage(INumber<ActivePokemon> damage) implements IEffect<ActivePokemon> {

	@Override
	public void apply(ActivePokemon targetPokemon) {
		targetPokemon.getPokemon().inDamage(damage.evaluate(null));

	}

}
