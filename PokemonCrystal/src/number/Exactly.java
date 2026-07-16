package number;

public record Exactly<T>(double number) implements INumber<T> {

	@Override
	public double evaluate(T context) {
		return number;
	}
}
