package effect;

import pokemon.ActivePokemon;
import stages.StatChange;

public record StatChangeEffect(StatChange change) implements IEffect<ActivePokemon>{

	@Override
	public void apply(ActivePokemon pokemon) {
		pokemon.addStage(change);
		//what happens with the StageResult?
	}
}
