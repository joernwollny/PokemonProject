package context;

import pokemon.ActivePokemon;
import trainer.Trainer;

public record ActionContext(ActivePokemon user, Trainer self, Trainer enemy) {

}
