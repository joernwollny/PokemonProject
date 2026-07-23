package effect;

import pokemon.ActivePokemon;
import stats.Stat;

public class StatusDamage implements IEffect<ActivePokemon> {

	@Override
	public void apply(ActivePokemon context) {
		int damage = (int)(context.getEffectiveStat(Stat.HP) /16);
		context.getPokemon().incomingDamage(damage);
		
	}

}
