package com.sda.p25_functional_interfaces.lambda_expression;

public class LambdaWithNoParameter {

    public static void main(String[] args) {

        SayHelloFunctionalInterface message = () -> {
            return "Hello";
        };

        System.out.println(message.sayHello()); // Hello

        // How it was prior to Java 8 (using anonymous class)
        SayHelloFunctionalInterface messageOld = new SayHelloFunctionalInterface() {
            @Override
            public String sayHello() {
                return "Hello";
            }
        };


    }


    @FunctionalInterface
    static interface SayHelloFunctionalInterface {
        // an abstract method with no input argument/parameter
        String sayHello();
    }
}



/**
 *
 * @see com.sda.p25_functional_interfaces.lambda_expression.LambdaWithSingleParameter
 * */
