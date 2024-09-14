package com.sda.p07_abstraction_oop_principle.p09_interfaces;

// Prior to Java 8, only abstract methods were allowed in interfaces
// but from Java8+, it is also possible to have concrete methods in interfaces
// BUT, you have to define them as 'default'
// Usually, we use interfaces for pure abstraction (no concrete methods),
// if you want to have an interface with default method(s), prefer to use abstract class.

// Primarily, interfaces were designed to ONLY have abstract methods

// Interface is a 'contract'
public interface Loveable {
    void love(); // methods are public and abstract by default in an interface

    default void someConcreteMethod() {

    }

    // you can have static methods in interfaces
    static int getAge() {
        return 0;
    }

}
