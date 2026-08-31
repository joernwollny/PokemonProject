package attempt;

import context.MoveContext;
import move.Target;

public abstract class Attempt {
	private final Target target;
	
	Attempt (Target target) {
		this.target = target;
	}
	
	public Target getTarget() {
		return target;
	}
	
	public abstract boolean execute(MoveContext action);
}
