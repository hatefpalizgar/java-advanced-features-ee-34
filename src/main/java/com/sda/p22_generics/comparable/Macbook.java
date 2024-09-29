package com.sda.p22_generics.comparable;

// TODO: Google Comparable vs. Comparator interface
public class Macbook implements Comparable<Macbook> {
    private int cpuCore;

    public Macbook(int cpuCore) {
        this.cpuCore = cpuCore;
    }


    @Override
    public int compareTo(Macbook other) {
        return this.cpuCore - other.cpuCore;
        // this.cpuCore > other.cpuCore +   bigger
        // this.cpuCore = other.cpuCore 0   equal
        // this.cpuCore < other.cpuCore -   smaller
    }


}
