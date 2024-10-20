package com.sda.p27_streams.challenges;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Read more about "Red, Green, Refactor" and TDD (Test Driven Development) here: https://www.codecademy.com/article/tdd-red-green-refactor
 * */
public class Exercise1 {
    /**
     * Task 1: Given a list of integers, return the sum of all the even numbers in the list using the Stream API.
     * If the input list is null, return 0.
     */
    public int sumOfEvenNumbers(List<Integer> numbers) {
        if (numbers == null) {
            return 0;
        }
        return numbers.stream()
                .filter(num -> num % 2 == 0) // Stream<Integer> of even numbers
                .mapToInt(num -> num.intValue()) // intStream
                .sum();
    }


    /**
     * Task 2: Given a list of strings, return a list of all strings that start with the letter "a" and have exactly 3 characters
     * using the Stream API. The resulting list should be sorted alphabetically.
     * If the input list is null, return an empty list.
     */
    public List<String> stringsStartWithA(List<String> strings) {
        if (strings == null) {
            return Collections.emptyList();
        }
        return strings.stream()
                .filter(s -> s.startsWith("a"))
                .filter(s -> s.length() == 3)
                .sorted()
                .toList();
    }


    /**
     * Task 3: Given a list of strings, return the number of distinct words (ignoring case) in the list using the Stream API.
     * If the input list is null, return 0.
     */
    public int countDistinctWords(List<String> input) {
        if (input == null) {
            return 0;
        }
        return (int) input.stream()
                .map(String::toLowerCase)
                .distinct()
                .count();
    }

    /**
     * Task 4: Given a list of strings, return a map where the keys are the length of each string,
     * and the values are a list of strings with that length, sorted alphabetically.
     * If the input list is null, return an empty map.
     */
    public Map<Integer, List<String>> groupStringsByLength(List<String> input) {
        if (input == null) return Collections.emptyMap();

        Function<String, Integer> classifier = s -> s.length(); // group input strings based on their length
        Supplier<Map<Integer, List<String>>> mapFactory = () -> new HashMap<>(); // return the final result as map
        Collector<String, ?, List<String>> downstream = Collectors.toList(); // the list to which strings are collected into (values of our map)

        return input.stream()
                .collect(Collectors.groupingBy(classifier, mapFactory, downstream));
    }

    /**
     * Task 5: Given a list of integers, return the product of all the numbers in the list that are greater than 10
     * and less than 100 using the Stream API. If there are no numbers in the list that meet these criteria,
     * return 1. If the input list is null, return 0.
     */
    public int productOfNumbersBetweenTenAndHundred(List<Integer> input) {
        if (input == null) return 0;

        // Solution 1:
//        List<Integer> numbersBetween10And100 = input.stream()
//                .filter(number -> number > 10 && number < 100).toList();
//
//        int prod = 1;
//        for (Integer num : numbersBetween10And100) {
//            prod *= num;
//        }
//
//        return prod;

        // Solution 2:
        // point: whenever you want to come down to a single number from a collection of numbers, consider using reduce() function
        BinaryOperator<Integer> accumulator = (num1, num2) -> num1 * num2;
        return input.stream()
                .filter(num -> num > 10 && num < 100)
                .reduce(1, accumulator);

    }


    // =================================== TESTS ==========================================

    @Test
    public void testSumOfEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertEquals(0, sumOfEvenNumbers(null));
        assertEquals(30, sumOfEvenNumbers(numbers));
        assertEquals(0, sumOfEvenNumbers(Collections.emptyList()));
        assertEquals(8, sumOfEvenNumbers(Arrays.asList(1, 3, 5, 2, 6)));
    }

    @Test
    public void testStringsStartingWithA() {
        List<String> strings = List.of("abcd", "abbc", "book", "aac", "add", "aad");
        List<String> expected = List.of("aac", "aad", "add");
        List<String> actual = stringsStartWithA(strings);
        assertEquals(expected, actual);
        assertEquals(Collections.emptyList(), stringsStartWithA(null));
    }

    @Test
    public void testCountDistinctWords() {
        // given (Arrange)
        List<String> input = List.of("Hello", "hello", "WORLD", "world", "world");
        int expected = 2;

        // when (Act)
        int actual = countDistinctWords(input);

        // then (Assert)
        assertEquals(expected, actual);
        assertEquals(0, countDistinctWords(null));  // null input test/assertion
        assertEquals(0, countDistinctWords(Collections.emptyList())); // empty input test
        assertEquals(1, countDistinctWords(Collections.singletonList("hello"))); // single input test
    }

    @Test
    public void testGroupStringsByLength() {
        // given
        List<String> input = List.of("a", "x", "bb", "ccc", "dddd", "eeeee");
        Map<Integer, List<String>> expected = new HashMap<>();
        expected.put(1, List.of("a", "x"));
        expected.put(2, List.of("bb"));
        expected.put(3, List.of("ccc"));
        expected.put(4, List.of("dddd"));
        expected.put(5, List.of("eeeee"));
        // 1 -> [a, x]
        // 2 -> [bb]
        // 3 -> [ccc]
        // 4 -> [dddd]
        // 5 -> [eeeee]

        // when
        Map<Integer, List<String>> actual = groupStringsByLength(input);

        // then
        assertEquals(expected, actual); // happy path (correct form of input, yields correct form of output)
        assertEquals(Collections.emptyMap(), groupStringsByLength(null));
        assertEquals(Collections.emptyMap(), groupStringsByLength(Collections.emptyList()));
    }


    @Test
    public void testProductOfNumbersBetweenTenAndHundred() {
        // given
        List<Integer> input = List.of(1, 5, 12, 25, 50, 100, 222);

        // when & then
        assertEquals(15000, productOfNumbersBetweenTenAndHundred(input)); // happy path
        assertEquals(0, productOfNumbersBetweenTenAndHundred(null));
        assertEquals(1, productOfNumbersBetweenTenAndHundred(Collections.emptyList()));
        assertEquals(1, productOfNumbersBetweenTenAndHundred(List.of(1, 2, 3)));
    }


}
