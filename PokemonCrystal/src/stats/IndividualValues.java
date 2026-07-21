package stats;

import java.util.EnumMap;

import com.fasterxml.jackson.annotation.JsonCreator;

public class IndividualValues extends Stats{
	private static final int MAX_IV = 31;
	
	@JsonCreator
	public IndividualValues(EnumMap<Stat, Integer> stats) {
	    super(stats);
	}

	public IndividualValues(){
		super(MAX_IV);
	}
}
