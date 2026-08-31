package status;

import context.ActionContext;
import context.MoveContext;
import pokemon.ActivePokemon;
import pokemon.Pokemon;

public interface IStatusEffect {

	default boolean onMove(ActionContext action) {
		return true;
	}

	default double damageModifier(MoveContext action) {
		return 1.;
	}

	default double speedModifier(ActionContext action) {
		return 1.;
	}
	
	default void onTurnEnd(ActivePokemon pokemon) {}

	default void onApply(ActivePokemon pokemon) {}

	default void onRemove(ActivePokemon pokemon) {}

	default void onSwitch(ActivePokemon pokemon) {}

	default void onWalking(Pokemon pokemon) {}
	
	
	
}
