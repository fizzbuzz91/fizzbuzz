package com.solubris;

import static com.solubris.FizzBuzz.BUZZ;
import static com.solubris.FizzBuzz.FIZZ;

public class Stage1 {
    static FizzBuzz fizzBuzz = new FizzBuzz(Stage1::fizz, Stage1::buzz);

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(fizzBuzz.answer(i));
        }
    }

    private static String fizz(int i) {
        if (i % 3 == 0) {
            return FIZZ;
        }
        return "";
    }

    private static String buzz(int i) {
        if (i % 5 == 0) {
            return BUZZ;
        }
        return "";
    }

}
