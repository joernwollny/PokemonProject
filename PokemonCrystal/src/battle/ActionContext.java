package battle;

import move.Move;
import pokemon.ActivePokemon;

public record ActionContext(ActivePokemon user, ActivePokemon receiver, Move move) {

}
