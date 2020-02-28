package com.adeli.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        // Function takes 1 argument and produces 1 result
        int increment = incrementByOne(1);
        System.out.println(increment);

        int increment2 = incrementByOnFunction.apply(1);
        System.out.println(increment2);

        int multiply = multipleByTenFunction.apply(increment2);
        System.out.println(multiply);

        Function<Integer, Integer> addByOneAndThenMultiplyByTen =
                incrementByOnFunction.andThen(multipleByTenFunction);
        System.out.println(addByOneAndThenMultiplyByTen.apply(4));

        // BiFunction takes 2 argument and produces 1 result
        System.out.println(
                incrementByOneAndMultiply(4, 100)
        );

        System.out.println(
                incrementByOneAndMultiplyFunction.apply(4, 100)
        );
    }

    static Function<Integer, Integer> incrementByOnFunction = number -> number + 1;

    static Function<Integer, Integer> multipleByTenFunction = number -> number * 10;

    static int incrementByOne(int number) {
        return number + 1;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyFunction =
            (numberToIncrementByOne, numberToMultiplyBy)
                    -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOneAndMultiply(int number, int numToMultiply) {
        return (number + 1) * numToMultiply;
    }
}
