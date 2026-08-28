package json;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

import pokemon.Species;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

public class PokemonJsonLoader {

	public static Pokedex importPokedex() throws FileNotFoundException {
		ObjectMapper mapper = new ObjectMapper();

		Map<String, Species> map = mapper.readValue(new File("src/main/java/json/species.json"),
				new TypeReference<Map<String, Species>>() {
				}

		);

		return new Pokedex(map);
	}

	public static void main(String[] args) throws FileNotFoundException {
		for (Species species : importPokedex().pokedex().values()) {
			System.out.println(species);
		}

	}
}
