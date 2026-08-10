package eventhandler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import battleaction.BattleAction;

public class EventHandler{

//	private final PriorityQueue<BattleAction> queue = new PriorityQueue<>(Comparator.comparing(BattleAction::getPriority));
	private final List<BattleAction> events = new ArrayList<>();
	
	public void add(BattleAction event) {
		events.add(event);
	}
	
	public void execute() {
		while (!events.isEmpty()) {
			events.sort(Comparator.comparing(BattleAction::getPriority));
			events.removeFirst().execute();
		}
	}
}
