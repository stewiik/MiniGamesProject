package pl.games.lotto;

import lombok.Data;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


@Data

public class LottoGame {
    private final NumbersGenerator numbersGenerator;
    private final UserNumbers userNumbers;

    public String play(Scanner scanner) {
        StringBuilder result = new StringBuilder();
        System.out.println("Welcome to the Lotto Game!");
        System.out.println("Write 6 different numbers between 1-99");
        Set<Integer> inputNumbers = userNumbers.getNumbersFromUser(scanner);
        result.append("Your numbers: ").append(inputNumbers).append("\n");
        Set<Integer> winNumbers = numbersGenerator.generateNumber();
        result.append("Winning numbers: ").append(winNumbers).append("\n");
        String message = checkIfWin(new HashSet<>(inputNumbers), new HashSet<>(winNumbers));
        result.append(message).append("\n");
        String resultMessage = result.toString();
        System.out.println(resultMessage);
        return resultMessage;
    }

    private String checkIfWin(Set<Integer> userNumbers, Set<Integer> winNumbers) {
        userNumbers.retainAll(winNumbers);
        return generateMessage(userNumbers);
    }

    private String generateMessage(Set<Integer> guessedNumbers) {
        if (guessedNumbers.size() == 6) {
            return String.format("Congratulations! You guessed all %d numbers! You have won the grand prize.", guessedNumbers.size());
        } else if (guessedNumbers.size() >= 3) {
            return String.format("Congratulations! You guessed %d numbers.", guessedNumbers.size());
        } else
            return String.format("Unfortunately, you failed this time. You guessed %d number(s).", guessedNumbers.size());
    }
}
