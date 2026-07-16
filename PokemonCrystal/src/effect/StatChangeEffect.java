package effect;

import pokemon.ActivePokemon;
import stages.StatChange;

public record StatChangeEffect(StatChange change) implements IEffect<ActivePokemon>{

	@Override
	public void apply(ActivePokemon pokemon) {
		pokemon.getStages().add(change.stat(), change.delta());
		//what happens with the StageResult?
	}
}
