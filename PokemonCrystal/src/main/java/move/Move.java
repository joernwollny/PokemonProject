package move;

import java.util.EnumSet;

import attempt.Attempt;
import context.MoveContext;
import pokemon.Type;

public record Move(String name, Type type, Category category, PowerPoints pp, int priority, EnumSet<Flag> flags, Attempt attempt) {

	public Move {
		flags = EnumSet.copyOf(flags);
	}
	
	public void execute(MoveContext context) {
		attempt.execute(context);
	}

	public boolean isUseable() {	return pp.isAvailable();	}
	public boolean isPhysical() {	return category.equals(Category.PHYSICAL);	}
	public boolean isSpecial() {	return category.equals(Category.SPECIAL);	}
	
	@Deprecated //"Target has to be inside the attempt"
	public Target getDefaultTarget() {
		return Target.ENEMY;
	}
	
	public boolean flagPresent(Flag flag) {
		return flags.contains(flag);
	}
}
