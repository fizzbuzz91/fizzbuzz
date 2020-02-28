package com.solubris;

import java.util.function.Function;

public class FizzBuzz implements Function<Integer, String> {
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    private final Function<Integer, String>[] mappers;

    @SafeVarargs
    public FizzBuzz(Function<Integer, String>... mappers) {
        this.mappers = mappers;
    }

    @Override
    public String apply(Integer i) {
        StringBuilder result = new StringBuilder();
        for (Function<Integer, String> mapper : mappers) {
            result.append(mapper.apply(i));
        }
        if (result.length() == 0) {
            result.append(i);
        }
        return result.toString();
    }
}
