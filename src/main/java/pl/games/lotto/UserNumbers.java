package pl.games.lotto;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static pl.games.lotto.AppConstants.*;

public class UserNumbers {

    public Set<Integer> getNumbersFromUser(Scanner scanner) {
        Set<Integer> userNumbers = new HashSet<>();
        while (userNumbers.size() < NUM_OF_NUMBERS) {
            System.out.println("Give a number:");
            if (scanner.hasNextLine()) {
                try {
                    int userNumber = Integer.parseInt(scanner.nextLine());
                    validateInputNumber(userNumber, userNumbers);
                } catch (NumberFormatException e) {
                    System.err.println("Incorrect value. Enter a number between 1-99.");
                }
            } else {
                System.err.println("No more input available.");
                break;
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
