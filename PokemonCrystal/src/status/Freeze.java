package status;

import battle.ActionContext;

public class Freeze extends AbstractStatusEffect {

	@Override
	public boolean onMove(ActionContext action) {
		return false;
	}
}
