package com.sda.p08_polymorphism_oop_principle.override_example;

public class HBOPlayer extends VodPlayer{
    @Override
    public void play(String title) {
        System.out.println("HBO is playing: " + title);
    }
}
