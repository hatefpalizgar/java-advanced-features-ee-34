package com.sda.p15_final_and_constants;

/**
 * The {@code Main} class demonstrates the use of the {@code final} keyword in Java. It provides
 * examples of final variables, methods, and classes, illustrating how they affect the behavior of
 * the Java program.
 *
 * <p>Key Concepts Illustrated:
 *
 * <ul>
 *   <li><b>Final Variables:</b> Shows how a final variable, once assigned a value, cannot be
 *       changed. Attempting to reassign a final variable results in a compile-time error.
 *   <li><b>Final Methods:</b> Demonstrates that a final method cannot be overridden by a subclass,
 *       thus preserving the method's implementation across the inheritance hierarchy.
 *   <li><b>Final Classes:</b> Illustrates that a final class cannot be extended, preventing any
 *       subclass from altering its behavior or structure.
 * </ul>
 */
public class FinalMain {
    public static void main(String[] args) {

        /* ========================================================================================== */
        //                                   Java final Variable
        /* ========================================================================================== */
        // In Java, we cannot change the value of a final variable
        // Once a final variable is assigned, it always contains the SAME value.
        // If we try to change a final variable, a compile-time error is generated.
        final int x = 100;

        // x = 89; // compile-time error


        /* ========================================================================================== */
        //                                    Java final Method
        /* ========================================================================================== */
        // In Java, a final method cannot be overridden by the child class
        class ChildClass extends NonFinalClass {
            // a final method cannot be overridden by the child class
            // @Override
            // public final void aFinalMethod() {
            //  System.out.println("This is a final method");
            // }
        }

        /* ========================================================================================== */
        //                                    Java final Class
        /* ========================================================================================== */
        // In Java, a final class cannot be inherited by another class
        // class AnotherChildClass extends FinalClass {}


        // FinalClass: is a class name in Java
        // com.sda.p15_final_and_constants.FinalClass: is a Fully Qualified Name (FQN) in Java and is used to UNIQUELY identify a class

    }



}

class NonFinalClass {
    public final void aFinalMethod() {
        System.out.println("This is a final method");
    }
}


final class FinalClass {}
