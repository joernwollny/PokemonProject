package status;

import battle.ActionContext;

public class Freeze implements IStatusEffect {

	@Override
	public boolean onMove(ActionContext action) {
		return false;
	}
}
