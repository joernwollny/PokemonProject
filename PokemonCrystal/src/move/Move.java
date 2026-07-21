package move;

import java.util.EnumSet;

import attempt.Attempt;
import battle.ActionContext;
import battle.Battle;
import pokemon.Type;

public record Move(String name, Type type, Category category, PowerPoints pp, int priority, EnumSet<Flag> flags, Attempt attempt) {
//	private final String name;
//	private final Type type;
//	private final Category category;
////	private final Target target;
////	private final int power;
////	private final double accuracy;
//	private final PowerPoints pp;
//	private final int priority;
//	private final EnumSet<Flag> flags;
	//WithPrecondition https://youtu.be/CyRtTwKeulE?si=8gCXSnT3pHQqQDvr&t=387
	//WithApplicability

//	public Move(String name, Type type, Category category, Target target, int power, double accuracy, PowerPoints pp, int priority, EnumSet<Flag> flags) {
//		this.name = name;
//		this.type = type;
//		this.category = category;
//		this.target = target;
//		this.power = power;
//		this.accuracy = accuracy;
//		this.pp = pp;
//		this.priority = priority;
//		this.flags = flags;
//	}

	public boolean isUseable() {
		return pp.isAvailable();
	}

	public void execute(ActionContext battle) {
		attempt.execute(battle);
	}

	public boolean isPhysical() {
		return category == Category.PHYSICAL;
	}

//	public String getName() {
//		return name;
//	}
//
//	public Type getType() {
//		return type;
//	}
//
//	public Category getCategory() {
//		return category;
//	}
//
//	public Target getTarget() {
//		return target;
//	}
//
//	public int getPower() {
//		return power;
//	}
//
//	public double getAccuracy() {
//		return accuracy;
//	}

//	public PowerPoints getPp() {
//		return pp;
//	}
//
//	public int getPriority() {
//		return priority;
//	}
//
//	public EnumSet<Flag> getFlags() {
//		return flags;
//	}
}
