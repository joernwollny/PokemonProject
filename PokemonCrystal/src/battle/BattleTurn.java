package battle;

import java.util.List;

import battleaction.BattleAction;
import battleaction.IBattleAction;
import trainer.Trainer;

public record BattleTurn(Trainer player, Trainer npc) {

	public void execute() {
//		BattleUI.showBattleMenue();
		List<IBattleAction> actions;
		
		IBattleAction playerAction = BattleAction.getAction();
		IBattleAction npcAction = BattleAction.FIGHT.create();
		
		
		
	}
}
