package effect;

import battle.ActionContext;

public record NoEffect() implements IEffect<ActionContext> {

	@Override
	public void apply(ActionContext battle) {
		// do noting

	}

}
