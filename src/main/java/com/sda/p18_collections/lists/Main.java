package com.sda.p18_collections.lists;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /* ============================================================================================== */
        //                                       List Interface
        /* ============================================================================================== */
        // Java List interface is a member of the Java Collections Framework.
        // List allows you to add duplicate elements
        // List allows you to have ‘null’ elements
        // List is an ordered collection of items (items are stored in the same order as they were added)

        String[] text = new String[10];

        // Declaring a list of String objects
        // ArrayList<String> list = new ArrayList<>();

        // Correct due to polymorphism
        List<String> list = new ArrayList<>();

        // How to add elements to a list
        list.add("A");
        list.add("B");

        // How to remove elements from a list
        list.remove("A"); // remove using the object itself
//        list.remove(0); // remove using the index

        // How to get size of a list
        System.out.println(list.size());  // 1

        // Check if a list is empty or not
        System.out.println(list.isEmpty());  // false

        // Check if a list contains a specific element or not
        System.out.println(list.contains("B"));  // true

        // Remove all elements from a list
        list.clear();

        // Add multiple elements to a list
        list.addAll(List.of("A", "B", "C", "D", "A"));

        // Get an element from a list
        System.out.println(list.get(1)); // "B"

        // How to replace an element in a list by index
        list.set(0, "A");

        // How to find the index of the first occurrence of an element in a list
        System.out.println(list.indexOf("A")); // 0

        // How to find the index of the last occurrence of an element in a list
        System.out.println(list.lastIndexOf("A")); // 4


        /* ============================================================================================== */
        //                               Converting Java Array to List using Arrays class
        /* ============================================================================================== */

        // We can use Arrays class to get the view of array as list.
        // However, we won’t be able to do any structural modification to the list, it will throw
        // java.lang.UnsupportedOperationException.

        String[] vowels = {"a", "e", "i", "o", "u"};

        List<String> vowelsList = Arrays.asList(vowels);
        System.out.println(vowelsList);

        // vowelsList.remove(0); // throws UnsupportedOperationException

        // So the best way is to use for loop for creating list by iterating over the array
        // using for-loop to copy elements from array to list is safe for modification of list in the future
        List<String> myList = new ArrayList<>();
        for (String s : vowels) {
            myList.add(s);
        }
        myList.remove(0);
        System.out.println(myList);

        /* ============================================================================================== */
        //                            Converting Java List to array using toArray()
        /* ============================================================================================== */
        List<String> letters = new ArrayList<>();
        letters.add("A");
        letters.add("B");
        letters.add("C");

        String[] lettersArray = new String[letters.size()];
        lettersArray = letters.toArray(lettersArray);
        System.out.println(Arrays.toString(lettersArray)); // [A, B, C]

        /* ============================================================================================== */
        //                            List sort using sort()
        /* ============================================================================================== */
        List<Integer> integerList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            integerList.add(random.nextInt(1000));
        }

        System.out.println(integerList);

        // natural sorting using Collections class
        Collections.sort(integerList);
        System.out.println(integerList);

        /* ============================================================================================== */
        //                            List Iterator using iterator()
        /* ============================================================================================== */
        List<Integer> integerList2 = new ArrayList<>();
        // traditional iteration
        for (int i = 0; i < 5; i++) {
            integerList2.add(i);
        }

        // Iterator is a class that can be used to iterate over a collection
        // Iterator has:
        // - next() method: returns the next element in the collection
        // - hasNext() method: which returns true if there are more elements to be iterated over
        // - remove() method: which removes the current element from the collection
        Iterator<Integer> iterator = integerList2.iterator();

        // 1. simple iteration (prefer enhanced for-loop)
        while (iterator.hasNext()) { // while my list has a next item remaining
            Integer element = iterator.next();
            System.out.print(element + ", ");
        }

        System.out.println("\n" + "after simple iteration: \n" + integerList2);

        // at this point, the iterator is at the end of the list
        // I can't use the same iterator anymore, I need to refresh it

        // 2. modification of list using iterator
        iterator = integerList2.iterator(); // refreshes the iterator
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element % 2 == 0) iterator.remove();
        }
        System.out.println("\n" + "after modified iteration: \n" + integerList2);


        // TODO: There is another iterator class called ListIterator
        // Discover what extra functionality it provides and play with it


        /* ============================================================================================== */
        //                                       ArrayList
        /* ============================================================================================== */
        // ArrayList is a class that implements List interface.
        // ArrayList in Java is used to store dynamically sized collection of elements.
        // Contrary to Arrays that are fixed in size, an ArrayList grows its size automatically when new
        // elements are added to it.
        // ArrayList internally uses an array to store the elements. Just like arrays, It allows you to
        // retrieve the elements by their index.
        // ArrayList allows duplicate and null values.
        // ArrayList is an ordered collection. It maintains the insertion order of the elements.
        // ArrayList is not synchronized, therefore it's not thread-safe.


        /* ============================================================================================== */
        //                                       LinkedList
        /* ============================================================================================== */
        // LinkedList is a linear data structure where the elements are not stored in contiguous locations
        // and every element is a separate object with a data part and address part.
        // The elements are linked using pointers or addresses.
        // Each element is known as a node.



    }
}
