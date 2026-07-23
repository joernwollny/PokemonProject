package pokemon;

import java.util.HashSet;
import java.util.Set;

import stages.BattleStages;
import stages.StageResult;
import stages.StatChange;
import stats.Stat;
import status.IStatusEffect;
import status.StatusCondition;
import status.StatusResult;

public class ActivePokemon {
	private final Pokemon pokemon;
	private final BattleStages stages = new BattleStages();
	private final Set<IStatusEffect> volatiles = new HashSet<>();

	public ActivePokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

//	public int getStage(Stat stat) {
//		return stages.get(stat);
//	}
	
	public StageResult addStage(StatChange change) {
		return stages.add(change.stat(), change.delta());
	}
	
	private double getEffectiveMultiplier(Stat stat) {
		return stat.getRules().getMultiplier(stages.get(stat));
	}

	public double getEffectiveStat(Stat stat) {
		double multiplier = getEffectiveMultiplier(stat);
		//PROBLEM!!! CRIT, EVASION, ACCURACY HAVE NO STAT;
		return pokemon.getEffectiveStat(stat) * multiplier;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public double getSpeed() {
		double speed = getEffectiveStat(Stat.SPEED);
		
		for (IStatusEffect status : getStatus()) {
			speed *= status.speedModifier(null);
		}
		
		return speed + Math.random();
	}
	
	public Set<IStatusEffect> getStatus() {
		Set<IStatusEffect> allStatus = new HashSet<>(volatiles);
		pokemon.getPersistentStatus().ifPresent(s -> allStatus.add(s));
		return allStatus;
	}
	
	public StatusResult setStatus(StatusCondition status) {
		if (status.isVolatile()) {
			volatiles.add(status.create());
			return StatusResult.CHANGED;
		}
		return pokemon.setStatus(status);
	}
	
	public boolean removeStatus(IStatusEffect effect) {
		return volatiles.remove(effect);
	}
}
