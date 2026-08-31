package battle;

import battleaction.BattleAction;
import battleaction.BattleActionType;
import context.ActionContext;
import eventhandler.EventHandler;
import trainer.Trainer;

public record BattleTurn(Trainer player, Trainer npc) {

	public void execute() {
		
		EventHandler handler = new EventHandler();
		
		// todo 2v2
		
//		BattleUI.showBattleMenue();
		BattleAction playerAction = BattleActionType.getAction();
		playerAction.prepare(new ActionContext(player.team().getActivePokemon().get(), player, npc));
		handler.add(playerAction);
		
		BattleAction npcAction = BattleActionType.FIGHT.create();
		//AI move selector
		npcAction.prepare(new ActionContext(npc.team().getActivePokemon().get(), npc, player));
		handler.add(npcAction);
		
		handler.execute();
		
	}
}
