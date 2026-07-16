package condition;

import battle.ActionContext;
import number.INumber;

//unsicher
public record Probability(INumber number) implements ICondition<ActionContext>{

	@Override
	public boolean check(ActionContext context) {
		return Math.random() < number.evaluate(context);
	}
}
