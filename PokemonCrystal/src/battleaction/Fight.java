package battleaction;

import battle.ActionContext;
import battle.BattleTurn;
import move.Move;
import trainer.Trainer;

public class Fight implements IBattleAction{

	@Override
	public void apply(Trainer user, Trainer target) {
		BattleUI.showMoves(user);
		
	}


}
