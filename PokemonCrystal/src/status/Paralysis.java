package status;

import battle.ActionContext;

public class Paralysis implements IStatusEffect {

	@Override
	public boolean onMove(ActionContext action) {
		return (Math.random() > .25) ? true : false;
	}

	@Override
	public double speedModifier(ActionContext action) {
		return .5;
	}
}
