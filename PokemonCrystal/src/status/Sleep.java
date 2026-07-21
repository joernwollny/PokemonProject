package status;

import battle.ActionContext;
import pokemon.ActivePokemon;

public class Sleep implements IStatusEffect {

	private static final int MIN_ROUNDS_SLEEP = 1, MAX_ROUNDS_SLEEP = 4;
	private static final int DELTA = MAX_ROUNDS_SLEEP - MIN_ROUNDS_SLEEP + 1;
	private int roundsToSleep = MIN_ROUNDS_SLEEP + (int) (Math.random() * DELTA);

	@Override
	public void onTurnEnd(ActivePokemon pokemon) {
		roundsToSleep--;
	}

	@Override
	public boolean onMove(ActionContext action) {
		return roundsToSleep <= 0;
	}
	
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		
		//specifically NOT checking for roundsToConfuse, because of Set volatiles in ActivePokemon
		return true;
	}
}
