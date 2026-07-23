package attempt;

import battle.ActionContext;
import condition.ICondition;
import condition.Probability;
import effect.IEffect;
import effect.NoEffect;
import number.Exactly;

public record Instance(
		ICondition<ActionContext> accuracy,
		IEffect<ActionContext> before,
		IEffect<ActionContext> onHit,
		IEffect<ActionContext> onMiss,
		IEffect<ActionContext> after) implements Attempt{
	public Instance(Builder builder) {
		this(builder.accuracy, builder.before, builder.onHit, builder.onMiss, builder.after);
	}

	public static class Builder{
		private ICondition<ActionContext> accuracy = new Probability(new Exactly<>(1.));
		private IEffect<ActionContext> before, onHit, onMiss, after = new NoEffect();

		public Builder setAccuracy(ICondition<ActionContext> accuracy) {
			this.accuracy = accuracy;
			return this;
		}

		public Builder setBefore(IEffect<ActionContext> before) {
			this.before = before;
			return this;
		}

		public Builder setOnHit(IEffect<ActionContext> onHit) {
			this.onHit = onHit;
			return this;
		}

		public Builder setOnMiss(IEffect<ActionContext> onMiss) {
			this.onMiss = onMiss;
			return this;
		}

		public Builder setAfter(IEffect<ActionContext> after) {
			this.after = after;
			return this;
		}
	}

	@Override
	public boolean execute(ActionContext battle) {
		boolean hit;
		
		before.apply(battle);
		if (accuracy.check(battle)) {
			onHit.apply(battle);
			hit = true;
		} else {
			onMiss.apply(battle);
			hit = false;
		}
		after.apply(battle);
		return hit;
	}
}
