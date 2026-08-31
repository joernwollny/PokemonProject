package attempt;

import condition.ICondition;
import context.MoveContext;
import effect.IEffect;
import move.Target;

public class MoveInstance extends Attempt{

	private final IEffect<MoveContext> effect;
	private final ICondition<MoveContext> condition;

	public MoveInstance(IEffect<MoveContext> effect, ICondition<MoveContext> condition, Target target) {
		super(target);
		this.effect = effect;
		this.condition = condition;
	}
	
	@Override
	public boolean execute(MoveContext battle) {
		if (condition.check(battle)) {
			effect.apply(battle);
			return true;
		}
		return false;
	}
}
