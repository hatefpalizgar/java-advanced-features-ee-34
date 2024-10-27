package com.sda.p26_optionals.challenges;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {

    // Task 1
    public Optional<Integer> parseInt(String str) {
        try {
            return Optional.of(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    // Task 4
    public Optional<Integer> square(Optional<Integer> numOpt) {
        return numOpt.map(integer -> integer * integer);
    }


    // Task 5
    public List<String> getNonEmptyStrings(List<Optional<String>> stringOpts) {
        List<String> nonEmptyStrings = new ArrayList<>();
        for (Optional<String> stringOpt : stringOpts) {
            stringOpt.ifPresent(nonEmptyStrings::add);
        }
        return nonEmptyStrings;
    }

    // Task1-test
    @Test
    void testParseInt() {
        Optional<Integer> numOpt1 = Optional.of(123);
        Optional<Integer> numOpt2 = Optional.empty();
        assertEquals(numOpt1, parseInt("123"));
        assertEquals(numOpt2, parseInt("abc"));
    }

    // Task4-test-1
    @Test
    public void testSquareWithPresentValue() {
        // Given
        Optional<Integer> numOpt = Optional.of(5);
        // When
        Optional<Integer> resultOpt = square(numOpt);
        // Then
        Assertions.assertTrue(resultOpt.isPresent());
        Assertions.assertEquals(25, resultOpt.get());
    }

    // Task4-test-2
    @Test
    public void testSquareWithEmptyValue() {
        // Given
        Optional<Integer> numOpt = Optional.empty();
        // When
        Optional<Integer> resultOpt = square(numOpt);
        // Then
        Assertions.assertFalse(resultOpt.isPresent());
    }

    // Task5-test
    @Test
    public void testGetNonEmptyStrings() {
        // Given
        List<Optional<String>> stringOpts = new ArrayList<>();
        stringOpts.add(Optional.of("hello"));
        stringOpts.add(Optional.of(""));
        stringOpts.add(Optional.empty());
        stringOpts.add(Optional.of("world"));

        // When
        List<String> nonEmptyStrings = getNonEmptyStrings(stringOpts);

        // Then
        Assertions.assertEquals(3, nonEmptyStrings.size());
        Assertions.assertTrue(nonEmptyStrings.contains("hello"));
        Assertions.assertTrue(nonEmptyStrings.contains("world"));
        Assertions.assertTrue(nonEmptyStrings.contains(""));
    }


}
