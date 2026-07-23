package effect;

import battle.ActionContext;
import pokemon.ActivePokemon;
import stats.Stat;

public class FormulaDamage implements IEffect<ActionContext> {

	private int power;
	
	public FormulaDamage(int power) {
		this.power = power;
	}
	
	@Override
	public void apply(ActionContext context) {
		ActivePokemon attacker = context.user();
		ActivePokemon defender = context.target();
		
		double critChance = attacker.getStage(Stat.CRIT)
		
		double attack = (context.move().isPhysical()) ? attacker.getEffectiveStat(Stat.ATK) : attacker.getEffectiveStat(Stat.SPATK);
		double defense = (context.move().isPhysical()) ? defender.getEffectiveStat(Stat.ATK) : defender.getEffectiveStat(Stat.SPATK);
		
		
	}

}
