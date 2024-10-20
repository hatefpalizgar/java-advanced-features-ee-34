package com.sda.p27_streams.no2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example02 {
    public static void main(String[] args) {
        List<String> bingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "071"
        );

        // using Streams API, display g/G numbers in a sorted order in console
        bingoNumbers.stream()
                .map(n -> n.toUpperCase())
                .filter(n -> n.startsWith("G"))
                .sorted()
                .forEach(n -> System.out.println(n));


        // you can directly create a stream without having any collection beforehand (ad-hoc)
        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "071");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I29", "071");

        // you can concatenate streams together

        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);

        System.out.println("======== concat() ==========");
         concatStream.forEach(num -> System.out.println(num)); // concat() keeps the duplicates and doesn't discard them

        // concatStream can't be re-used from this point, since it's been closed on line 34

        System.out.println("========= distinct() ===========");
        // how to discard duplicates in a stream?
        // concatStream.distinct().forEach(num -> System.out.println(num)); // throws IllegalStateException due to the fact the stream can't be re-used since it is closed


        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

        // stream pipeline processes elements of the stream in a sequential order
        // above, "three" is passed through the whole pipeline chain first, then "four" goes through the chain
    }
}

/**
 *
 * @see com.sda.p27_streams.no3.FlatMapExample1
 * */
