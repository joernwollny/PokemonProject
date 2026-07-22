package status;

public abstract class AbstractStatusEffect implements IStatusEffect {

	@Override
	public boolean equals(Object obj) {
		return obj != null && obj.getClass() == this.getClass();
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
