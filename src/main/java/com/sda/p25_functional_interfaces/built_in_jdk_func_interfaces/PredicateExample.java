package com.sda.p25_functional_interfaces.built_in_jdk_func_interfaces;

import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {
        Checker<String> checker = (message) -> message.contains("Java");

        boolean isAJavaDeveloper = checker.check("John is a Java developer"); // true


        Checker<Person> ageChecker = (person) -> {
            return person.getAge() > 30;
        };

        Person john = new Person("John", 24);
        boolean result = ageChecker.check(john);
        System.out.println(result);  // false

        Predicate<Person> nameTester = (person) -> person.getName().contains("H");

        System.out.println(nameTester.test(john)); //false
        System.out.println(nameTester.test(new Person("Hatef", 35))); //true

    }
}


@FunctionalInterface
interface Checker<T> {
    boolean check(T input);
}


/**
 *
 * @see com.sda.p25_functional_interfaces.built_in_jdk_func_interfaces.ConsumerExample
 * */
