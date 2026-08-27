package number;

public record Product<T>(INumber<T> a, INumber<T> b) implements INumber<T> {
	@Override
	public double evaluate(T context) {
		return a.evaluate(context)*b.evaluate(context);
	}

}
