package pokemon;

import stats.Stat;

public enum Nature {
	HARDY(Stat.ATK, Stat.ATK),
	LONELY(Stat.ATK,Stat.DEF),
	BRAVE(Stat.ATK,Stat.SPEED),
	ADAMANT(Stat.ATK,Stat.SPATK),
	NAUGHTY(Stat.ATK,Stat.SPDEF),
	BOLD(Stat.DEF,Stat.ATK),
	DOCILE(Stat.DEF,Stat.DEF),
	RELAXED(Stat.DEF,Stat.SPEED),
	IMPISH(Stat.DEF,Stat.SPATK),
	LAX(Stat.DEF,Stat.SPDEF),
	TIMID(Stat.SPEED,Stat.ATK),
	HASTY(Stat.SPEED,Stat.DEF),
	SERIOUS(Stat.SPEED,Stat.SPEED),
	JOLLY(Stat.SPEED,Stat.SPATK),
	NAIVE(Stat.SPEED,Stat.SPDEF),
	MODEST(Stat.SPATK,Stat.ATK),
	MILD(Stat.SPATK,Stat.DEF),
	QUIET(Stat.SPATK,Stat.SPEED),
	BASHFUL(Stat.SPATK,Stat.SPATK),
	RASH(Stat.SPATK,Stat.SPDEF),
	CALM(Stat.SPDEF,Stat.ATK),
	GENTLE(Stat.SPDEF,Stat.DEF),
	SASSY(Stat.SPDEF,Stat.SPEED),
	CAREFUL(Stat.SPDEF,Stat.SPATK),
	QUIRKY(Stat.SPDEF,Stat.SPDEF);


	private final Stat increasedStat;
	private final Stat decreasedStat;

	private Nature(Stat increasedStat, Stat decreasedStat){
		this.increasedStat = increasedStat;
		this.decreasedStat = decreasedStat;
	}

	public double getModifier(Stat stat) {
		double modifier = 1;

		if (stat == increasedStat) {
			modifier += .1;
		}

		if (stat == decreasedStat) {
			modifier -= .1;
		}

		return modifier;
	}
}
