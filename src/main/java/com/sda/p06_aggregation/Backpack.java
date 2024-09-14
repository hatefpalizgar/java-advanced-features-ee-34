package com.sda.p06_aggregation;

public class Backpack {
    private Notebook[] notebooks; // any backpack HAS-A bunch of notebooks
    private int count;

    public Backpack(int capacity) {
        notebooks = new Notebook[capacity];
        count = 0;
    }

    public void addNotebook(Notebook notebook) {
        if (count < notebooks.length) {
            notebooks[count] = notebook;
            count++;
        } else {
            System.out.println("ERROR: Backpack is full, cannot add more notebooks");
        }
    }

    public Notebook[] getNotebooks() {
        return notebooks;
    }
}
