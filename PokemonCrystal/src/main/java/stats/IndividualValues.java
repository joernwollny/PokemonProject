package stats;

import java.util.EnumMap;

import com.fasterxml.jackson.annotation.JsonCreator;

public class IndividualValues extends Stats{
	private static final int IV_LIMIT = 32;
	
	@JsonCreator
	public IndividualValues(EnumMap<Stat, Integer> stats) {
	    super(stats);
	}

	public IndividualValues(){
		super(IV_LIMIT);
	}
}
