package number;

import java.util.Map.Entry;
import java.util.NavigableMap;

public record Weighted<T>(NavigableMap<Double, Double> weights) implements INumber<T> {
	public Weighted {
		double sum = weights.values().stream().mapToDouble(d -> d).sum();

		if (Math.abs(sum - 1.0) > 1e-9) {
			throw new IllegalArgumentException(
					"Sum of probabilites must equal 1.0");
		}

		if (weights.values().stream().anyMatch(w -> w < .0)) {
			throw new IllegalArgumentException(
					"Chance has to be zero or positive");
		}
	}


	@Override
	public double evaluate(T context) {
		double seed = Math.random();
		double total = 0.;

		for (Entry<Double, Double> weight : weights.entrySet()) {
			total += weight.getValue();
			if (total >= seed) {
				return weight.getKey();
			}
		}
		throw new IllegalStateException(
				"Sum of probabilites must equal 1.0");
	}

}
