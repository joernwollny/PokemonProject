package pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import move.Move;
import move.MoveSet;
import stats.BaseStats;
import stats.EffectiveStats;
import stats.EffortValues;
import stats.IndividualValues;
import stats.Stat;
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
	protected StatusCondition status = StatusCondition.NO_EFFECT;
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


	public StatusCondition getStatus() {
		return status;
	}
	
	public Move[] getMoves() {
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


	public void levelUp(int delta) {
		level += delta;
		updateStats();
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public StatusResult setStatus(StatusCondition status) {
		if (this.status != StatusCondition.NO_EFFECT) {
			return StatusResult.NO_CHANGE;
		}
		this.status = status;
		return StatusResult.CHANGED;
	}

	private void updateStats() {
		this.stats = new EffectiveStats(base, iv, ev, level, nature);
	}

}