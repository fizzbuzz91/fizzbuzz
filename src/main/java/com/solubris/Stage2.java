package com.solubris;

import java.util.function.Function;

import static com.solubris.FizzBuzz.BUZZ;
import static com.solubris.FizzBuzz.FIZZ;

public class Stage2 implements Function<Integer, String> {
    private Mapper fizz = new MapperBuilder()
            .onPredicate(i -> i % 3 == 0 || String.valueOf(i).contains("3"))
            .answers(FIZZ)
            .build();
    private Mapper buzz = new MapperBuilder()
            .onPredicate(i -> i % 5 == 0 || String.valueOf(i).contains("5"))
            .answers(BUZZ)
            .build();
    private FizzBuzz fizzBuzz = new FizzBuzz(fizz, buzz);

    public static void main(String[] args) {
        Stage2 stage2 = new Stage2();
        for (int i = 1; i <= 100; i++) {
            System.out.println(stage2.apply(i));
        }
    }

    @Override
    public String apply(Integer i) {
        return fizzBuzz.apply(i);
    }
}
