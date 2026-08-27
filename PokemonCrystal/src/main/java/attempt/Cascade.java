package attempt;

import battle.ActionContext;

public record Cascade(MoveInstance[] instances) implements Attempt{
	@Override
	public boolean execute(ActionContext battle) {
		boolean hit;
		
		for (MoveInstance instance : instances) {
			hit = instance.execute(battle);
			
			//interrupt on miss
			if (hit == false) {
				return false;
			}
		}
		return true;
	}
}
