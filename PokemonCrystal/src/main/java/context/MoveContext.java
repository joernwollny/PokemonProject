package context;

import java.util.List;

import move.Move;
import pokemon.ActivePokemon;

public record MoveContext(Move move, ActivePokemon user, List<ActivePokemon> targets) {

}
