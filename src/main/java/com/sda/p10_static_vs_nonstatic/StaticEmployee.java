package com.sda.p10_static_vs_nonstatic;

public class StaticEmployee {
    private int id;
    private String name;
    private static String company = "SDA"; // static field belongs to the class not the objects

    {
        // non-static context
    }

    static {
        // static context
    }

    public StaticEmployee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static double calculateSalary(double basic, double taxRate) {
       // System.out.println(this.id); // `this` cannot be referenced from a static context
       // System.out.println(name);
        return basic * (1 - taxRate);
    }

    public void display() {
        // You can access static members from within non-static context
        // Hence, company is accessible here
        System.out.println("StaticEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}');
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // this method is a static method
    // so it should be invoked on the Class NOT the object
    public static String getCompany() {
        return company;
    }
}
