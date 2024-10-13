package com.sda.p25_functional_interfaces.lambda_expression;

public class LambdaWithSingleParameter {

    public static void main(String[] args) {

        IncrementFunctionalInterface f = (number) -> {
            return number + 5;
        };

        // If your lambda expression/function takes ONLY a single parameter,
        // you can remove the brackets around the input arg/param
        IncrementFunctionalInterface g = num -> {
            return num + 7;
        };

        System.out.println(f.increment(14)); // 19
        System.out.println(g.increment(22)); // 29

    }
}


@FunctionalInterface
interface IncrementFunctionalInterface {
    // an abstract method with single argument/parameter
    int increment(int num);
}


/**
 *
 * @see com.sda.p25_functional_interfaces.lambda_expression.LambdaWithMultipleParameters
 * */
