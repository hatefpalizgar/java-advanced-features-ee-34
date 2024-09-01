package com.sda.p03_inheritance_oop_principle;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("Michael", 10, "Dark brown");
        person.play(); // I am playing
        person.eat(); // I am eating

        Dad dad = new Dad("John", 35, "Blonde");
        dad.play(); // Dad is playing golf
        dad.eat(); // Dad is eating steak

        Kid kid = new Kid("Rob", 14, "Black", "House of Fire");
        kid.play(); //  Dad is playing golf
        kid.eat(); // Dad is eating steak
        kid.dance(); // Kid is dancing


        // If Child/Subclass is extending Parent/Superclass then we can say:
        // EVERY SUBCLASS IS ALSO OF TYPE PARENTCLASS
        // EVERY SUBCLASS IS ALSO A PARENTCLASS
        // but below is not correct:
        // superclass is a subclass (x)

        // In our example:
        // every kid IS-A dad
        // every dad IS-A person

        // Inheritance relationship is of type IS-A
    }
}
