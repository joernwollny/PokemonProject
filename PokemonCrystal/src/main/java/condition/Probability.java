package condition;

import context.ActionContext;
import number.INumber;

public record Probability(INumber<ActionContext> number) implements ICondition<ActionContext>{

	@Override
	public boolean check(ActionContext context) {
		return Math.random() < number.evaluate(context);
	}
}
