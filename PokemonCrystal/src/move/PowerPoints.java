package move;

import java.util.EnumMap;
import java.util.Map;

public class PowerPoints {
	private final EnumMap<Amount, Integer> pp = new EnumMap<>(Amount.class);

	public PowerPoints(int max) {
		this(max, max);
	}

	public PowerPoints(int current, int max) {
		this.pp.put(Amount.CURRENT, current);
		this.pp.put(Amount.MAX, max);
	}

	public Map<Amount, Integer> getAll() {
		return pp.clone();
	}

	public int getCurrent() {
		return pp.get(Amount.CURRENT);
	}

	public int getMax() {
		return pp.get(Amount.MAX);
	}

	public boolean isAvailable() {
		return pp.get(Amount.CURRENT) > 0;
	}

	//Pressure to do
	public void used() throws IllegalStateException {
		if (pp.get(Amount.CURRENT) <= 0) {
			throw new IllegalStateException("Cannot use move: PP is " + pp.get(Amount.CURRENT));
		}

		pp.put(Amount.CURRENT, pp.get(Amount.CURRENT) - 1);
	}
}
