package effect;

import battle.ActionContext;
import move.Target;

public record For(Target target, IEffect<?> effect) implements IEffect<ActionContext> {

	@Override
	public void apply(ActionContext context) {
		effect.apply();

	}

}
