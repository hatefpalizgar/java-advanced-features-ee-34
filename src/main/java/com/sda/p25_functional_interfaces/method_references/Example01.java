package com.sda.p25_functional_interfaces.method_references;

/**
 * Method reference is a shorthand notation of a lambda expression to call a method. If your lambda
 * expression is like this:
 *
 * <pre>
 *     str -> System.out.println(str)
 *  </pre>
 *
 * then you can replace it with a method reference like this:
 *
 * <pre>
 *      System.out::println
 *  </pre>
 *
 * The <code>::</code> operator is used in method reference to separate the class or object from the
 * method name <br>
 * <br>
 *
 * <h2>Four types of method references:</h2>
 *
 * <li>Method reference to an instance method of an object – <code> object::instanceMethod </code> (Example01)
 * <li>Method reference to a static method of a class – <code> Class::staticMethod </code> (Example02)
 * <li>Method reference to an instance method of an arbitrary object of a particular type – <code>
 *      Class::instanceMethod </code> (Example03)
 * <li>Method reference to a constructor – <code> Class::new </code>
 *
 * @see <a
 *     href="https://beginnersbook.com/2017/10/method-references-in-java-8/">method-references-in-java-8</a>
 *     <pre></pre>
 *     <h1>Method reference to an instance method of an object:</h1>
 */

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


/**
 *
 * @see com.sda.p25_functional_interfaces.method_references.Example02
 * */
