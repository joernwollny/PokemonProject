package battleaction;

import battle.ActionContext;
import eventhandler.Prioritized;

public abstract class BattleAction implements Prioritized<BattleAction>{
	
	private final int priority;
	
	protected BattleAction(int priority) {
		this.priority = priority;
	}
	
	public abstract void prepare(ActionContext context);
	public abstract void execute();
	
	public int getPriority() {
		return priority;
	}
}
                                                                                                       