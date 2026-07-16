package stages;

public class StatStages extends StageRules {
	private static final double[] STAGES = {
			2./8, //-6
			2./7,
			2./6,
			2./5,
			2./4,
			2./3,
			2./2, //0
			3./2,
			4./2,
			5./2,
			6./2,
			7./2,
			8./2  //6
	};

	private static final int OFFSET = 6;
	private static final int MIN_STAGE = -6;
	private static final int MAX_STAGE = 6;

	public static final StatStages INSTANCE = new StatStages();

	private StatStages() {
		super(STAGES, MIN_STAGE, MAX_STAGE, OFFSET);
	}
}
