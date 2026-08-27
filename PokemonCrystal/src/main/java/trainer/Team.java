package trainer;

import java.util.Optional;
import java.util.stream.Stream;

import pokemon.ActivePokemon;
import pokemon.Pokemon;

public class Team {
	private final Pokemon[] team = new Pokemon[6];
	private ActivePokemon activePokemon;
	
	public Team(Pokemon...pokemons){
		if (pokemons.length > 6) {
			throw new IllegalArgumentException("Can't have more than 6 Pokemon");
		}
		
		for (int i = 0; i < team.length && i < pokemons.length; i++) {
			team[i] = pokemons[i];
		}

	}

	public Optional<ActivePokemon> getActivePokemon() {
		return Optional.ofNullable(activePokemon);
	}

	public Pokemon getPokemon(int index) throws IndexOutOfBoundsException {
		if (index < 0 | index > team.length-1) {
			throw new IndexOutOfBoundsException();
		}
		
		return team[index];
	}
	
	public Pokemon[] getTeam() {
		return team;
	}
	
	public void setDefaultActivePokemon() throws IllegalStateException{
		Optional<Pokemon> canidate = Stream.of(team).filter(p -> p.isAlive()).findFirst();
		
		if (canidate.isEmpty()) {
			throw new IllegalStateException("No pokemon alive to set as ActivePokemon");
		}
		
		activePokemon = new ActivePokemon(canidate.get());
	}
	
	public boolean setActivePokemon(int index) throws IndexOutOfBoundsException {
		if (index < 0 | index > team.length-1) {
			throw new IndexOutOfBoundsException();
		}
		if (team[index].isFainted()) {
			return false;
		}
		if (team[index].equals(activePokemon.getPokemon())) {
			return false;
		}
		
		this.activePokemon = new ActivePokemon (team[index]);
		return true;
	}

	public boolean isAlive() {
		return Stream.of(team).anyMatch(p -> p.isAlive());
	}
}
