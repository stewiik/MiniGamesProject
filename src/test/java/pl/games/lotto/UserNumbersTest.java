package pl.games.lotto;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Collections;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class UserNumbersTest {

    UserNumbers userNumbers = new UserNumbers();

    private Scanner mockScannerIn(String data) {
        InputStream originalInput = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(originalInput);
        return scanner;
    }

    @Test
    void should_return_numbers_in_set_when_all_in_range_1_99() {
        // given
        Set<Integer> expectedNumbers = Set.of(1, 2, 3, 4, 5, 6);
        String numbersFromUser = "1 2 3 4 5 6";
        Scanner scanner = mockScannerIn(numbersFromUser);
        // when
        final Set<Integer> userInputNumbers = userNumbers.getNumbersFromUser(scanner);
        // then
        assertThat(userInputNumbers).isEqualTo(expectedNumbers);
    }

    @Test
    void should_return_numbers_in_set_when_one_is_out_of_range() {
        // given
        Set<Integer> expectedNumbers = Set.of(1, 2, 3, 4, 5, 6);
        String numbersFromUser = "1 2 3 4 100 5 6";
        Scanner scanner = mockScannerIn(numbersFromUser);
        // when
        Set<Integer> userInputNumbers = userNumbers.getNumbersFromUser(scanner);
        // then
        assertThat(userInputNumbers).isEqualTo(expectedNumbers);
    }

    @Test
    void should_return_empty_numbers_set_when_all_out_of_range() {
        // given
        Set<Integer> expectedNumbers = Collections.emptySet();
        String numbersFromUser = "100 150 0 200 -20 -16";
        Scanner scanner = mockScannerIn(numbersFromUser);
        // when
        Set<Integer> userInputNumbers = userNumbers.getNumbersFromUser(scanner);
        // then
        assertThat(userInputNumbers).isEqualTo(expectedNumbers);
    }

    @Test
    void should_return_numbers_in_set_when_one_is_string() {
        // given
        Set<Integer> expectedNumbers = Set.of(1,2,3,4,5,6);
        String numbersFromUser = "1 2 abc 2 3 4 5 6";
        Scanner scanner = mockScannerIn(numbersFromUser);
        // when
        Set<Integer> userInputNumbers = userNumbers.getNumbersFromUser(scanner);
        // then
        assertThat(userInputNumbers).isEqualTo(expectedNumbers);
    }

    @Test
    void should_skip_repeated_numbers() {
        // given
        Set<Integer> expectedNumbers = Set.of(1,2,3,4,5,6);
        String numbersFromUser = "1 1 2 3 4 5 6";
        Scanner scanner = mockScannerIn(numbersFromUser);
        // when
        Set<Integer> userInputNumbers = userNumbers.getNumbersFromUser(scanner);
        // then
        assertThat(userInputNumbers).isEqualTo(expectedNumbers);
    }

    @Test
    void should_return_only_six_numbers_when_more_given() {
        // given
        Set<Integer> expectedNumbers = Set.of(1,2,3,4,5,6);
        String numbersFromUser = "1 2 3 4 5 6 7 8";
        Scanner scanner = mockScannerIn(numbersFromUser);
        // when
        Set<Integer> userInputNumbers = userNumbers.getNumbersFromUser(scanner);
        // then
        assertThat(userInputNumbers).isEqualTo(expectedNumbers);
    }
}
