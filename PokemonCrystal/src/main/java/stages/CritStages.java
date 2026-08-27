package stages;

public class CritStages extends StageRules {
	private static final double[] STAGES = {
			.0625, //0
			.125,  //+1
			.25,   //+2
			.3333, //+3
			.5};   //+4

	private static final int MIN_STAGE = 0;
	private static final int MAX_STAGE = 4;

	public static final CritStages INSTANCE = new CritStages();

	private CritStages() {
		super(STAGES, MIN_STAGE, MAX_STAGE);
	}
}
