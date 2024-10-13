package com.sda.p25_functional_interfaces.lambda_expression;

public class LambdaWithMultipleParameters {


    public static void main(String[] args) {

        // If your lambda expression is a one-liner (a method body with single line)
        // then you can skip putting curly braces

        // If your method is returning something, you can remove the 'return' keyword,
        // and Java returns by default whatever is on the right side of Lambda token
        StringConcatFunctionalInterface s = (String str1, String str2) -> str1 + " " + str2;

        System.out.println(s.concat("Hello", "World")); // Hello World
    }



    @FunctionalInterface
    static interface StringConcatFunctionalInterface {
        String concat(String a, String b);
    }
}

/**
 *
 * @see com.sda.p25_functional_interfaces.built_in_jdk_func_interfaces.PredicateExample
 * */
