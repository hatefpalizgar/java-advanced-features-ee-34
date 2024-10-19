package com.sda.p27_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main1(String[] args) {

        // you can use 'var' keyword from java 11+
        var a = new Engineer("Thomas", "Peterson", 30);
        var b = new Engineer("Thomas", "Blau", 45);
        var c = new Engineer("Henry", "Smith", 23);
        var d = new Engineer("Mike", "Doe", 25);
        var e = new Engineer("Mary", "Williams", 58);

        List<Engineer> applicants = Arrays.asList(a, b, c, d, e);

        // task: get the average age of engineers called "Thomas"

        // first solution: prior to Java 8 (without using Streams API)
        double avg = 0;  // avg = sum / count
        int sum = 0;
        int count = 0;
        for (Engineer engineer : applicants) {
            if (engineer.getFirstname().equalsIgnoreCase("thomas")) {
                count++;
                sum = sum + engineer.getAge();
            }
        }

        avg = (double) sum / count;
        System.out.println(avg); // (30 + 45)/2 = 37.5


        // second solution: post Java 8 (using Streams API)
        Stream<Engineer> applicantsStream = applicants.stream();

        Double average = applicantsStream // Stream<Engineer>
                .filter(eng -> eng.getFirstname().equalsIgnoreCase("thomas")) // Stream<Engineer>
                .map(eng -> eng.getAge()) // Stream<Integer>
                .collect(Collectors.averagingInt(  age -> age.intValue()  ));
        System.out.println(average); // 37.5



    }

    public static void main(String[] args) {
        List<String> bingoNumbers =
                Arrays.asList(
                        "N40", "N36", "B12", "B6", "G53", "G49", "G60", "G50", "g64", "I26", "I17", "I29",
                        "O71");

        // task: print out numbers that start with "g"/"G" in a sorted order
        // solution 1. without Streams API (pre-Java8)
        List<String> gNumbers = new ArrayList<>();
        for (String number: bingoNumbers) {
            if( number.toUpperCase().startsWith("G")) {
                gNumbers.add(number);
            }
        }
        gNumbers.sort((str1, str2) -> str1.compareTo(str2));
        gNumbers.forEach(str -> System.out.println(str));

        // solution 2. using Streams API(post-Java8)
        bingoNumbers.stream()
                .filter(s -> s.toUpperCase().startsWith("G"))
                .sorted()
                .forEach(System.out::println);

    }
}

/**
 *
 * TODO:
 * @see com.sda.p27_streams.Exercise1
 * */
