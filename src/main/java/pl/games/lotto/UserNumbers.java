package pl.games.lotto;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class UserNumbers {
    public static final int MIN_VALUE = 1;
    private final Scanner scanner = new Scanner(System.in);

    public Set<Integer> getNumbersFromUser() {
        Set<Integer> userNumbers = new HashSet<>();
        while (userNumbers.size() < NumbersGenerator.NUM_OF_NUMBERS) {
            System.out.println("Give a number:");
            try {
                int userNumber = Integer.parseInt(scanner.nextLine());
                validateInputNumber(userNumber, userNumbers);
            } catch (NumberFormatException e) {
                System.err.println("Incorrect value. Enter a number between 1-99.");
            }
        }
        return userNumbers;
    }

    private void validateInputNumber(int inputNumber, Set<Integer> inputNumbers) {
        if (inputNumber < MIN_VALUE || inputNumber > NumbersGenerator.MAX_VALUE) {
            System.err.println("Number out of range. Enter a number between 1-99");
        } else if (!inputNumbers.add(inputNumber)) {
            System.err.println("Repeated number. Enter another number.");
        }
    }
}
