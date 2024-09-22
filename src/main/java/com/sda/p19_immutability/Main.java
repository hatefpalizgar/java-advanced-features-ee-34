package com.sda.p19_immutability;

// mutate: to change
// mutable: possible to be changed/modified
// immutable: something that can never be changed

import java.util.ArrayList;
import java.util.List;

/**
 * <h4>Immutability</h4>
 *
 * <p>For a class to be considered immutable, it must meet the following criteria:
 *
 * <ul>
 *   <li><b>Final Class:</b> The class itself must be declared as {@code final} to prevent
 *       subclassing.
 *   <li><b>Final Fields:</b> All fields of the class must be declared as {@code final} to ensure
 *       they are assigned only once.
 *   <li><b>Private Fields:</b> All fields should be private to prevent direct access.
 *   <li><b>No Setter (Mutator) Methods:</b> Provide no methods that modify the object's state after
 *       construction.
 *   <li><b>Immutable Field Types:</b> Prefer immutable field types. For mutable fields (like
 *       arraylist, or mutable class), ensure deep copying during assignment and when returning
 *       them.
 * </ul>
 */
public class Main {
    public static void main(String[] args) {
        List<String> travelHistory = new ArrayList<>();
        travelHistory.add("USA");
        travelHistory.add("Canada");

        Nationality nationality = new Nationality("United States", "US");

        // nationality can be mutated
        // nationality.setCountry("Japan");

        Passport passport = new Passport("John Doe", nationality, "1231123", "US", travelHistory);

        // attempting to modify/mutate the travel history or other fields will not affect the passport object,
        // thanks to immutablity
        travelHistory.add("Mexico");
        System.out.println(passport.getTravelHistory()); // [USA, Canada]

        Nationality fakeNationality = passport.getNationality();
        fakeNationality.setCountry("Japan"); // attempt to change/mutate nationality
        System.out.println(passport.getNationality()); // Nationality [country= United States, countryCode= US]
    }
}
