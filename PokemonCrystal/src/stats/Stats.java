package stats;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;

abstract class Stats {
	protected final EnumMap<Stat, Integer> stats;

	@JsonCreator
	public Stats(EnumMap<Stat, Integer> stats) {
		this.stats = stats;
	}
	
	public Stats() {
		//initialized er mit 0??? oder null??
		this.stats = new EnumMap<>(Stat.class);
	}

	public Stats(int max) {
		this();
		for (Stat stat : Stat.values()) {
			stats.put(stat, (int) Math.random()*max);
		}
	}

	public Stats(int hp, int atk, int def, int spAtk, int spDef, int speed) {
		this();
		stats.put(Stat.HP, hp);
		stats.put(Stat.ATK, atk);
		stats.put(Stat.DEF, def);
		stats.put(Stat.SPATK, spAtk);
		stats.put(Stat.SPDEF, spDef);
		stats.put(Stat.SPEED, speed);
	}

	public Stats(Map<Stat, Integer> stats){
		this.stats = (EnumMap<Stat, Integer>) stats;
	}

	public int getStat(Stat stat) {
		return stats.getOrDefault(stat, 0);
	}
	
	public String getPrimary() {
		return stats.entrySet().stream()
				.filter(k -> k.getKey().isPrimary())
				.map(Map.Entry::getValue)
				.collect(Collectors.toList())
				.toString();
	}
}
