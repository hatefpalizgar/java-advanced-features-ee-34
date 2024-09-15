package com.sda.p10_static_vs_nonstatic;

/* ========================================================================================== */
//                                    Static vs Non-Static
//                  https://examples.javacodegeeks.com/static-vs-non-static-in-java/
/* ========================================================================================== */

/*
* Static:
* Static members(field/method) are called directly on the class name
*
* Non-static(instance):
* Non-static members are called on an instance of the class
* */
public class Main {
    public static void main1(String[] args) {
        NonStaticEmployee emp1 = new NonStaticEmployee(1001, "John Smith", "SDA");
        NonStaticEmployee emp2 = new NonStaticEmployee(1002, "Anna Webster", "SDA");
        emp1.display();
        emp2.display();
    }

    public static void main2(String[] args) {
        // both emp1 and emp2 share the same `company` due to it being a static field
        // this means `company` field belongs to the `StaticEmployee` class
        // NOT the emp1 or emp2 or etc. objects
        StaticEmployee emp1 = new StaticEmployee(1001, "John Smith");
        StaticEmployee emp2 = new StaticEmployee(1002, "Anna Webster");
        emp1.display();
        emp2.display();
    }

    public static void main(String[] args) {
        StaticEmployee emp1 = new StaticEmployee(1001, "John Smith");
        emp1.display();

        System.out.println(StaticEmployee.getCompany()); // getCompany static method can be called on the Class

        System.out.println(StaticEmployee.calculateSalary(1000, 0.2));
    }

    // static members are created even before the class is loaded and objects are created.
    // Therefore, we can access static members from any where in the code.
    // BUT, non-static members are created only when the class is loaded and object is created.

    // Thus, we can access non-static members ONLY from within the non-static context.
    // For example, inside calculateSalary() which is a static method, we cannot access the non-static members.
    // BUT, we can access calculateSalary() or company field from within display method (non-static context).
}
