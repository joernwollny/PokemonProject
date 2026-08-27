package status;

import battle.ActionContext;

public class Paralysis extends AbstractStatusEffect {

	@Override
	public boolean onMove(ActionContext action) {
		return (Math.random() > .25) ? true : false;
	}

	@Override
	public double speedModifier(ActionContext action) {
		return .5;
	}
}
