package stages;

import java.util.Arrays;

import stats.Stat;

public class BattleStages {
	private final int[] stages = new int[Stat.values().length];

	public StageResult add(Stat stat, int delta) {
		if (delta == 0) {
			return StageResult.STAYS;
		}
		
		int index = stat.ordinal();
		int old = stages[index];

		StageRules rules = stat.getRules();

		if (old > rules.getMaxStage()) {
			return StageResult.MAXED;
		}
		if (old < rules.getMinStage()) {
			return StageResult.MINED;
		}
		
		int newValue = rules.clamp(old + delta);
		
		stages[index] = newValue;
		return delta > 0 ? StageResult.INCREASED : StageResult.DECREASED;
	}

	public int get(Stat stat) {
		return stages[stat.ordinal()];
	}

	public void reset() {
		Arrays.fill(stages, 0);
	}
}
