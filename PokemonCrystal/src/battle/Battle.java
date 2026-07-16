package battle;

import trainer.Trainer;

public record Battle(Trainer player, Trainer npc) {

	public void start() {
		while (player.team().isAlive() && npc.team().isAlive()) {
			BattleTurn battleTurn = new BattleTurn(player, npc);
			battleTurn.execute();
		}
	}
}
