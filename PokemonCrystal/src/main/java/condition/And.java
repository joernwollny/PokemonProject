package condition;

public class And<T> implements ICondition<T>{
	private final ICondition<T> a, b;

	public And(ICondition<T> a, ICondition<T> b){
		this.a = a;
		this.b = b;
	}

	@Override
	public boolean check(T thing) {
		return a.check(thing) & b.check(thing);
	}
}
