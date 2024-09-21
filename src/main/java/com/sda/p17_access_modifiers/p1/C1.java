package com.sda.p17_access_modifiers.p1;

public class C1 {

    // accessible from any other class
    public int publicField;

    // accessible only by the class itself and (its subclasses and classes) in the same package
    protected int protectedField;


    // accessible only by any class in the same package
    int defaultField;


    // accessible only by the class itself
    private int privateField;


    public void publicMethod(){}

    protected void protectedMethod(){}

    void defaultMethod(){}

    private void privateMethod(){}
}
