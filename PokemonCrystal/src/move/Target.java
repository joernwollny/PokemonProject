package move;

import battle.ActionContext;
import pokemon.ActivePokemon;

public enum Target {
	SELF,
	ENEMY,
	ALL,
	ALLY;

	public ActivePokemon getTarget(ActivePokemon user, ActivePokemon enemy) {
		switch (this) {
		case Target.SELF: return user;
		case Target.ENEMY: return enemy;
		default: return null;
		}
	}

	public ActivePokemon getTarget(ActionContext battle) {
		return this.getTarget(battle.user(), battle.receiver());
	}
}
