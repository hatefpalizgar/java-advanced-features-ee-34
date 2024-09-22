package com.sda.p18_collections.maps.exercise;

import com.sda.p15_final_and_constants.FinalMain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise {
    public static void main(String[] args) {
        Person p1 = new Person("Hatef", "Palizgar", 35);
        Person p2 = new Person("Adam", "Smith", 25);

        Friend f1 = new Friend("John", "Doe", 22);
        Friend f2 = new Friend("Mary", "Abraham", 40);

        Map<Person, Friend> map = new HashMap<>();

        map.put(p1, f1);
        map.put(p2, f2);

        // add duplicate is NOT POSSIBLE
        map.put(p1, f2);

        for (Map.Entry<Person, Friend> entry: map.entrySet()) {
            System.out.println("person: " + entry.getKey().getFirstname() + " --> friend: " + entry.getValue().getFirstname());
        }


        // TODO: create a map called 'partyPeople'
        // keys of the map should be of type Person
        // values of the map should be of type List<Friend>
        // using your own for-each loop print out on each line
        // the name of the person and together with the names of the friends attending his/her party
        // Example:
        // Adam -> John Doe 22 , Mary Abraham 40
        Map<Person, List<Friend>> partyPeople = new HashMap<>();


    }
}
