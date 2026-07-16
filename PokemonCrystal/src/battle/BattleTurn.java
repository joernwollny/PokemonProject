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
			//player switch in
		}
		if (npc.team().getActivePokemon().isEmpty()) {
			//npc switch in
		}
		
		int i = 0;
		for (BattleAction action : BattleAction.values()) {
			System.out.println(i++ + ": " + action.toString());
		}
		
		IBattleAction playerAction = BattleAction.getAction();
		IBattleAction npcAction = BattleAction.FIGHT.create();
		
		
		
	}
}
