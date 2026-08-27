package pokemon;

import java.util.Objects;

import move.MoveSet;
import stats.BaseStats;
import stats.EffectiveStats;
import stats.EffortValues;
import stats.IndividualValues;
import stats.Stat;
import status.BadPoison;
import status.IStatusEffect;
import status.NoStatus;
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
	private final Nature nature = Nature.values()[(int) (Math.random() * Nature.values().length)];
//	protected final boolean shiny = (Math.random() < 1./4096) ? true : false;
//	private final Ability ability;
//	private Item heldItem;

	private final BaseStats base;
	private final EffortValues ev = new EffortValues();
	private final IndividualValues iv = new IndividualValues();
	protected EffectiveStats stats;

	private final MoveSet moves;

	private int totalDamageTaken = 0;
	private IStatusEffect status = new NoStatus();
//	protected boolean pokerus = false;

	public Pokemon(Species species, int level) {
		this(species, species.name(), level, new MoveSet());

		// movepool fill
		// moveset fill
	}

	public Pokemon(Species species, int level, MoveSet moves) {
		this(species, species.name(), level, moves);
	}

	public Pokemon(Species species, String nickname, int level) {
		this(species, nickname, level, new MoveSet());

		// movepool fill
		// moveset fill
	}

	public Pokemon(Species species, String nickname, int level, MoveSet moves) {
		Objects.requireNonNull(species);
		Objects.requireNonNull(nickname);
		// level can't be null as it is primitive
		Objects.requireNonNull(moves);

		this.species = species;

		validateNickname(nickname);
		this.nickname = nickname;

		validateLevel(level);
		this.level = level;

		this.base = species.base();
		this.stats = new EffectiveStats(base, iv, ev, level, nature);
		this.moves = moves;
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

	public MoveSet getMoves() {
		return moves;
	}

	public Nature getNature() {
		return nature;
	}

	public String getNickname() {
		return nickname;
	}

	public IStatusEffect getPersistentStatus() {
		return status;
	}

	public Species getSpecies() {
		return species;
	}

	public EffectiveStats getStats() {
		return stats;
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

	public void levelUp(int delta) throws IllegalArgumentException {
		// could implement level Down easily
		if (delta <= 0) {
			throw new IllegalArgumentException("level up amount can't be 0 or negative");
		}
		level += delta;
		Math.min(level, MAX_LEVEL);
		updateStats();
	}

	public StatusResult onSwitch() {
		if (this.status instanceof BadPoison) {
			status = StatusCondition.POISON.create();
			return StatusResult.CHANGED;
		}
		return StatusResult.NO_CHANGE;
	}

	public void setNickname(String nickname) throws IllegalArgumentException {
		validateNickname(nickname);
		this.nickname = nickname;
	}

	public StatusResult setStatus(StatusCondition status) {
		if (this.status instanceof NoStatus) {
			this.status = status.create();
			return StatusResult.CHANGED;
		}
		return StatusResult.NO_CHANGE;

	}

	private void updateStats() {
		this.stats = new EffectiveStats(base, iv, ev, level, nature);
	}

	private void validateLevel(int level) throws IllegalArgumentException {
		if (level < 1 || level > 100) {
			throw new IllegalArgumentException("level can't be less than 1 or more than 100");
		}
	}

	private void validateNickname(String nickname) throws IllegalArgumentException {
		if (nickname.isEmpty()) {
			throw new IllegalArgumentException("Name must contain letters");
		}
		if (!nickname.chars().allMatch(Character::isLetter)) {
			throw new IllegalArgumentException("Name must only contain letters");
		}
	}

}