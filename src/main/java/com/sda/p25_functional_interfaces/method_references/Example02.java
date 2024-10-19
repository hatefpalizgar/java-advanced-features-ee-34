package com.sda.p25_functional_interfaces.method_references;

/**
 * <h1>Method reference to a static method of a class <code> Class::staticMethod </code></h1>
 */
public class Example02 {
    public static void main(String[] args) {
        // Calculator calculator = (numA, numB) -> numA * numB; // impl.1 using lambda expression
        Calculator calculator = Multiplication::multiply; // impl.2 using method references

        int result = calculator.calculate(11, 5);
        System.out.println("Product of given numbers is: " + result); // 55
    }
}

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

class Multiplication {
    public static int multiply(int a, int b) {
        return a * b;
    }
}

/**
 *
 * @see com.sda.p25_functional_interfaces.method_references.Example03
 * */
