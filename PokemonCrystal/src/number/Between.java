package number;

public record Between<T>(INumber<T> lower, INumber<T> upper) implements INumber<T> {
	public Between(double low, double high) {
		this(new Exactly<>(low), new Exactly<>(high));
	}

	@Override
	public double evaluate(T context) {
		double delta = upper.evaluate(context) - lower.evaluate(context);
		return lower.evaluate(context) + Math.random() * delta;
	}

}
