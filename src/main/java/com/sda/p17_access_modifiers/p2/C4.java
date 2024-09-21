package com.sda.p17_access_modifiers.p2;

import com.sda.p17_access_modifiers.p1.C1;

public class C4 extends C1 {

    public void aMethod() {

        C1 c1 = new C1();

        // can access c1.publicField
        System.out.println(c1.publicField);

        // cannot access c1.protectedField (different package)
        //  System.out.println(c1.protectedField);

        // cannot access c1.defaultField (different package)
        // System.out.println(c1.defaultField);

        // cannot access c1.privateField
        // System.out.println(c1.privateField);
    }

}
