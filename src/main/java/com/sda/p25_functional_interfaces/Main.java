package com.sda.p25_functional_interfaces;

public class Main {
    public static void main(String[] args) {

        // using anonymous class
//        Printable printable = new Printable() {
//            @Override
//            public void print(String message) {
//
//            }
//        };

        // using Lambda Expression
        // Lambda Token: ->
        // Left side of token: list all the inputs(args) to the abstract method
        // Right side of token: the body of the abstract method
        Printable printable = (String text) -> {
            System.out.println(text);
        };

        printable.print("Hello World");


    }
}
