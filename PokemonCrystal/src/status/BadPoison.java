package status;

import battle.ActionContext;
import pokemon.ActivePokemon;
import pokemon.Pokemon;
import stats.Stat;

public class BadPoison implements IStatusEffect{
	private int roundsBadPoison = 0;

	@Override
	public void onTurnEnd(ActivePokemon pokemon) {
		roundsBadPoison++;
		pokemon.getPokemon().incomingDamage((int) pokemon.getEffectiveStat(Stat.HP) * roundsBadPoison / 16);
	}

	@Override
	public void onSwitch(ActivePokemon pokemon) {
		pokemon.setStatus(StatusCondition.POISON.create());
	}
}
