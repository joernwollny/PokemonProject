package status;

import pokemon.ActivePokemon;
import pokemon.Pokemon;
import stats.Stat;

public class Poison extends AbstractStatusEffect {
	@Override
	public void onTurnEnd(ActivePokemon pokemon) {
		pokemon.getPokemon().incomingDamage((int) pokemon.getEffectiveStat(Stat.HP) / 16);
	}

	@Override
	public void onWalking(Pokemon pokemon) {
		pokemon.incomingDamage(1);
	}
}
