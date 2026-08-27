package pokemon;

import move.MovePool;

public class PlayerPokemon extends Pokemon {

	protected final MovePool movePool;
	
	public PlayerPokemon(Species species, String nickname, int level, MovePool movePool) {
		super(species, nickname, level);
		this.movePool = movePool;
	}
}
