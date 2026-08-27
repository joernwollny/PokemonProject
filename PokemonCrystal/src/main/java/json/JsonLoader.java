package json;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

import pokemon.Species;
import tools.jackson.databind.ObjectMapper;

public class JsonLoader {

	public static Pokedex importPokedex() throws FileNotFoundException {
		ObjectMapper mapper = new ObjectMapper();

		Pokedex pokedex =
				mapper.readValue(
						new File("src/json/species.json"),
						mapper.getTypeFactory().constructMapType(
								Map.class, String.class, Species.class
								)
						);

//		for (Species species : pokedex.values()) {
//			System.out.println(species.base().getPrimary());
//		}
		
		return pokedex;

	}
}
