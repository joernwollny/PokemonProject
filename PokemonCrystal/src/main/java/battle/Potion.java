package battle;

public enum Potion {
	POTION("Trank", 20),
	SUPER_POTION("Super Trank", 50),
	HYPER_POTION("Hyper Trank", 200);

	private final String name;
	private final int heal;

	Potion(String name, int heal){
		this.name = name;
		this.heal = heal;
	}

	public int getHeal() {
		return heal;
	}

	public String getName() {
		return name;
	}
}
