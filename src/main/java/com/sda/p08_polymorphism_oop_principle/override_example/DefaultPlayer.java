package com.sda.p08_polymorphism_oop_principle.override_example;

public class DefaultPlayer extends VodPlayer{
    @Override
    public void play(String title) {
        System.out.println("Default Player is playing: " + title);
    }
}
