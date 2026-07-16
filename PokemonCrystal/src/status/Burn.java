package status;

import battle.ActionContext;
import pokemon.Pokemon;
import stats.Stat;

public class Burn implements IStatusEffect {

	@Override
	public double damageModifier(ActionContext action) {
		return action.move().isPhysical() ? .5 : 1.0;
	}
	@Override
	public void onTurnEnd(Pokemon pokemon) {
		pokemon.incomingDamage((int) pokemon.getEffectiveStat(Stat.HP) / 16);
	}
}
