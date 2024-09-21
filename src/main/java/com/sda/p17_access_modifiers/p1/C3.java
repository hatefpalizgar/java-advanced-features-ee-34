package com.sda.p17_access_modifiers.p1;

public class C3 extends C1 {
    public void aMethod() {

        C1 c1 = new C1();

        // can access c1.publicField
        System.out.println(c1.publicField);

        // can access c1.protectedField (subclass & same package)
        System.out.println(c1.protectedField);

        // can access c1.defaultField (same package)
        System.out.println(c1.defaultField);

        // cannot access c1.privateField
        // System.out.println(c1.privateField);
    }
}
