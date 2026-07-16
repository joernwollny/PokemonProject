package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserSelection {

	private final static Scanner scanner = new Scanner(System.in);

	public static int userInput(int lowerBound, int upperBound) {
		int selection = lowerBound -1;
		do {
			try {
				selection = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Wrong Inpuit Type");
				scanner.nextLine();
			}
		} while (selection < lowerBound || selection >= upperBound);
		return selection;
	}
	
	public static int userInput(int upperBound) {
		return userInput(0, upperBound);
	}
}
