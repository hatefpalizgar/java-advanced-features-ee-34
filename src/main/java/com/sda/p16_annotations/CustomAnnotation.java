package com.sda.p16_annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.Month;

@Target(ElementType.METHOD) // specifies where the annotation can be applied
@Retention(RetentionPolicy.RUNTIME) // specifies how long to retain an annotation
public @interface CustomAnnotation {

    // Although written like a method, but it's not.
    // It's rather called an 'Element' of the annotation
    // 'Element' defined this way becomes the arguments of the annotation
    // There are certain limitations around 'Element':
    // 1. return type of 'Element' must be:
    //  -   simple types (e.g. int, float, double) and their object-oriented counterparts (e.g. Integer, Double)
    //  -   String class
    //  -   Enum class
    //  -   other annotation classes
    //  -   arrays of the types as mentioned above

    // 2. 'Element' cannot take any arguments (i.e. look like method declarations with no arguments)
    String[] value();

    // You can define 'default' values for every 'Element' that you don't want to specify
    String[] dates() default {};

    Month month() default Month.JUNE;
}
