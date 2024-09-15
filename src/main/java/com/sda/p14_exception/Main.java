package com.sda.p14_exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main1(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // maximum index = 4

        System.out.println(arr[8]); // throws ArrayIndexOutOfBoundsException: Index 8 out of bounds for length 5
        // our app crashed on line 7 due to the exception
        System.out.println("this line never gets executed");
    }

    public static void main2(String[] args) {
        int a = 43;
        int b = 0;

        // try-catch block
        try {
            System.out.println(a / b); // throws ArithmeticException: / by zero
            System.out.println("This line never gets executed");
            System.out.println("This line too");
        } catch (ArithmeticException ex) {
            System.out.println("Exception occurred!");
        }

        // app execution should continue as normal now
        System.out.println("This line should be executed");

    }

    /* ========================================================================================== */
    //                                  Exception Hierarchy
    /* ========================================================================================== */

    // https://rollbar.com/blog/java-exceptions-hierarchy-explained/
    // https://facingissuesonit.com/java-exception-handling/

    /* ========================================================================================== */
    //                            Checked (compile-time) vs. Unchecked (runtime) Exceptions
    /* ========================================================================================== */
    // checked(compile-time) exceptions
    // These exceptions are checked by compiler at compile time, so you're forced to handle it
    // Classes that directly inherit Exception class

    // unchecked (runtime) exceptions
    // These exceptions are not checked at compile time.
    // Classes that inherits RuntimeException class like ArithmeticException, NullPointerException(NPE)


    /* ========================================================================================== */
    //                       Handling multiple exceptions using Pipe operator
    /* ========================================================================================== */

    public static void main3(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // maximum index = 4
        try {
            System.out.println(arr[8]); // throws ArrayIndexOutOfBoundsException: Index 8 out of bounds for length 5
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("exception caught: " + e);
        }
    }

    /* ========================================================================================== */
    //                    Handling multiple exceptions using multiple catch blocks
    //                          Start with catching most specific exceptions
    //                          End with catching most generic exceptions
    /* ========================================================================================== */
    public static void main4(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // maximum index = 4

        try {
            int result = 10 / 0; // throws ArithmeticException
            System.out.println(arr[8]); // throws ArrayIndexOutOfBoundsException: Index 8 out of bounds for length 5
        } catch (ArrayIndexOutOfBoundsException e) {
            // some code specific to handling ArrayIndexOutOfBoundsException
            System.out.println("ArrayIndexOutOfBoundsException caught");
        } catch (ArithmeticException e) {
            // some code specific to handling ArithmeticException
            System.out.println("ArithmeticException caught");
        } catch (RuntimeException e) { // every child is also of a parent class type
            System.out.println("RuntimeException caught");
        } catch (Exception e) { // handling both runtime and compile-time exceptions the same way
            System.out.println("Exception caught");
        } catch (Throwable e) { // handling both errors and exceptions the same way
            System.out.println("Throwable caught: " + e);
        }

    }

    /* ========================================================================================== */
    //                                 How to throw exception
    /* ========================================================================================== */
    public static void main5(String[] args) {
        try {
            someMethod(false);
        } catch (IllegalAccessException e) {
            // handle this...
        }
    }

    // use `throw` keyword to throw exceptions
    // use 'throws' keyword in method header/signature to notify others about your exception
    public static void someMethod(boolean isTurnedOn) throws IllegalAccessException {
        if (isTurnedOn) {
            System.out.println("Washing machine is turned on");
        } else {
            System.out.println("Washing machine is turned off");
            throw new IllegalAccessException("A turned off machine can't be tested");
        }
    }


    /* ========================================================================================== */
    //                                    Finally Block
    //  is useful when we want to run a piece of logic in all circumstances. For example,
    // as we will see in 'I/O' topic, closing of the file resources should be in finally block
    /* ========================================================================================== */

    public static void main6(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        try {
            System.out.println(arr[7]); // throws ArrayIndexOutOfBoundsException
        } catch (IllegalArgumentException e) { // catching a wrong type of exception
            System.out.println("Exception caught: " + e);
        } finally { // Java8+
            // whatever in finally block is guaranteed to execute no matter the handling of the exception
            System.out.println("This line should always be printed, no matter the exception");
        }

        System.out.println("This never prints anything");
    }


    /* ========================================================================================== */
    //                                    Try with resources
    // https://www.baeldung.com/java-try-with-resources
    /* ========================================================================================== */
    public static void main7(String[] args) {
        // without try-with-resources
//        FileReader fr = null;
//        try {
//            fr = new FileReader("src/com/some-file.txt");
//            int c;
//            while ((c = fr.read()) != -1) {
//                System.out.println((char) c);
//            }
//        } catch (Exception e) {
//            System.out.println("Exception occurred");
//        } finally {
//           try {
//               fr.close();
//           } catch (IOException e) {
//               System.out.println("IOException occurred");
//           }
//        }

        // try-with-resources
        // automatically takes care of closing the resources
        // so, here 'fr' will be closed automatically
        try (FileReader fr = new FileReader("src/com/some-file.txt")) {
            int c;
            while ((c = fr.read()) != -1) {
                System.out.println((char) c);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred");
        }
    }



    /* ========================================================================================== */
    //                                    Custom Exceptions
    /* ========================================================================================== */
    // 1. Create a custom exception: PasswordNotFoundException
    // 2. Create a method that throws the custom exception
    public static void main(String[] args) {
        aMethodThatThrowsCustomException();
    }

    public static void aMethodThatThrowsCustomException() {
        throw new PasswordNotFoundException("Password is invalid");
    }

    // TODO: How error is different to exception?

}
