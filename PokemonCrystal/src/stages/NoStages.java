package stages;

public class NoStages extends StageRules {

	private static final double[] STAGES = {1.};
	private static final int MIN_STAGE = 0;
	private static final int MAX_STAGE = 0;
	
	public static final NoStages INSTANCE = new NoStages();

	private NoStages() {
		super(STAGES, MIN_STAGE, MAX_STAGE);
	}
}
