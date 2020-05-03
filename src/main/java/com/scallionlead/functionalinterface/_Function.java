package com.scallionlead.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment = incrementByOne(1);
        System.out.println(increment);

        // Function = Function that take 1 argument
        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multipleBy10Function.apply(increment2);
        System.out.println(multiply);

        // Chain functions with andThen
        Function<Integer, Integer> increThenMulti = incrementByOneFunction.andThen(multipleBy10Function);
        int increment3 = increThenMulti.apply(4);
        System.out.println(increment3);

        // BiFunction = Function that takes 2 arguments
        System.out.println(incrementByOneAndMultiply(4, 100));
        Integer increment4 = increAndMultiBiFunction.apply(4, 100);
        System.out.println(increment4);

    }

    static Function<Integer, Integer> incrementByOneFunction = number -> ++number;

    static Function<Integer, Integer> multipleBy10Function = number -> number * 10;

    static int incrementByOne(int num) {
        return num + 1;
    }

    static BiFunction<Integer, Integer, Integer> increAndMultiBiFunction = (numberToIncre, numberToMulti) -> (numberToIncre + 1)*numberToMulti;

    static int incrementByOneAndMultiply(int num, int numToMultiplyBy) {
        return (num + 1) * numToMultiplyBy;
    }
}
