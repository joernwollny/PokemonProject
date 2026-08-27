package eventhandler;

public class Priority implements Comparable<Priority>{
	
	private final int actionPriority;
	private int userPriority = 0; //-1 -> npc, +1 -> player
	private int movePriority = 0;
	private double pokemonPriority = 0.;
	
	public Priority(int actionPriority, int movePriority, double pokemonPriority) {
		this.actionPriority = actionPriority;
		this.movePriority = movePriority;
		this.pokemonPriority = pokemonPriority;
	}

	public Priority(int actionPriority, int userPriority) {
		this.actionPriority = actionPriority;
		this.userPriority = userPriority;
	}
	
	@Override
	public int compareTo(Priority o) {
		int result = Integer.compare(o.actionPriority, actionPriority);
		if (result != 0) return result;
		
		result = Integer.compare(o.userPriority, userPriority);
		if (result != 0) return result;
		
		result = Integer.compare(o.movePriority, movePriority);
		if (result != 0) return result;
		
		return Double.compare(o.pokemonPriority, pokemonPriority);
	}

}
