package status;

import context.ActionContext;

public class Freeze extends AbstractStatusEffect {

	@Override
	public boolean onMove(ActionContext action) {
		return false;
	}
}
