package stages;

public class AccuracyEvasionStages extends StageRules {
	private static final double[] STAGES = {
			3./9, //-6
			3./8,
			3./7,
			3./6,
			3./5,
			3./4,
			3./3, //0
			4./3,
			5./3,
			6./3,
			7./3,
			8./3,
			9./3  //6
	};

	private static final int OFFSET = 6;
	private static final int MIN_STAGE = -6;
	private static final int MAX_STAGE = 6;

	public static final AccuracyEvasionStages INSTANCE = new AccuracyEvasionStages();

	private AccuracyEvasionStages() {
		super(STAGES, MIN_STAGE, MAX_STAGE, OFFSET);
	}

}
