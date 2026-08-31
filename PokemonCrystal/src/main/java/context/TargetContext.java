package context;

import move.Target;
import pokemon.ActivePokemon;

public record TargetContext(ActivePokemon user, ActivePokemon enemy) {

}
