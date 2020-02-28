package com.solubris;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static com.solubris.FizzBuzz.BUZZ;
import static com.solubris.FizzBuzz.FIZZ;
import static org.assertj.core.api.Assertions.assertThat;

class Stage2Test extends Stage1Test {

    @Override
    public Function<Integer, String> underTest() {
        return new Stage2();
    }

    @Test
    void fizzForEveryThreeInLastDigit() {
        for (int i = 3; i <= 100; i += 10) {
            String result = underTest().apply(i);
            untested.remove(i);

            assertThat(result)
                    .doesNotContain(String.valueOf(i))
                    .contains(FIZZ);
        }
    }

    @Test
    void fizzForEveryThreeInTensDigit() {
        for (int i = 30; i <= 39; i += 1) {
            String result = underTest().apply(i);
            untested.remove(i);

            assertThat(result)
                    .doesNotContain(String.valueOf(i))
                    .contains(FIZZ);
        }
    }

    @Test
    void buzzForEveryFiveInLastDigit() {
        for (int i = 5; i <= 100; i += 10) {
            String result = underTest().apply(i);
            untested.remove(i);

            assertThat(result)
                    .doesNotContain(String.valueOf(i))
                    .contains(BUZZ);
        }
    }

    @Test
    void buzzForEveryFiveInTensDigit() {
        for (int i = 50; i <= 59; i += 1) {
            String result = underTest().apply(i);
            untested.remove(i);

            assertThat(result)
                    .doesNotContain(String.valueOf(i))
                    .contains(BUZZ);
        }
    }

    @Test
    void fizzBuzzForThreeAndFive() {
        String result;
        result = underTest().apply(35);
        untested.remove(35);

        assertThat(result)
                .isEqualTo(FIZZ + BUZZ);

        result = underTest().apply(53);
        untested.remove(53);

        assertThat(result)
                .isEqualTo(FIZZ + BUZZ);
    }

    @Override
    @Test
    void theNumberEveryOtherTime() {
        fizzForEveryThreeInLastDigit();
        fizzForEveryThreeInTensDigit();
        buzzForEveryFiveInLastDigit();
        buzzForEveryFiveInTensDigit();
        fizzBuzzForThreeAndFive();
        super.theNumberEveryOtherTime();
    }
}