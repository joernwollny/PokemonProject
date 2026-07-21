package status;

import pokemon.ActivePokemon;
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
		pokemon.setStatus(StatusCondition.POISON);
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
