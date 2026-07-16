package battleaction;

import trainer.Trainer;

public interface IBattleAction {
	void apply(Trainer user, Trainer target);
}
