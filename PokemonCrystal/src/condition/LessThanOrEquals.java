package condition;

import battle.Battle;
import number.INumber;

//ka
public record LessThanOrEquals(ICondition<INumber> a) implements ICondition<Battle> {
	@Override
	public boolean check(Battle battle) {
		return a.check(null));
	}
}
