package pl.games.lotto;

import java.security.SecureRandom;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static pl.games.lotto.AppConstants.*;

public class NumbersGenerator {

    private final SecureRandom GENERATOR = new SecureRandom();

    Set<Integer> generateNumber() {
        return IntStream.generate(() -> GENERATOR.nextInt(MAX_VALUE + 1))
                .distinct()
                .limit(NUM_OF_NUMBERS)
                .boxed()
                .collect(Collectors.toSet());
    }
}
