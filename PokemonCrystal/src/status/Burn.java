package status;

import battle.ActionContext;
import effect.StatusDamage;
import pokemon.ActivePokemon;

public class Burn extends AbstractStatusEffect {

	@Override
	public double damageModifier(ActionContext action) {
		return action.move().isPhysical() ? .5 : 1.0;
	}
	@Override
	public void onTurnEnd(ActivePokemon pokemon) {
		new StatusDamage().apply(pokemon);
	}
}
