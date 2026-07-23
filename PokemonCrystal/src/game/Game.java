package game;

import java.io.FileNotFoundException;

import json.JsonLoader;
import json.Pokedex;
import move.Category;
import move.LearnableMove;
import move.Move;
import move.MovePool;
import move.MoveSet;
import move.PowerPoints;
import pokemon.Pokemon;
import pokemon.Type;
import trainer.Team;
import trainer.Trainer;

public class Game {
	public static Trainer player;
	public static Pokedex pokedex;
	
	public static void main(String[] args) throws FileNotFoundException {

//		MoveSet test = new MoveSet(
//				new Move("test1", Type.BUG, Category.PHYSICAL, new PowerPoints(5), 0, null, null),
//				new Move("test2", Type.BUG, Category.PHYSICAL, new PowerPoints(5), 0, null, null),
//				new Move("test3", Type.BUG, Category.PHYSICAL, new PowerPoints(5), 0, null, null));
		

		MovePool test = new MovePool(
				new LearnableMove(new Move("test1", Type.BUG, Category.PHYSICAL, new PowerPoints(5), 0, null, null),0),
				new LearnableMove(new Move("test2", Type.BUG, Category.PHYSICAL, new PowerPoints(5), 0, null, null),0),
				new LearnableMove(new Move("test3", Type.BUG, Category.PHYSICAL, new PowerPoints(5), 0, null, null),0),
				new LearnableMove(new Move("test4", Type.BUG, Category.PHYSICAL, new PowerPoints(5), 0, null, null),1),
				new LearnableMove(new Move("test5", Type.BUG, Category.PHYSICAL, new PowerPoints(5), 0, null, null),2),
				new LearnableMove(new Move("test6", Type.BUG, Category.PHYSICAL, new PowerPoints(5), 0, null, null),3),
				new LearnableMove(new Move("test7", Type.BUG, Category.PHYSICAL, new PowerPoints(5), 0, null, null),4),
				new LearnableMove(new Move("test8", Type.BUG, Category.PHYSICAL, new PowerPoints(5), 0, null, null),5),
				new LearnableMove(new Move("test9", Type.BUG, Category.PHYSICAL, new PowerPoints(5), 0, null, null),6));
		
		MoveSet testset = test.generateMoveSet(5);
		
//		testset.printMoves();
		
		
		

		
		
		
//		setup(); //load pokedex, maybe overworld
//
//		Trainer npc = new Trainer("Rival", new Team(new Pokemon(pokedex.getSpecies("charmander"), "charry", 10)));
//		
//		Battle battle1 = new Battle(player, npc);
//		battle1.start();
//
//	}
//	
//	private static void setup() throws FileNotFoundException {
//		pokedex = JsonLoader.importPokedex();
//		
//		player = new Trainer("Timmy", new Team(new Pokemon(pokedex.getSpecies("bulbasaur"), "Bulby", 10)));
	}
}
