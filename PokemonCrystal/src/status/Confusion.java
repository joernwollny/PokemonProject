package status;

import battle.ActionContext;
import pokemon.ActivePokemon;
import pokemon.Pokemon;

public class Confusion implements IStatusEffect {

	@Override
	public boolean onMove(ActionContext action) {
		boolean canMove = Math.random() > .5;

		if (!canMove) {
			action.user().getPokemon().incomingDamage(new ConfusionDamage());
		}

		return canMove;
	}

	@Override
	public void onTurnEnd(ActivePokemon pokemon) {
		if (Math.random() > .75) {
			pokemon.removeStatus(StatusCondition.CONFUSION);
		}
	}
}
