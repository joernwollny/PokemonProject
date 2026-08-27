package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pokemon.Species;
import pokemon.Type;
import stats.BaseStats;
import stats.EffortValues;
import stats.Stat;

class SpeciesTest {

	Species species;
	
	int testId = 1;
	String testName = "Testname";
	List<Type> testTypes = List.of(Type.NORMAL, Type.FIRE);
	EffortValues testEv = new EffortValues();
	EnumMap<Stat, Integer> testmap = fill();
	BaseStats testBase = new BaseStats(testmap);

	
	@BeforeEach
	void setUp() {
		species = new Species(testId, testName, testTypes, testBase, testEv);
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
		EnumMap<Stat, Integer> map = new EnumMap<Stat, Integer>(Stat.class);
		map.put(Stat.HP, 45);
		map.put(Stat.ATK, 46);
		map.put(Stat.DEF, 47);
		map.put(Stat.SPATK, 48);
		map.put(Stat.SPDEF, 49);
		map.put(Stat.SPEED, 50);
		
//		Type[] types = {Type.NORMAL, Type.FIRE};
		
		assertAll("baseline test values",
				()->assertEquals(1, species.pokedexId()),
				()->assertEquals("Testname", species.name()),
//				()->assertEquals(types, species.types()),
				()->assertEquals(Type.NORMAL, species.getPrimaryType()),
				()->assertTrue(species.hasTwoTypes()),
				()->assertEquals(Type.FIRE, species.getSecondaryType())
//				()->assertEquals(new BaseStats(map),species.base()),
//				()->assertEquals(new EffortValues(), species.evOnFaint())
				);
	}
	
	@Test
	void constructorWithNullGivenTest() {
		assertAll("null given",
				()->assertThrows(NullPointerException.class, ()-> new Species(testId, null    , testTypes, testBase, testEv)),
				()->assertThrows(NullPointerException.class, ()-> new Species(testId, testName, null     , testBase, testEv)),
				()->assertThrows(NullPointerException.class, ()-> new Species(testId, testName, testTypes, null    , testEv)),
				()->assertThrows(NullPointerException.class, ()-> new Species(testId, testName, testTypes, testBase, null  ))
				);
	}
	
	@Test
	void constructorWithIllegalGivenTest() {
		assertAll("illegal argument given",
				()->assertThrows(IllegalArgumentException.class, ()-> new Species(0     , testName, testTypes, testBase, testEv), "ID failed"),
				()->assertThrows(IllegalArgumentException.class, ()-> new Species(-10   , testName, testTypes, testBase, testEv), "ID failed"),
				()->assertThrows(IllegalArgumentException.class, ()-> new Species(testId, ""      , testTypes, testBase, testEv), "Name failed"),
				()->assertThrows(IllegalArgumentException.class, ()-> new Species(testId, "@"     , testTypes, testBase, testEv), "Name failed"),
				()->assertThrows(IllegalArgumentException.class, ()-> new Species(testId, "1"     , testTypes, testBase, testEv), "Name failed"),
				()->assertThrows(IllegalArgumentException.class, ()-> new Species(testId, testName, List.of(), testBase, testEv), "Types failed"),
				()->assertThrows(IllegalArgumentException.class, ()-> new Species(testId, testName, List.of(Type.NO_TYPE), testBase, testEv), "Types failed"),
				()->assertThrows(IllegalArgumentException.class, ()-> new Species(testId, testName, List.of(Type.NORMAL, Type.NORMAL), testBase, testEv), "Types failed"),
				()->assertThrows(IllegalArgumentException.class, ()-> new Species(testId, testName, List.of(Type.NORMAL, Type.BUG, Type.FIRE), testBase, testEv), "Types failed")
				);
	}
	
	@Test
	void methodTests() {
		species = new Species(testId, testName, testTypes, testBase, testEv);
		assertAll("Baseline tests",
				()->assertTrue(species.hasTwoTypes(), "hasTwoTypes()"),
				()->assertEquals(species.getPrimaryType(), Type.NORMAL, "getPrimaryType()"),
				()->assertEquals(species.getSecondaryType(), Type.FIRE, "getSecondaryType()")
				);
		
		species = new Species(testId, testName, List.of(Type.BUG), testBase, testEv);
		assertAll("Single Type tests",
				()->assertFalse(species.hasTwoTypes(), "hasTwoTypes()"),
				()->assertEquals(species.getPrimaryType(), Type.BUG, "getPrimaryType()"),
				()->assertEquals(species.getSecondaryType(), Type.NO_TYPE, "getSecondaryType()")
				);
		
	}

}
