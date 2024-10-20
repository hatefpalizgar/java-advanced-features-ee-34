package com.sda.p27_streams;

import java.util.Arrays;
import java.util.List;

public class Exercise1 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Sarah", "Mark", "Tyla", "Ellisha", "erik");


        // write a program using Streams API to print out names that start with 'E'/'e' in UPPERCASE and sorted alphabetically
        // so for example:
        // ERIK, ELLISHA

        names.stream() // Stream<String>
                .map(name -> name.toUpperCase())
                .filter(name -> name.startsWith("E"))
                .sorted()
                .forEach(name -> System.out.println(name));

        // TODO: try to change above logic to print the names in their own case. For example, "erik" should be printed out not "ERIK"
    }
}


/**
 *
 * @see com.sda.p27_streams.no1.Example01
 * */
