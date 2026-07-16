package number;

import battle.Battle;

public record Sum(INumber a, INumber b) implements INumber {
	@Override
	public double evaluate(Battle battle) {
		return a.evaluate(battle)+b.evaluate(battle);
	}

}
