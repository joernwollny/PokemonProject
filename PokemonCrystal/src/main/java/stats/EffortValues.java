package stats;

import java.util.EnumMap;

import com.fasterxml.jackson.annotation.JsonCreator;

public class EffortValues extends Stats{
	static private final int MAX_EV_IN_STAT = 252, MAX_EV_TOTAL = 510;
	
	@JsonCreator
	public EffortValues(EnumMap<Stat, Integer> stats) {
	    super(stats);
	}
	
	public EffortValues() {
		super();
	}

	public void add(Stat stat, int amount) throws IllegalArgumentException {
		if (amount < 0) {
			throw new IllegalArgumentException("Add amount has to be positive. Given amount: " + amount);
		}

		int sumOfEVs = stats.values().stream().mapToInt(Integer::intValue).sum();

		// EV maxed out
		if (sumOfEVs >= MAX_EV_TOTAL) {
			return;
		}

		// EV will max out
		if (amount + sumOfEVs > MAX_EV_TOTAL) {
			amount = MAX_EV_TOTAL - sumOfEVs;
		}

		stats.put(stat, Math.min(stats.get(stat), MAX_EV_IN_STAT));
	}

	public void add(EnumMap<Stat, Integer> ev) {
		for (Stat stat : Stat.values()) {
			add(stat, ev.get(stat));
		}
	}
}
