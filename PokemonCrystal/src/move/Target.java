package move;

import java.util.List;
import java.util.function.Function;

import battle.TargetContext;
import pokemon.ActivePokemon;

public enum Target {
	SELF(ctx -> List.of(ctx.user())),
	ENEMY(ctx -> List.of(ctx.enemy())),
	ALL(ctx -> List.of(ctx.user(), ctx.enemy()));
	
	private final Function<TargetContext, List<ActivePokemon>> resolver;
	
	Target(Function<TargetContext, List<ActivePokemon>> resolver) {
		this.resolver = resolver;
	}

	public List<ActivePokemon> resolve(TargetContext context) {
		return resolver.apply(context);
	}
}

/*
public enum Target {
	SELF(TargetContext::user),
	ENEMY(TargetContext::enemy);
	
	private final Function<TargetContext, ActivePokemon> resolver;
	
	Target(Function<TargetContext, ActivePokemon> resolver) {
		this.resolver = resolver;
	}

	public ActivePokemon getTarget(TargetContext context) {
		return resolver.apply(context);
	}
}
*/