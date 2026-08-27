package pokemon;

import java.util.HashSet;
import java.util.Set;

import eventhandler.Prioritized;
import stages.BattleStages;
import stages.StageResult;
import stages.StatChange;
import stats.Stat;
import status.IStatusEffect;
import status.NoStatus;
import status.StatusCondition;
import status.StatusResult;

public class ActivePokemon implements Prioritized<ActivePokemon> {
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
		switch (stat) {
		case CRIT, EVASION, ACCURACY -> {
			throw new IllegalArgumentException("crit, evasion, accuracy have no stat");
		}
		default -> {
			double multiplier = getEffectiveMultiplier(stat);
			return pokemon.getEffectiveStat(stat) * multiplier;
		}
		}
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public Set<IStatusEffect> getStatus() {
		Set<IStatusEffect> allStatus = new HashSet<>(volatiles);
		if (!(pokemon.getPersistentStatus() instanceof NoStatus)) {
			allStatus.add(pokemon.getPersistentStatus());
		}
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

	@Override
	public int getPriority() {
		double speed = getEffectiveStat(Stat.SPEED);

		for (IStatusEffect status : getStatus()) {
			speed *= status.speedModifier(null);
		}

		return (int) speed;
	}

}
