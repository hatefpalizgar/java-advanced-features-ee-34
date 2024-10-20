package com.sda.p27_streams.no3;

import java.util.Arrays;
import java.util.List;

public class FlatMapExample1 {
    public static void main(String[] args) {
        // Example 1. converting a nested list into a list
        var list1 = List.of(1,2,3);
        var list2 = List.of(4,5,6);
        var list3 = List.of(7,8,9);

        List<List<Integer>> uberList = List.of(list1, list2, list3);  // List<List<Integer>>

        List<Integer> result = uberList.stream() // Stream<List<Integer>>
                .flatMap(list -> list.stream()) // Stream<Integer>
                .toList();
        System.out.println(result);

        // Example 2. converting nested arrays into a list
        String[][] dataArray = new String[][] { {"a", "b"}, {"c", "d"}, {"e", "f"}, {"g", "h"}  };
        List<String> result2 = Arrays.stream(dataArray)
                .flatMap(a -> Arrays.stream(a))
                .toList();
        System.out.println(result2);
    }
}

/**
 *
 * @see com.sda.p27_streams.no3.FlatMapExample2
 * */
