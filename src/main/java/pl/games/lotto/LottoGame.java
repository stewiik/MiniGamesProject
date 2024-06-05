package pl.games.lotto;

import lombok.Data;
import pl.games.PlayGame;
import java.util.Set;

@Data

public class LottoGame implements PlayGame {
    private final NumbersGenerator numbersGenerator;
    private final UserNumbers userNumbers;

    @Override
    public void play() {
        System.out.println("Welcome to the Lotto Game!");
        System.out.println("Write 6 different numbers between 1-99");
        Set<Integer> inputNumbers = userNumbers.getNumbersFromUser();
        System.out.println("Your numbers: " + userNumbers);
        Set<Integer> winNumbers = numbersGenerator.generateNumber();
        System.out.println("Winning numbers: " + winNumbers);
        checkIfWin(inputNumbers, winNumbers);
    }

    private void checkIfWin(Set<Integer> userNumbers, Set<Integer> winNumbers) {
        userNumbers.retainAll(winNumbers);
        printMessage(userNumbers);
    }

    private void printMessage(Set<Integer> guessedNumbers) {
        System.out.println(generateMessage(guessedNumbers));
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
