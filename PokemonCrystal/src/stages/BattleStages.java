package stages;

import java.util.Arrays;

import battle.BattleUI;
import pokemon.ActivePokemon;
import stats.Stat;

public class BattleStages {
	private final int[] stages = new int[Stat.values().length];

	public StageResult add(Stat stat, int delta) {
		int index = stat.ordinal();
		int old = stages[index];

		StageRules rules = stat.getStages();

		int newValue = old + delta;

		if (newValue > rules.getMaxStage()) {
			stages[index] = rules.getMaxStage();
			return StageResult.MAXED;
		}

		if (newValue < rules.getMinStage()) {
			stages[index] = rules.getMinStage();
			return StageResult.MINED;
		}

		stages[index] = newValue;
		//return delta > 0 ? StageResult.INCREASED : StageResult.DECREASED;
		if (delta > 0) {
			return StageResult.INCREASED;
		} else {
			return StageResult.DECREASED;
		}
	}

	public void add(Stat stat, int delta, ActivePokemon active) {
		StageResult result = add(stat, delta);
		BattleUI.printStatChange(result, stat, active.getPokemon().getSpecies().name());
	}

	public int get(Stat stat) {
		return stages[stat.ordinal()];
	}

	public void reset() {
		Arrays.fill(stages, 0);
	}
}
