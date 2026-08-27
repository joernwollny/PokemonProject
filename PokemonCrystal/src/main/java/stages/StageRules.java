package stages;

public abstract class StageRules {
	
	private final double[] values;
	private final int minStage;
	private final int maxStage;

	private final int offset;

	protected StageRules(double[] values, int minStage, int maxStage) {
		this.values = values;
		this.minStage = minStage;
		this.maxStage = maxStage;
		this.offset = 0;
	}

	protected StageRules(double[] values, int minStage, int maxStage, int offset) {
		this.values = values;
		this.minStage = minStage;
		this.maxStage = maxStage;
		this.offset = offset;
	}

	public int getMaxStage() {
		return maxStage;
	}

	public int getMinStage() {
		return minStage;
	}

	public double getMultiplier(int stage) {
		int clamped = clamp(stage);
		return values[clamped + offset];
	}

	public int clamp(int value) {
		return Math.max(minStage, Math.min(value, maxStage));
	}
	
}
