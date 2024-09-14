package com.sda.p07_abstraction_oop_principle.p09_interfaces;

// In Java, `multiple inheritance` (extends) is NOT ALLOWED - you can only have ONE parent
// The only exception for `multiple inheritance` is `Object` class. This is the parent of all classes in Java
// In Java, we can implement multiple interfaces
public class Girl extends Human implements Loveable, Playable{
    private String name;

    public Girl(String skinColor, String name) {
        super(skinColor);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void love() {
        System.out.println("showing love to a girl");
    }

    @Override
    public void play() {
        System.out.println("girl is playing");
    }
}
