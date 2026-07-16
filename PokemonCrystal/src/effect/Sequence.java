package effect;

import battle.Battle;

public class Sequence implements IEffect{
	private final IEffect[] effects;

	public Sequence(IEffect[] effects) {
		this.effects = effects;
	}

	public void apply(Battle battle) {
		for (IEffect effect : effects) {
			effect.apply(battle);
		}
	}
}
