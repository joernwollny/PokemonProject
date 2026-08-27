package condition;

public interface ICondition<T> {
	public boolean check(T context);
}
