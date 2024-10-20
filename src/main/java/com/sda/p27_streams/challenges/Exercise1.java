package com.sda.p27_streams.challenges;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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


    @Test
    public void testSumOfEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assertions.assertEquals(0, sumOfEvenNumbers(null));
        Assertions.assertEquals(30, sumOfEvenNumbers(numbers));
        Assertions.assertEquals(0, sumOfEvenNumbers(Collections.emptyList()));
        Assertions.assertEquals(8, sumOfEvenNumbers(Arrays.asList(1, 3, 5, 2, 6)));
    }
}
