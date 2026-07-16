package pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import stages.BattleStages;
import stats.Stat;
import status.IStatusEffect;
import status.StatusCondition;

public class ActivePokemon {
	private final Pokemon pokemon;
	private final BattleStages stages = new BattleStages();
	private final List<IStatusEffect> volatiles = new ArrayList<>();

	public ActivePokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	
	public ActivePokemon(Optional<Pokemon> optionalPokemon) {
		if (optionalPokemon.isPresent()) {
			this.pokemon = optionalPokemon.get();
		}
	}

	public int getStage(Stat stat) {
		return stages.get(stat);
	}
	
	public BattleStages getStages() {
		return stages;
	}

	private double getEffectiveMultiplier(Stat stat) {
		return stat.getStages().getMultiplier(stages.get(stat));
	}

	public double getEffectiveStat(Stat stat) {
		double multiplier = getEffectiveMultiplier(stat);
		return pokemon.getEffectiveStat(stat) * multiplier;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}
	
	public 

	public double getSpeed() {
		double speed = getEffectiveStat(Stat.SPEED);
		
		for (IStatusEffect status : getStatus()) {
			speed *= status.speedModifier(null);
		}
		
		return speed + Math.random();
	}
	
	public void iterateOverStatusWithFunction(List<IStatusEffect> list, Function<String[], T> parser)

	public List<IStatusEffect> getStatus() {
		List<IStatusEffect> returner = new ArrayList<>(volatiles);
		if (pokemon.getStatus() != StatusCondition.NO_EFFECT) {
			returner.add(pokemon.getStatus());
		}
		return returner;
	}
}
