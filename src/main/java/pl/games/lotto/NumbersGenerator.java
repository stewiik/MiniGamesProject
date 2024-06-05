package pl.games.lotto;

import java.security.SecureRandom;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumbersGenerator {
    public static final int MAX_VALUE = 99;
    public static final int NUM_OF_NUMBERS = 6;
    private final SecureRandom GENERATOR = new SecureRandom();

    Set<Integer> generateNumber() {
        return IntStream.generate(() -> GENERATOR.nextInt(MAX_VALUE + 1))
                .distinct()
                .limit(NUM_OF_NUMBERS)
                .boxed()
                .collect(Collectors.toSet());
    }
}
