package com.sda.p25_functional_interfaces.built_in_jdk_func_interfaces;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<String, String> stringFunc = input -> input.substring(5);

        String output = stringFunc.apply("This is a test function in Java");

        System.out.println(output); // is a test function in Java


        Function<String, Integer> characterCount = txt -> txt.length();
        System.out.println(characterCount.apply("Hello World")); // 11
    }
}

/**
 * Next: Method References
 *
 * @see com.sda.p25_functional_interfaces.method_references.Example01
 */
