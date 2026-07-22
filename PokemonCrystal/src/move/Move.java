package move;

import java.util.EnumSet;

import attempt.Attempt;
import battle.ActionContext;
import pokemon.Type;

public record Move(String name, Type type, Category category, PowerPoints pp, int priority, EnumSet<Flag> flags, Attempt attempt) {

	public boolean isUseable() {
		return pp.isAvailable();
	}

	public void execute(ActionContext battle) {
		attempt.execute(battle);
	}

	public boolean isPhysical() {
		return category.equals(Category.PHYSICAL);
	}

}
