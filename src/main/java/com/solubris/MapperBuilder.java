package com.solubris;

import java.util.function.Predicate;

public class MapperBuilder {
    private Predicate<Integer> predicate;
    private String answer;

    public MapperBuilder onPredicate(Predicate<Integer> predicate) {
        this.predicate = predicate;
        return this;
    }

    public MapperBuilder answers(String answer) {
        this.answer = answer;
        return this;
    }

    public Mapper build() {
        return new Mapper(predicate, answer);
    }
}