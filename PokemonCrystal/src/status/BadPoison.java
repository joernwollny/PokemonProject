package status;

import pokemon.ActivePokemon;
import stats.Stat;

public class BadPoison extends AbstractStatusEffect {
	
	private int roundsBadPoison = 0;

	@Override
	public void onTurnEnd(ActivePokemon pokemon) {
		roundsBadPoison++;
		pokemon.getPokemon().incomingDamage((int) pokemon.getEffectiveStat(Stat.HP) * roundsBadPoison / 16);
	}

	@Override
	public void onSwitch(ActivePokemon pokemon) {
		pokemon.getPokemon().onSwitch();
	}
	
}
