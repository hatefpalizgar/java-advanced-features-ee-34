package com.sda.p25_functional_interfaces.method_references;

import java.util.Arrays;

/**
 *
 *
 * <h1>Method reference to an instance method of an arbitrary object of a particular type
 * <code> Class::instanceMethod </code> </h1>
 */
public class Example03 {
    public static void main(String[] args) {
        String[] stringArray = {"Steve", "Rick", "Aditya", "Negan", "Lucy", "Sam", "John"};
//        Arrays.sort(stringArray,    (str1, str2) -> str1.compareToIgnoreCase(str2)    );  // impl.1 using lambda expression
        Arrays.sort(stringArray, String::compareToIgnoreCase);  // impl.2 using method reference

        for (String str: stringArray) {
            System.out.println(str);
        }
    }
}

/**
 *
 * @see com.sda.p25_functional_interfaces.method_references.Example04
 * */
