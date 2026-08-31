package status;

import context.ActionContext;
import pokemon.ActivePokemon;

public class Flinch extends AbstractStatusEffect {

	@Override
	public boolean onMove(ActionContext action) {
		return false;
	}

	@Override
	public void onTurnEnd(ActivePokemon pokemon) {
		pokemon.removeStatus(this);
	}
}
