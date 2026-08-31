package effect;

import context.HitContext;
import context.MoveContext;
import pokemon.ActivePokemon;
import stats.Stat;

public record FormulaDamage(int power) implements IEffect<MoveContext> {

	@Override
	public void apply(MoveContext context) {
		ActivePokemon attacker = context.user();
		for (ActivePokemon defender : context.targets()) {
			formula(new HitContext(context.move(), attacker, defender));
		}
	}
	
	private int formula(HitContext context) {
		
		double critChance = context.user().getEffectiveStat(Stat.CRIT);
		boolean isCrit = Math.random()<critChance;
		double attack, defense;
		if (isCrit) { //ignore disadvantaged Stages
			attack = (context.move().isPhysical()) ? context.user().getEffectiveStatIgnoreNegative(Stat.ATK) : context.user().getEffectiveStatIgnoreNegative(Stat.SPATK);
			defense = (context.move().isPhysical()) ? context.target().getEffectiveStatIgnorePositive(Stat.ATK) : context.target().getEffectiveStatIgnorePositive(Stat.SPATK);
		} else {
			attack = (context.move().isPhysical()) ? context.user().getEffectiveStat(Stat.ATK) : context.user().getEffectiveStat(Stat.SPATK);
			defense = (context.move().isPhysical()) ? context.target().getEffectiveStat(Stat.ATK) : context.target().getEffectiveStat(Stat.SPATK);
		}
		
		int level = context.user().getPokemon().getLevel();
		
		double result = Math.floor(Math.floor((Math.floor(2. * level / 5)+2)*power*attack/defense)/50)+2;
		
//		result *= (context.targets().size()>1) ? .75 : 1; multitarget
//		result *= (secondStrikeOfParentalBond) ? .25 : 1;
//		result *= (weather) ? 1.5 : 1;
//		result *= (glaveRush) ? 2 : 1;
		result *= (isCrit) ? 1.5 : 1; //+edgecases
		result *= Math.random()*.15+.85;
//		result *= (stab) ? 1.5 : 1; //+edgecases
		//type
		result *= (context.user().getStatus().contains(Burn.class) && )
		//other https://bulbapedia.bulbagarden.net/wiki/Damage
		
		
		
		return (int) result;
	}
}