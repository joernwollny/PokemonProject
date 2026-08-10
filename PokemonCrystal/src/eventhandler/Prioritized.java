package eventhandler;

public interface Prioritized<T> extends Comparable<T>{

	int getPriority();
	
	@Override
	default int compareTo(T o) {
		//highest first
		return Integer.compare(((Prioritized<?>) o).getPriority(), this.getPriority());
	}
}
