//package battle;
//
//import org.junit.jupiter.params.shadow.de.siegmar.fastcsv.reader.CsvReader;
//
//import move.Move;
//import pokemon.ActivePokemon;
//import pokemon.Pokemon;
//import pokemon.Species;
//import stages.StageResult;
//import stats.Stat;
//import status.StatusCondition;
//import status.StatusResult;
//
public class BattleUI {
//	public static void battleMenuePrint() {
//		System.out.println("1-Fight   2-Bag");
//		System.out.println("3-Pokemon 4-Run");
//	}
//
//	public static void cantHealPotion(Pokemon pokemon) {
//		System.out.printf("%s hat bereits volle HP%n", pokemon.getName());
//	}
//
//	public static void crit() {
//		System.out.printf("Kritischer Treffer%n");
//	}
//
//	/*
//	public static void printUsePotion(Potion potion, ActivePokemon ActivePokemon) {
//		System.out.printf("%s wird um %d geheilt", ActivePokemon.getName(), potion.getHeal());
//	}
//	*/
//	public static void faited(ActivePokemon ActivePokemon) {
//		System.out.printf("%s ist ohnmächtig geworden%n", ActivePokemon.getName());
//	}
//
//	public static void heal(Pokemon pokemon) {
//		System.out.printf("%s wird geheilt%n", pokemon.getName());
//	}
//
//	public static void lost() {
//		System.out.println("Du hast verloren.");
//	}
//
//	public static void miss(ActivePokemon ActivePokemon) {
//		System.out.printf("%s missed%n", ActivePokemon.getName());
//	}
//
//	public static void notAttackPrint(ActivePokemon ActivePokemon, StatusCondition status) {
//		switch(status) {
//		case StatusCondition.PARALYZE: System.out.printf("%s ist paraliziert und kann nicht angreifen%n", ActivePokemon.getName()); break;
//		case StatusCondition.FREEZE: System.out.printf("%s ist eingefrohren und kann nicht angreifen%n", ActivePokemon.getName()); break;
//		case StatusCondition.FLINCH: System.out.printf("%s %s%n", ActivePokemon.getName(), StatusCondition.FLINCH.getVerb()); break;
//		case StatusCondition.SLEEP: System.out.printf("%s schläft und kann nicht angreifen%n", ActivePokemon.getName()); break;
//		default: System.out.printf("kann nicht angreifen weil: %n", "Placeholder");
//		}
//	}
//
//	public static void printBag() {
//		int i = 1;
//		for (Potion potion : Potion.values()) {
//			System.out.printf("%d: %s - %d HP%n", i++, potion.getName(), potion.getHeal());
//		}
//		System.out.printf("%d: %s%n", i, "exit");
//	}
//
//	public static void printDamageStatus(Pokemon pokemon, int damageAmount, StatusCondition status) {
//		switch(status) {
//		case StatusCondition.BURN: case StatusCondition.POISON: case StatusCondition.BAD_POISON:
//			System.out.printf("%s kriegt %d Schaden durch %s%n", pokemon.getName(), damageAmount, status.getName()); break;
//		default:
//			System.out.printf("%s kriegt %d Schaden durch %s%n", pokemon.getName(), damageAmount, "Placeholder"); break;
//		}
//	}
//
//	@SuppressWarnings("incomplete-switch")
//	public static void printResetStatus(Pokemon pokemon) {
//		switch (pokemon.getStatus()) {
//		case StatusCondition.FREEZE:
//			System.out.printf("%s ist aufgetaut.%n", pokemon.getName()); break;
//		}
//	}
//
//	@SuppressWarnings("incomplete-switch")
//	public static void printStatChange(StageResult result, Stat stat, String pokemon) {
//		switch (result) {
//		case StageResult.INCREASED:
//			System.out.printf("%s´s %s hat sich %s%n", pokemon, stat.toString(), "erhöht"); break;
//		case StageResult.DECREASED:
//			System.out.printf("%s´s %s hat sich %s%n", pokemon, stat.toString(), "verringert"); break;
//		case StageResult.MAXED:
//			System.out.printf("%s´s %s kann nicht weiter %s werden%n", pokemon, stat.toString(), "erhöht"); break;
//		case StageResult.MINED:
//			System.out.printf("%s´s %s kann nicht weiter %s werden%n", pokemon, stat.toString(), "verringert"); break;
//		}
//	}
//	public static void runPrint() {
//		System.out.printf("Du bist entkommen%n");
//	}
//
//	public static void setStatusPrint(StatusCondition statusCondition, StatusResult statusResult, ActivePokemon ActivePokemon) {
//		switch (statusResult) {
//		case StatusResult.NO_CHANGE: System.out.printf("%s bereits statussed%n", ActivePokemon.getName()); break;
//		case StatusResult.CHANGED: System.out.printf("%s %s%n", ActivePokemon.getName(), statusCondition.getVerb()); break;
//		}
//	}
//
//	public static void showAttacksPrint(ActivePokemon ActivePokemon) {
//		int i = 0;
//		for (Move move : ActivePokemon.getPokemon().getMoves()) {
//			System.out.printf("%d: %s%n", ++i, move.getName());
//		}
//	}
//
//	public static void showChoice() {
//		for (Species species : CsvReader.getList(Species.class)) {
//    		if (species.hasTwoTypes()) {
//    			System.out.printf("%d: %-10s | %3d/%-3d | %7s/%-7s%n", species.getPokedexID(), species.getName(), species.getDummyHp(10), species.getDummyHp(10), species.getPrimaryType().toString(), species.getSecondaryType().toString());
//    		} else {
//    			System.out.printf("%d: %-10s | %3d/%-3d | %7s%n", species.getPokedexID(), species.getName(), species.getDummyHp(10), species.getDummyHp(10), species.getPrimaryType().toString());
//    		}
//    	}
//		System.out.println("Wähle deinen Starter!");
//	}
//
//	public static void showFightPrint(ActivePokemon playerActivePokemon, ActivePokemon npcActivePokemon) {
//		int width = 20;
//		System.out.println("/".repeat(width*2+4));
//		System.out.printf("%-15s%5d vs %-5d%15s%n", playerActivePokemon.getName(),playerActivePokemon.getCurrentHp(), npcActivePokemon.getCurrentHp(), npcActivePokemon.getName());
//		int playerPercent = (int)(playerActivePokemon.getHpPercent()*width);
//		int npcPercent = (int)(npcActivePokemon.getHpPercent()*width);
//		System.out.printf("%s%s -- %s%s%n", "=".repeat(playerPercent), "-".repeat(width - playerPercent), "-".repeat(width - npcPercent), "=".repeat(npcPercent));
//	}
//
//	public static void stageChange(Pokemon pokemon, Stat stat, StageResult result) {
//		System.out.printf("%s's %s %s", pokemon.getName(), stat.getString(), result.toString());
//	}
//
//	public static void usesMove(ActivePokemon ActivePokemon, Move move) {
//		System.out.printf("%s benutzt %s%n", ActivePokemon.getName(), move.getName());
//	}
//
//	public static void wakeUpAttack(Pokemon pokemon) {
//		System.out.printf("%s ist aufgewacht%n", pokemon.getName());
//	}
//
//	public static void won() {
//		System.out.println("Du hast gewonnen.");
//	}
}
