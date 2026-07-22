package pokemon;

import java.util.Optional;

import move.MoveSet;
import stats.BaseStats;
import stats.EffectiveStats;
import stats.EffortValues;
import stats.IndividualValues;
import stats.Stat;
import status.BadPoison;
import status.IStatusEffect;
import status.StatusCondition;
import status.StatusResult;

public class Pokemon {
	public static final int MIN_LEVEL = 1, MAX_LEVEL = 100;

	private String nickname;
	private final Species species;
//	private Form form;
	private int level;
//	protected int experience;
//	private final Gender gender;
	private final Nature nature = Nature.values()[(int)(Math.random()*Nature.values().length)];
//	protected final boolean shiny = (Math.random() < 1./4096) ? true : false;
//	private final Ability ability;
//	private Item heldItem;

	private final BaseStats base;
	private final EffortValues ev = new EffortValues();
	private final IndividualValues iv = new IndividualValues();
	protected EffectiveStats stats;

	protected final MoveSet moves;

	protected int totalDamageTaken = 0;
	protected IStatusEffect status;
//	protected boolean pokerus = false;


	public Pokemon(Species species, String nickname, int level, MoveSet moves) {
		this.species = species;
		this.nickname = nickname;
		this.level = level;
		this.base = species.base();
		species.name();

		this.stats = new EffectiveStats(base, iv, ev, level, nature);
		
		this.moves = moves;
	}

	public Pokemon(Species species, String nickname, int level) {
		this(species, nickname, level, new MoveSet());
		
		//movepool fill
		//moveset fill
	}
	
	

	public double getEffectiveStat(Stat stat) {
		return stats.getStat(stat);
	}


	public int getHp() {
		return stats.getStat(Stat.HP) - totalDamageTaken;
	}


	public int getLevel() {
		return level;
	}

	public Nature getNature() {
		return nature;
	}


	public String getNickname() {
		return nickname;
	}

	public Species getSpecies() {
		return species;
	}


	public EffectiveStats getStats() {
		return stats;
	}


	public Optional<IStatusEffect> getPersistentStatus() {
		return Optional.ofNullable(status);
	}
	
	public MoveSet getMoves() {
		return moves;
	}

	public void incomingDamage(int delta) {
		totalDamageTaken = Math.min(totalDamageTaken + delta, stats.getStat(Stat.HP));
	}


	public boolean isAlive() {
		return totalDamageTaken < stats.getStat(Stat.HP);
	}

	public boolean isFainted() {
		return !isAlive();
	}


	public void levelUp(int delta) throws IllegalArgumentException{
		if (delta <= 0) {
			throw new IllegalArgumentException("level up amount can't be 0 or negative");
		}
		level += delta;
		updateStats();
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public StatusResult setStatus(StatusCondition status) {
		if (getPersistentStatus().isPresent()) {
			return StatusResult.NO_CHANGE;
		}
		this.status = status.create();
		return StatusResult.CHANGED;
	}
	
	public StatusResult onSwitch() {
		Optional<IStatusEffect> current = getPersistentStatus();
		if (current.isEmpty()) {
			return StatusResult.NO_CHANGE;
		}
		if (current.get().getClass().equals(BadPoison.class)) {
			status = StatusCondition.POISON.create();
			return StatusResult.CHANGED;
		}
		return StatusResult.NO_CHANGE;
	}

	private void updateStats() {
		this.stats = new EffectiveStats(base, iv, ev, level, nature);
	}

}