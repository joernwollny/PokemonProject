package battle;

import battleaction.BattleAction;
import battleaction.IBattleAction;
import trainer.Trainer;

public class BattleTurn {

	private Trainer player, npc;
	
	public BattleTurn(Trainer player, Trainer npc) {
		this.player = player;
		this.npc = npc;
		
		player.team().setDefaultActivePokemon();
		npc.team().setDefaultActivePokemon();
		
	}
	
	public void execute() {
		if (player.team().getActivePokemon().isEmpty()) {
			player.team().setDefaultActivePokemon();
		}
		if (npc.team().getActivePokemon().isEmpty()) {
			npc.team().setDefaultActivePokemon();
		}
		
		BattleUI.showBattleMenue();
		
		IBattleAction playerAction = BattleAction.getAction();
		IBattleAction npcAction = BattleAction.FIGHT.create();
		
		
		
	}
}
