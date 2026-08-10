package move;

import java.util.List;

import pokemon.ActivePokemon;

public record MoveContext(Move move, ActivePokemon user, List<ActivePokemon> targets) {

}
