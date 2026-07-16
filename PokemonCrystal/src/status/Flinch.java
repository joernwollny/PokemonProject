package status;

import battle.ActionContext;
import pokemon.ActivePokemon;

public class Flinch implements IStatusEffect {

	@Override
	public boolean onMove(ActionContext action) {
		return false;
	}

	@Override
	public void onTurnEnd(ActivePokemon pokemon) {
		pokemon.removeStatus(StatusCondition.FLINCH);
	}
}
