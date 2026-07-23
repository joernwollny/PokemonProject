package battleaction;

import java.util.List;
import java.util.Optional;

import battle.TargetContext;
import game.UserSelection;
import move.Move;
import move.MoveSet;
import move.Priority;
import pokemon.ActivePokemon;
import trainer.Trainer;

//possibly npc fight 
public class Fight implements IBattleAction {

	private Move move;
	private List<ActivePokemon> target;
	private ActivePokemon user;

	@Override
	public void prepare(Trainer self, Trainer enemy) {
		// Optional nullable impossible, since i check before ever round
		this.user = self.team().getActivePokemon().get();
		Move possibleMove;
		List<ActivePokemon> possibleTargets;
		MoveSet moves = self.team().getActivePokemon().get().getPokemon().getMoves();

		if (!moves.anyUsable()) {
//			move = struggle;
			target = List.of(enemy.team().getActivePokemon().get());
			return;
		}
		
		do {
			// show moves
			moves.show();
			// select move
			int index = UserSelection.userInput(moves.size());
			possibleMove = moves.get(index);
			// possibly select target
			if (move.hasMultipleTarget()) {
				possibleTargets = move.getTarget().resolve();
			} else {
				possibleTargets = move.getDefaultTarget().resolve(
						new TargetContext(self.team().getActivePokemon().get(), enemy.team().getActivePokemon().get()));
			}
			// can select move? PP-check

		} while (!possibleMove.isUseable());

		move = possibleMove;
		target = possibleTargets;

	}

	// should only be called after prepare to get prios
	public Priority getPriority() {
		Optional<Move> move = Optional.ofNullable(this.move);

		return (move.isPresent()) ? new Priority(move.get().superPriority(), user.getSpeed()) : null;

	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
