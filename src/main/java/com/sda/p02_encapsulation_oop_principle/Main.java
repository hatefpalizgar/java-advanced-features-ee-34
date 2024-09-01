package com.sda.p02_encapsulation_oop_principle;

// Encapsulation is the process of wrapping up the data(variables) and code acting on
// the data (methods) in a single unit

// Encapsulation is achieved by
// 1. making fields private
// 2. providing getter method for READ access
// 3. providing setter method for WRITE access
// Even though we might give both READ&WRITE access,
// but now we have more control (like validation etc.) thanks to our
// getters & setters.
public class Main {
    public static void main(String[] args) {
        // Let's instantiate a Pocket object
        Pocket aPocket = new Pocket(4000);
        System.out.println(aPocket.getMoney()); // 4000

        aPocket.setMoney(0);
        System.out.println(aPocket.getMoney()); // 4000
    }
}
