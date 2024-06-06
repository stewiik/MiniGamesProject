package pl.games.lotto;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LottoGameTest {
    private final UserNumbers userNumbersMock = mock(UserNumbers.class);
    private final NumbersGenerator numbersGeneratorMock = mock(NumbersGenerator.class);
    private static final Scanner scannerMock = new Scanner(System.in);

    private static Stream<Arguments> provideNumbersAndMessages() {
        final Arguments argument1 = Arguments.of(Set.of(1, 2, 3, 4, 5, 6),
                Set.of(1, 2, 3, 4, 5, 6),
                "Congratulations! You guessed all 6 numbers! You have won the grand prize.");

        final Arguments argument2 = Arguments.of(Set.of(1, 2, 3, 4, 5, 6),
                Set.of(7, 8, 9, 10, 11, 12),
                "Unfortunately, you failed this time. You guessed 0 number(s).");

        final Arguments argument3 = Arguments.of(Set.of(1, 2, 3, 4, 5, 6),
                Set.of(1, 2, 3, 4, 8, 9),
                "Congratulations! You guessed 4 numbers.");

        return Stream.of(argument1, argument2, argument3);
    }

    @ParameterizedTest(name = "player gave {0}, generated numbers were {1}, expected message {2}")
    @MethodSource("provideNumbersAndMessages")
    void should_return_correct_message_when_parameters_were_given(Set<Integer> playerNumbers,
                                                                  Set<Integer> generatedNumbers,
                                                                  String expectedMessage) {
        // given
        mockNumbers(playerNumbers, generatedNumbers);
        LottoGame lottoGame = new LottoGame(numbersGeneratorMock, userNumbersMock);

        // when
        String actualMessage = lottoGame.play(scannerMock);

        // then
        assertThat(actualMessage).contains(expectedMessage);
    }

    private void mockNumbers(Set<Integer> playerNumbers, Set<Integer> generatedNumbers) {
        when(userNumbersMock.getNumbersFromUser(scannerMock)).thenReturn(playerNumbers);
        when(numbersGeneratorMock.generateNumber()).thenReturn(generatedNumbers);
    }
}
