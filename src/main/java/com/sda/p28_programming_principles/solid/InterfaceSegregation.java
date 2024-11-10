package com.sda.p28_programming_principles.solid;
// SOLID
// S: Single Responsibility
// O: Open/Closed Principle
// L: Liskov Substitution Principle (LSP)
// I: Interface Segregation(ISP)
// Definition: Clients (implementors of an interface) should not be forced to depend on interfaces they do not use.
// Prefer many specific interfaces over a single general-purpose interface.
public class InterfaceSegregation {

    interface MultiFunctionDevice {
        void print(String message);
        void scan(String message);
        void fax(String message);
    }

    // BadPrinter is forced to implement all methods of interface
    static class BadPrinter implements MultiFunctionDevice {

        @Override
        public void print(String message) {
            System.out.println("printing... " + message);
        }

        @Override
        public void scan(String message) {
            // not supported
        }

        @Override
        public void fax(String message) {
            // not supported
        }
    }

    // to fix this we have to segregate (separate) the interface into multiple interfaces
    interface Printer {
        void print(String message);
    }

    interface Scanner {
        void print(String message);
    }

    interface Fax {
        void print(String message);
    }

    static class GoodPrinter implements Printer {
        @Override
        public void print(String message) {
            System.out.println("printing... " + message);
        }
    }

}
