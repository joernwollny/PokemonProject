package attempt;

import context.MoveContext;
import move.Target;

/**
 * interrupt on miss
 */
public class Cascade extends Attempt {
	
	private MoveInstance[] instances;
	
	public Cascade(MoveInstance[] instances, Target target) {
		super(target);
		this.instances = instances;
	}
	
	public boolean execute(MoveContext battle) {
		boolean hit;
		
		for (MoveInstance instance : instances) {
			hit = instance.execute(battle);
			
			if (hit == false) {
				return false;
			}
		}
		return true;
	}
}
