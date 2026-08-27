package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import move.MoveSet;
import pokemon.Nature;
import pokemon.Pokemon;
import pokemon.Species;
import pokemon.Type;
import stats.BaseStats;
import stats.EffortValues;
import stats.Stat;

class PokemonTest {

	Pokemon pokemon;
	
	Species testSpecies = new Species(1, "testName", List.of(Type.NORMAL), new BaseStats(fill()), new EffortValues());
	String testNickname = "TestNickname";
	int testLevel = 50;
	MoveSet testMoveSet = new MoveSet();
	
	@BeforeEach
	void setup() {
		pokemon = new Pokemon(testSpecies, testNickname, testLevel, testMoveSet);
	}
	
	private EnumMap<Stat, Integer> fill() {
		EnumMap<Stat, Integer> testmap = new EnumMap<Stat, Integer>(Stat.class);
		testmap.put(Stat.HP, 45);
		testmap.put(Stat.ATK, 46);
		testmap.put(Stat.DEF, 47);
		testmap.put(Stat.SPATK, 48);
		testmap.put(Stat.SPDEF, 49);
		testmap.put(Stat.SPEED, 50);
		return testmap;
	}
	
	@Test
	void constructorWithExpectedValuesTest() {
		pokemon = new Pokemon(testSpecies, testNickname, testLevel, testMoveSet);
		
		assertAll("baseline test values",
				() -> assertEquals("TestNickname", pokemon.getNickname()),
				() -> assertEquals(50, pokemon.getLevel())
				);
	}
	
	@Test
	void alternativeConstructorTest() {
		pokemon = new Pokemon(testSpecies, testNickname, testLevel);
		assertAll("alternative constructors",
				() -> assertDoesNotThrow(()->new Pokemon(testSpecies, testNickname, testLevel, testMoveSet)),
				() -> assertDoesNotThrow(()->new Pokemon(testSpecies,               testLevel, testMoveSet)),
				() -> assertDoesNotThrow(()->new Pokemon(testSpecies, testNickname, testLevel             )),
				() -> assertDoesNotThrow(()->new Pokemon(testSpecies,               testLevel             ))			
				);
	}
	
	@Test
	void constructorWithNullGivenTest() {
		assertAll("null given",
				() -> assertThrows(NullPointerException.class, ()->new Pokemon(null       , testNickname, testLevel, testMoveSet)),
				() -> assertThrows(NullPointerException.class, ()->new Pokemon(testSpecies, null        , testLevel, testMoveSet)),
				() -> assertThrows(NullPointerException.class, ()->new Pokemon(testSpecies, testNickname, testLevel, null       ))
				);
	}
	
	@Test
	void constructorWithIllegalGivenTest() {
		assertAll("illegal arguments",
				() -> assertThrows(IllegalArgumentException.class, ()->new Pokemon(testSpecies, "", testLevel, testMoveSet), "name must not be empty"),
				() -> assertThrows(IllegalArgumentException.class, ()->new Pokemon(testSpecies, "1", testLevel, testMoveSet), "illegal name"),
				() -> assertThrows(IllegalArgumentException.class, ()->new Pokemon(testSpecies, "@", testLevel, testMoveSet), "illegal name"),
				() -> assertThrows(IllegalArgumentException.class, ()->new Pokemon(testSpecies, testNickname, 0, testMoveSet), "illegal level"),
				() -> assertThrows(IllegalArgumentException.class, ()->new Pokemon(testSpecies, testNickname, 101, testMoveSet), "illegal level")
				);
	}
	
	@Test
	void methodTest() {
		assertAll("return incorrect type",
				() -> assertInstanceOf(Nature.class, pokemon.getNature(), "Nature invalid")
				);
	}
	
	@RepeatedTest(1000)
	void effectiveAttackTest() {
		pokemon = new Pokemon(testSpecies, testNickname, 50, testMoveSet);
		assertTrue(105 <= pokemon.getEffectiveStat(Stat.HP) && pokemon.getEffectiveStat(Stat.HP) <= 120, "effective hp stat does not fit");
		assertTrue(45 <= pokemon.getEffectiveStat(Stat.ATK) && pokemon.getEffectiveStat(Stat.ATK) <= 72, "effective attack stat does not fit");
	}
	
	@RepeatedTest(1000)
	void incomingDamageTest() {
		int damage = (int) (Math.random()*151);
		pokemon.incomingDamage(damage);
		assertTrue(((105-damage) <= pokemon.getHp() && pokemon.getHp() <= (120-damage)) || pokemon.isFainted(), "damage does not fit");
	}
	
	@RepeatedTest(1000)
	void levelUpStatsTest() {
		pokemon.levelUp(10);
		assertTrue(124 <= pokemon.getEffectiveStat(Stat.HP) && pokemon.getEffectiveStat(Stat.HP) <= 142, "effective hp stat does not fit");
		assertTrue(54 <= pokemon.getEffectiveStat(Stat.ATK) && pokemon.getEffectiveStat(Stat.ATK) <= 85, "effective attack stat does not fit");
	}
	
	@RepeatedTest(1000)
	void incomingDamageAfterLevelUpTest() {
		pokemon.incomingDamage(20);
		pokemon.levelUp(10);
		assertTrue((124-20) <= pokemon.getHp() && pokemon.getHp() <= (142-20), "damage does not fit");
	}
	
	@Test
	void diesTest() {
		assertAll("initially alive",
				() -> assertTrue(pokemon.isAlive()),
				() -> assertFalse(pokemon.isFainted())
				);
		pokemon.incomingDamage(1000);
		assertAll("dead in the end",
				() -> assertFalse(pokemon.isAlive()),
				() -> assertTrue(pokemon.isFainted()),
				() -> assertEquals(0, pokemon.getHp())
				);
	}
	
	@Disabled
	void testMoves() {
		
	}
}
