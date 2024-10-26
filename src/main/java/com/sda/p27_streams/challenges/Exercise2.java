package com.sda.p27_streams.challenges;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Exercise2 {

    /**
     * Task 1:
     * Given a list of strings, return the longest string.
     * If there are multiple longest strings, return the first one.
     */

    private String longestString(List<String> strings) {
        return strings.stream()
                .max(Comparator.comparingInt(s -> s.length()))
                .orElse("");
    }

    /**
     * Task 2:
     * Given a list of integers, return a new list where each integer is multiplied by 2.
     */
    public List<Integer> doubleList(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n * 2)
                .toList();
    }


    /**
     * Task 3:
     * Given a list of integers, return the sum of all the even numbers in the list.
     */
    public int sumEvenNumbers(List<Integer> numbers) {
        BinaryOperator<Integer> accumulator = (num1, num2) -> num1 + num2;
        return numbers.stream()
                .filter(n -> n % 2 == 0) // let even numbers to pass through
                .reduce(accumulator)
                .orElse(0);
    }


    /**
     * Task 4:
     * Given a list of strings, return the concatenation of all the strings that have length greater than 3
     * and start with the letter 'a', separated by a comma.
     */
    public String concatFilteredStrings(List<String> strings) {
        return strings.stream()
                .filter(str -> str.length() > 3 && str.startsWith("a"))
                .collect(Collectors.joining(","));
    }



    // =================================== TEST ==============================
    @Test
    public void testLongestString() {
        // given
        List<String> strings = List.of("one", "two", "three", "four", "five");
        String expected = "three";

        // when
        String actual = longestString(strings);

        // then
        assert actual.equals(expected); // happy path
        assert longestString(Collections.emptyList()).isEmpty();
    }

    @Test
    public void testDoubleList() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // when
        List<Integer> actual = List.of(2, 4, 6, 8, 10);

        // then
        assert doubleList(numbers).equals(actual);
    }

    @Test
    public void testSumEvenNumbers() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int expected = 30;

        // when
        int actual = sumEvenNumbers(numbers);

        // then
        assert actual == expected; // happy path
        assert sumEvenNumbers(Collections.emptyList()) == 0;
    }


    @Test
    public void testConcatFilteredStrings() {
        // given
        List<String> strings = List.of("apple", "banana", "avocado", "and", "orange", "apricot");
        String expected = "apple,avocado,apricot";

        // when
        String actual = concatFilteredStrings(strings);

        // then
        assert expected.equals(actual);
    }

}
