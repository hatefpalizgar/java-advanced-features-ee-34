package com.sda.p03_inheritance_oop_principle.example01;

public class Kid extends Dad {
    // Kid class can have its own fields
    // on top of what Dad and Person have
    private String favouriteMusic;

    public Kid(String name, int age, String color, String favouriteMusic) {
        super(name, age, color);
        this.favouriteMusic = favouriteMusic;
    }

    // Below is not working:
    // call to constructor should be always the first line in the child's constructor(s)
    // Root cause: 'this' keyword refers to subclass object. This object can not be created
    // unless the superclass is created. So, simply 'this' doesn't mean anything to compiler
    // before call to super class constructor
    // REMEMBER: Java needs to give birth to the parent before giving birth to the child
//    public Kid(String name, int age, String color, String favouriteMusic) {
//        this.favouriteMusic = favouriteMusic;
//        super(name, age, color);
//    }

    // Kid class can have its own behaviours/methods
    // on top what Dad and Person have
    public void dance() {
        System.out.println("Kid is dancing");
    }

    // Since neither Dad nor Person have the field favouriteMusic,
    // we have to define getter&setter for it
    // getter: accessor
    // setter: mutator
    public String getFavouriteMusic() {
        return favouriteMusic;
    }

    public void setFavouriteMusic(String favouriteMusic) {
        this.favouriteMusic = favouriteMusic;
    }

    // TODO: override play and eat method of the Dad class here
}
