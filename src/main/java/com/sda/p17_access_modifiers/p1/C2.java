package com.sda.p17_access_modifiers.p1;

public class C2 {
    public void aMethod() {

        C1 c1 = new C1();

        // can access c1.publicField
        System.out.println(c1.publicField);

        // can access c1.protectedField (same package)
        System.out.println(c1.protectedField);

        // can access c1.defaultField (same package)
        System.out.println(c1.defaultField);

        // cannot access c1.privateField
        // System.out.println(c1.privateField);

        c1.publicMethod();
        c1.protectedMethod();
        c1.defaultMethod();
        // c1.privateMethod();
    }
}
