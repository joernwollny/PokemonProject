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
	
	public Move get(int index) {
		return moves.get(index);
	}
	
	public int size() {
		return moves.size();
	}
	
	public boolean anyUsable() {
		return moves.stream().anyMatch(m -> m.isUseable());
	}
}
