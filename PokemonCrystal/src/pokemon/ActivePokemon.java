package pokemon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import stages.BattleStages;
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
	
//	public ActivePokemon(Optional<Pokemon> optionalPokemon) {
//		if (optionalPokemon.isPresent()) {
//			this.pokemon = optionalPokemon.get();
//		}
//	}

	public int getStage(Stat stat) {
		return stages.get(stat);
	}
	
	public BattleStages getStages() {
		return stages;
	}

	private double getEffectiveMultiplier(Stat stat) {
		return stat.getRules().getMultiplier(stages.get(stat));
	}

	public double getEffectiveStat(Stat stat) {
		double multiplier = getEffectiveMultiplier(stat);
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
	
	public List<IStatusEffect> getStatus() {
		List<IStatusEffect> statusEffects = new ArrayList<>(volatiles);
		
		if (pokemon.getStatus().isPresent()) {
			statusEffects.add(pokemon.getStatus().get());
		}
		return statusEffects;
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
