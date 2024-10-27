package com.sda.p25_functional_interfaces.method_references.challenges;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.net.CacheRequest;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        // Task 1 & 2
        List<Person> people = List.of(
                new Person("Alice", 25),
                new Person("Bob", 17),
                new Person("Charlie", 30),
                new Person("David", 15),
                new Person("Eve", 20)
        );

        AgeChecker ageChecker = p -> p.getAge() >= 18;
        List<Person> adults = people.stream()
                .filter(ageChecker::isAdult)
                .toList();

        System.out.println(adults);


        // Task 4
        var calculator = new Calculator(10, 5);
        BinaryOperator adder = Calculator::add;
        BinaryOperator subtractor = Calculator::subtract;
        BinaryOperator multiplier = Calculator::multiply;
        BinaryOperator divider = Calculator::divide;

        int sum = adder.apply(calculator.getNum1(), calculator.getNum2());
        int difference = subtractor.apply(calculator.getNum1(), calculator.getNum2());
        int product = multiplier.apply(calculator.getNum1(), calculator.getNum2());
        int quotient = divider.apply(calculator.getNum1(), calculator.getNum2());

        System.out.println("sum: " + sum);
        System.out.println("difference: " + difference);
        System.out.println("product: " + product);
        System.out.println("quotient: " + quotient);

        // Task 6
        var alice = new Person("Alice", 25);
        var bob = new Person("Bob", 30);

        Comparator<Person> ageComparator = Person::compareByAge;
        int ageDifference = ageComparator.compare(alice, bob);
        System.out.println("Age difference [Alice & Bob]: " + ageDifference);
    }

    @Getter
    @AllArgsConstructor
    @ToString
    static class Person {
        private String name;
        private int age;

        public static int compareByAge(Person p1, Person p2) {
            return p1.getAge() - p2.getAge();
        }
    }

    @Getter
    @AllArgsConstructor
    static class Calculator {
        private int num1;
        private int num2;

        public static int add(int a, int b) {
            return a + b;
        }

        public static int subtract(int a, int b) {
            return a - b;
        }

        public static int multiply(int a, int b) {
            return a * b;
        }

        public static int divide(int a, int b) {
            return a / b;
        }
    }

    @FunctionalInterface
    interface AgeChecker {
        boolean isAdult(Person person);
    }

    @FunctionalInterface
    interface BinaryOperator {
        int apply(int a, int b);
    }
}
