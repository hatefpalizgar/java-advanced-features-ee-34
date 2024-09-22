package com.sda.p18_collections.maps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {

        System.out.println("============ TreeMap with default Comparator (ascending order) ===============");
        Map<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(2, 200);
        treeMap.put(4, 400);
        treeMap.put(1, 100);
        treeMap.put(3, 300);

        System.out.println(treeMap); // {1=100, 2=200, 3=300, 4=400}

        // Null keys are not allowed in TreeMap
        // treeMap.put(null, 500); // throws NullPointerException

        System.out.println("============ TreeMap with built-in Comparator ===============");

        treeMap = new TreeMap<>(Comparator.reverseOrder());
        treeMap.put(2, 200);
        treeMap.put(4, 400);
        treeMap.put(1, 100);
        treeMap.put(3, 300);

        System.out.println(treeMap);  // {4=400, 3=300, 2=200, 1=100}


        System.out.println("============ TreeMap with custom Comparator ===============");
        Map<String, Integer> basket = new HashMap<>();
        basket.put("banana", 134);
        basket.put("apple", 789);
        basket.put("cherry", 499);

        System.out.println(basket); // unsorted hashmap

        // now, let's say we want to sort this map based on the values
        // I need to create my own Comparator object
        ValueComparator myComparator = new ValueComparator(basket);
        Map<String, Integer> sortedBasket = new TreeMap<>(myComparator);

        sortedBasket.putAll(basket); // copy all entries in basket to sortedBasket
        System.out.println(sortedBasket);


    }
}

// A comparator that compares the values of any map
class ValueComparator implements Comparator<String> {

    Map<String, Integer> map;

    public ValueComparator(Map<String, Integer> map) {
        this.map = map;
    }


    @Override
    public int compare(String key1, String key2) {
        Integer value1 = map.get(key1);
        Integer value2 = map.get(key2);

        return value1 - value2;
        // if compare method returns:
        // 0: it means value1 and value2 are equal
        // positive: it means value1 > value2
        // negative: it means value1 < value2
        
    }
}
