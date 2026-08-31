package effect;

import context.MoveContext;
import number.INumber;
import pokemon.ActivePokemon;

public record FlatDamage(INumber<ActivePokemon> damage) implements IEffect<MoveContext> {

	@Override
	public void apply(MoveContext context) {
		for (ActivePokemon pokemon : context.targets()) {
			pokemon.getPokemon().incomingDamage((int)damage.evaluate(null));
		}

	}

}
