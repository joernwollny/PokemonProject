package json;

import java.util.Map;

import pokemon.Species;

public record Pokedex(Map<String, Species> pokedex) {
	
	public Species getSpecies(String key) {
		return pokedex.get(key);
	}

}
