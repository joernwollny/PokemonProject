package battle;

import battleaction.BattleAction;
import battleaction.BattleActionType;
import eventhandler.EventHandler;
import trainer.Trainer;

public record BattleTurn(Trainer player, Trainer npc) {

	public void execute() {
//		BattleUI.showBattleMenue();
		EventHandler handler = new EventHandler();
		
		//2v2 to-add
		//(what if can't act)
		
		BattleAction playerAction = BattleActionType.getAction();
		playerAction.prepare(player, npc);
		handler.add(playerAction);
		
		BattleAction npcAction = BattleActionType.FIGHT.create();
		//AI move selector
		npcAction.prepare(npc, player);
		handler.add(npcAction);
		
		handler.execute();
		
	}
}
