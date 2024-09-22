package com.sda.p18_collections.sets;

import java.util.*;

/*
 * ==============================================================================================
 *                                      Set Interface
 * ==============================================================================================
 * Java Set interface is a member of the Java Collections Framework.
 * A set does not allow duplicate elements.
 * Order of elements is not guaranteed.
 */
public class Main {
    public static void main(String[] args) {
        Set<String> routes = new HashSet<>();
        routes.add("Berlin");
        routes.add("Tallinn");
        routes.add("Paris");
        routes.add("London");
        routes.add("Paris");
        routes.add("Tallinn");
        routes.remove("London");

        System.out.println(routes); // [Berlin, Tallinn, Paris]

        /* ============================================================================================== */
        //                              Union, Intersection, Difference
        /* ============================================================================================== */
        // Union: returns a new set containing all elements from both sets
        Set<Integer> a = new HashSet<>();
        a.addAll(Arrays.asList(1,3,2,4,8,9,0));

        Set<Integer> b = new HashSet<>();
        b.addAll(Arrays.asList(1,3,5,7,4,0,5));

        // To find the union of two sets, we can use the following method:
        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);
        System.out.println("Union of two sets: " + union);

        // Intersection: returns a new set containing all elements that are common to both sets
        Set<Integer> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        System.out.println("Intersection of two sets: " + intersection);

        // Difference: returns a new set containing all elements that are in the first set but not in
        // the second set
        Set<Integer> difference = new HashSet<>(a);
        difference.removeAll(b);
        System.out.println("Difference of a - b: " + difference);

        /* ============================================================================================== */
        //                                 HashSet, EnumSet, LinkedHashSet, TreeSet
        /* ============================================================================================== */
        // 1. HashSet: does not guarantee order of elements. It is a good choice for storing elements that
        // are not ordered.

        // 2. EnumSet: is a set of elements of a specific enum type. High-performance and faster than
        // HashSet.
        Set<Day> enumSet = EnumSet.of(Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY);

        // 3. LinkedHashSet: is a set that maintains the order of elements in which they were inserted.
        // When iterating through a HashSet, the order is unpredictable, while a LinkedHashSet lets us
        // iterate through the elements in the order in which they were inserted.
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("India");
        linkedHashSet.add("Australia");
        linkedHashSet.add("Estonia");
        // add a duplicate element
        linkedHashSet.add("India");

        System.out.println(linkedHashSet); // [India, Australia, Estonia]


        // 4. TreeSet: it behaves like a simple set with the exception that it stores element in a
        // sorted format.
        // It is a good choice for storing elements that are ordered and sorted.
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("India");
        treeSet.add("Australia");
        treeSet.add("Estonia");
        System.out.println(treeSet); // [Australia, Estonia, India]

        Iterator<String> iterator = treeSet.iterator();
        while(iterator.hasNext()) {
            treeSet.add("Spain"); // throws ConcurrentModificationException
            System.out.println(iterator.next());
        }

        // TODO: how to resolve ConcurrentModificationException?
    }

    // To learn more: https://www.geeksforgeeks.org/set-in-java/?ref=lbp
}

enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}
