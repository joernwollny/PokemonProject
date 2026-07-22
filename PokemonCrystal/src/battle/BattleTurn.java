package battle;

import battleaction.BattleAction;
import battleaction.IBattleAction;
import trainer.Trainer;

public record BattleTurn(Trainer player, Trainer npc) {

	public void execute() {
//		BattleUI.showBattleMenue();
		
		IBattleAction playerAction = BattleAction.getAction();
		IBattleAction npcAction = BattleAction.FIGHT.create();
		
		
		
	}
}
