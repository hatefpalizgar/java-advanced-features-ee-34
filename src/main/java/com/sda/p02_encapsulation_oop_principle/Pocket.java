package com.sda.p02_encapsulation_oop_principle;

// Ever class in Java has 2 sections:
// 1. properties/fields/attributes
// 2. methods/functions/behaviours (you can talk to your objects using their methods)
public class Pocket {

    // ============= FIELDS ==============
    private double money;

    public Pocket(double money) {
        this.money = money; // 'this' keyword references any instances of Pocket class
    }


    // ============= METHODS ==============

    // getter method (READ access)
    // You now have control over what to return
    public double getMoney() {
        return this.money;
    }

    // setter method (WRITE access)
    // You have control over what to update
    public void setMoney(double newAmount) {
        if (newAmount <= 0) {
            return;
        }
        this.money = newAmount;
    }

}
