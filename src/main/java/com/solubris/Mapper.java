package com.solubris;

import java.util.function.Function;
import java.util.function.Predicate;

public class Mapper implements Function<Integer, String> {
    private final Predicate<Integer> predicate;
    private final String answer;

    public Mapper(Predicate<Integer> predicate, String answer) {
        this.predicate = predicate;
        this.answer = answer;
    }

    @Override
    public String apply(Integer i) {
        return predicate.test(i) ? answer : "";
    }
}