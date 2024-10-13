package com.sda.p25_functional_interfaces.method_references;

public class Example01 {
    public static void main(String[] args) {
        Displayable displayable = () -> System.out.println("Hello World");
        displayable.display(); // Hello World


        Printer printer = new Printer();

        // anything I put on the right side of Lambda token that follows the structure of
        // display() method, would be correct and works fine.
        // printer::print is literally referencing print() method of printer object
        Displayable monitor = printer::print;
        // above code is equivalent to below code
        // Displayable monitor = () -> printer.print();
        // using printer::print you are telling monitor object to use the same
        // logic inside print() method of the printer object and don't expect us to write the lambda
        // expression explicitly

        monitor.display(); // printing....

        // NB! on line 16, we are NOT calling print() method. We are just
        // REFERENCING it

        // the actual call to print() method is done on line 23
    }


    @FunctionalInterface
    static interface Displayable {
        void display();
    }


    static class Printer {
        public void print() {
            System.out.println("printing....");
        }
    }
}
