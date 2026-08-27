package effect;

import battle.Battle;
import condition.ICondition;

public class Conditional implements IEffect<Battle>{
	private final IEffect onPass;
	private final IEffect onMiss;
	private final ICondition<Battle> condition;

	public Conditional(IEffect onPass, ICondition<Battle> condition) {
		this(onPass, new NoEffect(), condition);
	}

	public Conditional(IEffect onPass, IEffect onMiss, ICondition<Battle> condition) {
		this.onPass = onPass;
		this.onMiss = onMiss;
		this.condition = condition;
	}

	@Override
	public void apply(Battle battle) {
		if (condition.check(battle)) {
			onPass.apply(battle);
		} else {
			onMiss.apply(battle);
		}

	}
}
