package move;

import java.util.List;
import java.util.function.Function;

import context.TargetContext;
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
