package com.sda.p08_polymorphism_oop_principle.override_example;

public class NetflixPlayer extends VodPlayer{
    @Override
    public void play(String title) {
        System.out.println("Netflix is playing: " + title);
    }
}
