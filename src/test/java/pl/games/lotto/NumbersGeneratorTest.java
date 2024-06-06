package pl.games.lotto;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.games.lotto.AppConstants.NUM_OF_NUMBERS;

class NumbersGeneratorTest {
    NumbersGenerator numbersGenerator = new NumbersGenerator();

    @Test
    void should_return_six_numbers() {
        // when
        Set<Integer> generatedNumbers = numbersGenerator.generateNumber();
        // then
        assertThat(generatedNumbers).hasSize(NUM_OF_NUMBERS);
    }

    @Test
    void should_return_numbers_in_range_1_99() {
        // when
        Set<Integer> generatedNumbers = numbersGenerator.generateNumber();
        // then
        assertThat(generatedNumbers).allMatch(num -> num > 0 && num < 100);
    }

    @Test
    void should_return_unique_numbers() {
        // when
        Set<Integer> generatedNumbers = numbersGenerator.generateNumber();
        // then
        assertThat(generatedNumbers).doesNotHaveDuplicates();
    }

}