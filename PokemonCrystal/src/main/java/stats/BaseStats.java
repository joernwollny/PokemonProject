package stats;

import java.util.EnumMap;

import com.fasterxml.jackson.annotation.JsonCreator;

public class BaseStats extends Stats{

	@JsonCreator
	public BaseStats(EnumMap<Stat, Integer> stats) {
	    super(stats);
	}
}
