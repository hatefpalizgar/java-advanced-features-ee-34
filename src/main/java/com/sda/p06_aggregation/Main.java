package com.sda.p06_aggregation;

/*
* Aggregation is a type of association that represents a "HAS-A" relationship.
* It is a weaker form of relationship compared to composition.
* In aggregation, the lifetime of the part (e.g. Notebook) is not strictly managed
* by the whole (e.g. Backpack); The part can exist independently of the whole
* */
public class Main {
    public static void main(String[] args) {
        Notebook mathNotebook = new Notebook("Mathematics");
        Notebook scienceNotebook = new Notebook("Science");

        Backpack backpack = new Backpack(3);
        backpack.addNotebook(mathNotebook);
        backpack.addNotebook(scienceNotebook);

        // If we destroy the backpack object, still mathNotebook and scienceNotebook
        // are accessible and they are still alive!
        // so, in aggregation, classes are independent
    }
}
