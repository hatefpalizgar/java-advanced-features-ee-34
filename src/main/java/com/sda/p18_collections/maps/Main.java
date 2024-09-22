package com.sda.p18_collections.maps;

/* ========================================================================= */
//                                   Map
/* ========================================================================= */
// Map is a collection of key-value pairs.
// Keys are unique but values can be duplicated.
// Each key is linked to a specific value.
// Once stored in a Map, you can later look up the value using just the key.
// Map is not a subtype of Collection interface therefore it behaves a bit different from the rest of
// Collection types.

// HashMap does not guarantee any order of the elements stored internally in the map.
// TreeMap guarantees that the elements are stored in sorted order.

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /* ========================================================================= */
        //                              Creating a Map
        /* ========================================================================= */
        Map<String, String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value3");
        map.put("key1", "value4"); // this will replace the value of key1 with value4

        // Only Java objects are allowed as keys and values.

        // You can use 'null' as a key or value or even both in a map
        map.put(null, "value6");
        map.put("key", null);

        System.out.println(map); // {key1=value4, null=value6, key2=value2, key3=value3, key4=value3, key=null}

        /* ========================================================================= */
        //                              Accessing a Map
        /* ========================================================================= */
        // - get(key)
        String result = map.get("key1"); // value4
        System.out.println(result + " is the value mapped to key1");

        // - getOrDefault(key, defaultValue)
        String value = map.getOrDefault("key8", "defaultValue");
        System.out.println("Value = " + value);

        // let's print out all the keys of map
        System.out.println("========= print keys ===========");
        for (String k : map.keySet()) {
            System.out.println(k);
        }

        // let's print out all the values of map
        System.out.println("========= print values ===========");
        for (String v : map.values()) {
            System.out.println(v);
        }

        // let's print out all the entries of map
        System.out.println("========= print entries ===========");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // You can use containsKey() method to check if a key is present in a map
        boolean containsKey = map.containsKey("key1");  // true

        // You can use containsValue() method to check if a value is present in a map
        boolean containsValue = map.containsValue("value1");  // false

        /* ========================================================================= */
        //                           Removing in a Map
        /* ========================================================================= */
        String removedValue = map.remove("key1");
        System.out.println("removed value: " + removedValue); // value4

        // You can use clear() to delete all entries of the map
        // map.clear();

        map.replace("key8", "value1"); // no "key8", no replace
        // map.put("key8", "value1"); // no "key8", new entry will be added (NOT GOOD)


        /* ========================================================================= */
        //                           Interview Questions
        /* ========================================================================= */
        // 1. What is the difference between a HashMap and a TreeMap?
        // 2. How the put() method of HashMap works in Java? (Hashing)
        // Answer:
        // https://www.java67.com/2013/06/how-get-method-of-hashmap-or-hashtable-works-internally.html
        // The put() method of HashMap works in the principle of hashing.
        // It is responsible for storing an object into the backend array.
        // The hashcode() method is used in conjunction with a hash function to find the correct
        // location for the object into the bucket.
        // If a collision occurs, then the entry object which contains both key and value is added to a
        // linked list,
        // and that linked list is stored into the bucket location.

        // At least you should know that:
        // i) Two unequal objects may return the same hashcode.
        // ii) When two objects are equal by equals(), they must have the same hashcode.

        // 3. How the get() method of HashMap works in Java?
        // 4. What is the requirement for an object to be used as a key or value in HashMap?
        // Answer:
        // The key or value object must implement the equals() and hashcode() method.
        // The hash code is used when you insert the key object into the map,
        // while equals are used when you try to retrieve a value from the map.

        // 5.Can you store a null key in Java HashMap?
        // Answer:
        // Yes, HashMap allows one null key, which is stored at the first location of bucket array e.g.,
        // bucket[0] = value.
        // The HashMap doesn't call hashCode() on the null key because it will throw
        // NullPointerException,
        // hence when a user call the get() method with null, then the value of the first index is
        // returned.

        // 6. Can you store a null value in Java HashMap? Yes. You can put as many null values as you
        // want.

        // 7. Which data structure is used to implement HashMap in Java? HashTable. Array is used for
        // bucket and linked list is used for collision.

        // 8. Can you store a duplicate key in HashMap? No.

        // 9. Is HashMap thread-safe in Java? No. HashMap is not thread-safe. For thread-safety, you
        // need to use ConcurrentHashMap.

        // 10. Are entries in HashMap ordered? No.
    }
}
