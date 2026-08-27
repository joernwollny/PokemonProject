package condition;

public class Not<T> implements ICondition<T>{
	private final ICondition<T> a;

	public Not(ICondition<T> a) {
		this.a = a;
	}

	@Override
	public boolean check(T thing) {
		return !a.check(thing);
	}
}
