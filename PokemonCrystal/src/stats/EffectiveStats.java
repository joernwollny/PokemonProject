package stats;

import java.util.EnumMap;
import java.util.Map;

import pokemon.Nature;

public class EffectiveStats extends Stats{
	
	public EffectiveStats(BaseStats base, IndividualValues iv, EffortValues ev, int level, Nature nature) {
		super((EnumMap<Stat, Integer>) Map.of(
				Stat.HP, calcStat(Stat.HP, base, iv, ev, level, nature),
				Stat.ATK, calcStat(Stat.ATK, base, iv, ev, level, nature),
				Stat.DEF, calcStat(Stat.DEF, base, iv, ev, level, nature),
				Stat.SPATK, calcStat(Stat.SPATK, base, iv, ev, level, nature),
				Stat.SPDEF, calcStat(Stat.SPDEF, base, iv, ev, level, nature),
				Stat.SPEED, calcStat(Stat.SPEED, base, iv, ev, level, nature)
				)
			);
	}
	
	private static int calcStat(Stat stat, BaseStats bases, IndividualValues ivs, EffortValues evs, int level, Nature nature) {
		int base = bases.getStat(stat);
		int iv = ivs.getStat(stat);
		int ev = evs.getStat(stat);

		double baseCalc = Math.floor((2*base+iv+ev)*level/100);

		return (stat == Stat.HP)
		? (int) (baseCalc+10+level)
		: (int) ((baseCalc+5)*nature.getModifier(stat));
	}
}
