package effect;

public interface IEffect<T> {
	public void apply(T context);
}
