package com.sda.p08_polymorphism_oop_principle.override_example;

// Since NetflixPlayer & HBOPlayer & DefaultPlayer, all are
// subclasses of VodPlayer, then based on polymorphism
// they are also a VodPlayer.
// Hence, we can replace the right side with any of the VodPlayer
// implementations.

// Every child is ALSO a parent, but not every parent is a child.
// We can store objects of a child type in a variable of a parent type.
// We can store objects of type NetflixPlayer in a variable of type VodPlayer.
public class Main {
    public static void main(String[] args) {
        String player = args[0]; // Netflix

        VodPlayer vodPlayer = null;

        if (player.equals("Netflix")) {
            vodPlayer = new NetflixPlayer();
        } else if (player.equals("HBO")) {
            vodPlayer = new HBOPlayer();
        } else {
            vodPlayer = new DefaultPlayer();
        }

        // The exact type of vodPlayer would be defined
        // at run-time
        vodPlayer.play("Alice in Wonderland");

        // Polymorphism:
        // vodPlayer variable can take any shape based on run-time values
        // It can be a NetflixPlayer, or an HBOPlayer or even a DefaultPlayer


    }

    /*
     * I recommend you reading my article on Medium website:
     * https://medium.com/swlh/why-and-when-to-use-polymorphism-ffcbf3709509
     **/
}
