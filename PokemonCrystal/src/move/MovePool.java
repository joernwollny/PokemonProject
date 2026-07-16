package move;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class MovePool {

	private final List<LearnableMove> moves;
	
	public MovePool(LearnableMove...moves) {
		this.moves = Stream.of(moves).toList();
//		this.moves.sort((m1, m2) -> m1.level() - m2.level());
//		Collections.sort(this.moves, (m1, m2) -> m1.level() - m2.level());
		
	}
	

	public MoveSet generateMoveSet(int level) {
		List<Move> learnableMoves = moves.stream().filter(m -> m.level() <= level).map(m -> m.move()).toList();
		
		int count = learnableMoves.size();
		if (count <= 4) {
			return new MoveSet(learnableMoves);
		}
		
		int itemsToSkip = count - 4;
		
		return new MoveSet(learnableMoves.subList(itemsToSkip, count));
	}
	
	
}
