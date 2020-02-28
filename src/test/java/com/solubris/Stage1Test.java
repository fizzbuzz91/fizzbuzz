package com.solubris;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.solubris.FizzBuzz.BUZZ;
import static com.solubris.FizzBuzz.FIZZ;
import static org.assertj.core.api.Assertions.assertThat;

class Stage1Test {
    Set<Integer> untested = IntStream.range(1, 101).boxed().collect(Collectors.toSet());

    public Function<Integer, String> underTest() {
        return new Stage1();
    }

    @Test
    void fizzEveryThirdTime() {
        for (int i = 3; i <= 100; i += 3) {
            String result = underTest().apply(i);
            untested.remove(i);

            assertThat(result)
                    .doesNotContain(String.valueOf(i))
                    .contains(FIZZ);
        }
    }

    @Test
    void buzzEveryFifthTime() {
        for (int i = 5; i <= 100; i += 5) {
            String result = underTest().apply(i);
            untested.remove(i);

            assertThat(result)
                    .doesNotContain(String.valueOf(i))
                    .contains(BUZZ);
        }
    }

    @Test
    void fizzBuzzEveryFifteenthTime() {
        for (int i = 15; i <= 100; i += 15) {
            String result = underTest().apply(i);
            untested.remove(i);

            assertThat(result)
                    .isEqualTo(FIZZ + BUZZ);
        }
    }

    @Test
    void theNumberEveryOtherTime() {
        fizzEveryThirdTime();
        buzzEveryFifthTime();
        fizzBuzzEveryFifteenthTime();
        for (Iterator<Integer> iterator = untested.iterator(); iterator.hasNext(); ) {
            int i = iterator.next();
            String result = underTest().apply(i);
            iterator.remove();
            assertThat(result)
                    .isEqualTo(String.valueOf(i));
        }
        assertThat(untested)
                .isEmpty();
    }
}