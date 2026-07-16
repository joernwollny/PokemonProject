package stages;

public enum StageResult {
	MAXED("kann nicht weiter erhöht werden."),
	MINED("kann nicht weiter verringert werden."),
	INCREASED("steigt"),
	DECREASED("sinkt"),
	STAYS("");

	private final String text;

	StageResult(String text){
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
