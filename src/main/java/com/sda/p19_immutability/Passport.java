package com.sda.p19_immutability;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

// An immutable class
public final class Passport {
    private final String name;
    private final Nationality nationality; // mutable field (since class is mutable)
    private final String passportNumber;
    private final String issueCountry;
    private final List<String> travelHistory; // list of countries visited


    public Passport(String name, Nationality nationality, String passportNumber, String issueCountry, List<String> travelHistory) {
        this.name = name;
        this.nationality = new Nationality(nationality.getCountry(), nationality.getCountryCode()); // Defensive copy
        // Defensive copy is necessary since the nationality argument passed to the constructor can still be mutated
        // somewhere else in our program, so without copying, it will cause this.nationality field to change too,
        // which means our passport object will still be mutable.
        this.passportNumber = passportNumber;
        this.issueCountry = issueCountry;
        this.travelHistory = List.copyOf(new ArrayList<>(travelHistory)); // Defensive copy
    }

    // Only getter methods available, no setter(mutator) methods
    public String getName() {
        return name;
    }

    public Nationality getNationality() {
        // return a defensive copy to prevent mutation from outside
//        return nationality;
        return new Nationality(nationality.getCountry(), nationality.getCountryCode());
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getIssueCountry() {
        return issueCountry;
    }

    public List<String> getTravelHistory() {
//        return travelHistory;
        return List.copyOf(new ArrayList<>(travelHistory));
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Passport.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("nationality=" + nationality)
                .add("passportNumber='" + passportNumber + "'")
                .add("issueCountry='" + issueCountry + "'")
                .add("travelHistory=" + travelHistory)
                .toString();
    }
}
