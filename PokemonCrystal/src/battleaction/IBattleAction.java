package battleaction;

import trainer.Trainer;

public interface IBattleAction {
	void prepare(Trainer user, Trainer target);
	void execute();
}
