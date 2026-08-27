package number;

public record Quotient<T>(INumber<T> a, INumber<T> b) implements INumber<T> {

	@Override
	public double evaluate(T context) {
		if (b.evaluate(context) == 0.) {
			throw new ArithmeticException("Division by zero");
		}
		return a.evaluate(context)/b.evaluate(context);
	}

}
