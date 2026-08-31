package context;

import move.Move;
import pokemon.ActivePokemon;

public record HitContext(Move move, ActivePokemon user, ActivePokemon target) {

}
