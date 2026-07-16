package attempt;

import battle.ActionContext;
import condition.ICondition;
import effect.IEffect;
import number.INumber;

public record Combo(ICondition<ActionContext> accuracy, INumber<ActionContext> hits, IEffect<ActionContext> effect) implements Attempt{
	@Override
	public boolean execute(ActionContext battle) {
		if (accuracy.check(battle)) {
			for (int i = 0; i < hits.evaluate(battle); i++) {
				effect.apply(battle);
			}
			return true;
		}
		return false;
	}
}
