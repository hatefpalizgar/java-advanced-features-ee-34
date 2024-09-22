package com.sda.p19_immutability;

// This class in NOT immutable:
// 1. There are setter(mutator) methods
// 2. class itself is not final, so it can be extended
public class Nationality {
    private String country;
    private String countryCode;

    public Nationality(String country, String countryCode) {
        this.country = country;
        this.countryCode = countryCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
//        return "Nationality [" +
//                "country='" + country + '\'' +
//                ", countryCode='" + countryCode + '\'' +
//                ']';
        return String.format("Nationality [country= %s, countryCode= %s]", country, countryCode);
    }
}
