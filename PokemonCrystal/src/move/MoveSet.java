package move;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import game.UserSelection;

public class MoveSet {
	
	private final static int MAX_MOVES = 4, ARRAY_OFFSET = 1;
	private final List<Move> moves = new ArrayList<>(MAX_MOVES);
	
	public MoveSet(Move...moves) {
		if (moves.length > MAX_MOVES) {
			throw new IllegalArgumentException("Only " + MAX_MOVES + " moves allowed.");
		}
		
		this.moves.addAll(Stream.of(moves).toList());
	}
	
	public MoveSet(List<Move> moves) {
		this.moves.addAll(moves);
	}
	
	public void add(Move move) {
		if (moves.size() < MAX_MOVES) {
			moves.add(move);
		}
		
		if (moves.size() == MAX_MOVES) {
			moves.set(moveSelection(), move);
		}
	}
	
	public void printMoves() {
		int i = 1;
		for (Move move : moves) {
			System.out.println(i++ + ": " + move.toString());
		}
	}
	
	public int moveSelection() {
		printMoves();
		return UserSelection.userInput(1, MAX_MOVES) - ARRAY_OFFSET;
	}
	
	public Move get(int index) {
		return moves.get(index);
	}
	
}
