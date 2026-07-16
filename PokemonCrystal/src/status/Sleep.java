package status;

import battle.ActionContext;
import pokemon.ActivePokemon;

public class Sleep implements IStatusEffect {

	private int roundsToSleep;

	public Sleep() {
		this.roundsToSleep = (int) (2 + Math.random() * 3);
	}

	@Override
	public void onTurnEnd(ActivePokemon pokemon) {
		roundsToSleep--;
	}

	@Override
	public boolean onMove(ActionContext action) {
		return roundsToSleep <= 0;
	}
}
