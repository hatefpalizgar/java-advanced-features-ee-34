package com.sda.p25_functional_interfaces;
/*
 * Functional Interface is an interface with EXACTLY one ABSTRACT method
 * @FunctionalInterface is added so that we can mark an interface as functional.
 * Putting this annotation is optional but suggested to prevent accidental extra methods.
 *
 * A functional interface can contain any number of default or static methods.
 * A functional interface can extend another interface ONLY when the parent interface does not have any abstract method
 *
 * We have JDK built-in func interfaces like Runnable, Callable, Comparator, ActionListener etc.
 * */

@FunctionalInterface
public interface Printable {
    void print(String message);

    static void save() {
        // static methods are allowed in functional interfaces
    }

    default void someMethod() {
        // default methods are allowed in functional interfaces
    }
}
