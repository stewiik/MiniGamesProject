package pl.games.lotto;

import lombok.Data;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@Data
public class UserNumbers {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 99;
    public static final int NUM_OF_NUMBERS = 6;
    private final Scanner scanner;


    public Set<Integer> getNumbersFromUser() {
        Set<Integer> userNumbers = new HashSet<>();
        while (userNumbers.size() < NUM_OF_NUMBERS) {
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
        if (inputNumber < MIN_VALUE || inputNumber > MAX_VALUE) {
            System.err.println("Number out of range. Enter a number between 1-99");
        } else if (!inputNumbers.add(inputNumber)) {
            System.err.println("Repeated number. Enter another number.");
        }
    }
}
