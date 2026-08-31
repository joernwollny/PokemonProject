package battleaction;

import java.util.List;

import context.ActionContext;
import context.MoveContext;
import context.TargetContext;
import game.UserSelection;
import move.Move;
import move.MoveSet;
import pokemon.ActivePokemon;

//possibly npc fight 
public class Fight extends BattleAction {

	protected Fight() {
		super(0);
	}

	private MoveContext context;

	@Override
	public void prepare(ActionContext context) {
		ActivePokemon user = context.user();
		
		MoveSet moves = user.getPokemon().getMoves();
 
		if (!moves.anyUsable()) {
//			move = struggle;
//			targets = List.of(enemy.team().getActivePokemon().get());
			return;
		}
		
		Move possibleMove = null;
		List<ActivePokemon> possibleTargets = null;
		do {
			// show moves
//			moves.show();
			
			// select move
			int index = UserSelection.userInput(moves.size());
			possibleMove = moves.get(index);
			possibleTargets = possibleMove.attempt().getTarget().resolve(
					new TargetContext(
							user, context.enemy().team().getActivePokemon().get()));
			
			// possibly select target. only relevant in 2v2
//			if (move.hasMultipleTargetOptions()) {
//				possibleTargets = move.getTarget().resolve();
//			} else {
//				possibleTargets = move.getDefaultTarget().resolve(
//						new TargetContext(self.team().getActivePokemon().get(), enemy.team().getActivePokemon().get()));
//			}
			
			// can select move? PP-check

		} while (!possibleMove.isUseable());

		Move move = possibleMove;
		List<ActivePokemon> targets = possibleTargets;
		
		this.context = new MoveContext(move, user, targets);
	}

	@Override
	public void execute() {
		context.move().execute(context);
	}
}
