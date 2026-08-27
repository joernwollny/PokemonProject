package effect;

public class Sequence<T> implements IEffect<T>{
	private final IEffect<T>[] effects;

	public Sequence(IEffect<T>[] effects) {
		this.effects = effects;
	}

	public void apply(T context) {
		for (IEffect<T> effect : effects) {
			effect.apply(context);
		}
	}
}
