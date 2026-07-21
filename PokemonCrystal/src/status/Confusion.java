package status;

import battle.ActionContext;
import effect.ConfusionDamage;
import pokemon.ActivePokemon;
import pokemon.Pokemon;

public class Confusion implements IStatusEffect {

	private static final int MIN_ROUNDS_CONFUSED = 1, MAX_ROUNDS_CONFUSED = 4;
	private static final int DELTA = MAX_ROUNDS_CONFUSED - MIN_ROUNDS_CONFUSED + 1;
	private int roundsToConfuse = MIN_ROUNDS_CONFUSED + (int) (Math.random() * DELTA);
	
	@Override
	public boolean onMove(ActionContext action) {
		if (roundsToConfuse <= 0) {
			action.user().removeStatus(this);
			return true;
		}
		
		boolean canMove = Math.random() > .33;

		if (!canMove) {
			//40 basepower typeless physical can't crit
			new ConfusionDamage().apply(action.user());
		}

		return canMove;
	}

	@Override
	public void onTurnEnd(ActivePokemon pokemon) {
		roundsToConfuse--;
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
