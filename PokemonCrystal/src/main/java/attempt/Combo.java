package attempt;

import condition.ICondition;
import context.MoveContext;
import effect.IEffect;
import move.Target;
import number.INumber;

public class Combo extends Attempt{
	
	private ICondition<MoveContext> accuracy;
	private INumber<MoveContext> hits;
	private IEffect<MoveContext> effect;
	
	public Combo(ICondition<MoveContext> accuracy, INumber<MoveContext> hits, IEffect<MoveContext> effect, Target target) {
		super(target);
		this.accuracy = accuracy;
		this.hits = hits;
		this.effect = effect;
	}
	
	@Override
	public boolean execute(MoveContext battle) {
		if (accuracy.check(battle)) {
			for (int i = 0; i < hits.evaluate(battle); i++) {
				effect.apply(battle);
			}
			return true;
		}
		return false;
	}
}
