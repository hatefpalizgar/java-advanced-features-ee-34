package com.sda.p16_annotations;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.time.Month;

public class Student {
    private String firstName;
    private String lastName;
    private int age;

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


    // annotation is a metadata
    // it has no impact on the existing logic
    // it is only useful for being processed by others
    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Deprecated
    @CustomAnnotation(value = {"first value", "second value"})
    public void methodWithAnnotation() {
        // ...
    }


    // now, let's see how we can process the @CustomAnnotation
    public void processCustomAnnotation() {
        // We are using Reflection API to get the method with @CustomAnnotation
        // Reflection API is like reverse engineering; it's a powerful tool that allows us to get informationAbout the
        // class, methods, fields, etc. programmatically.
        // It's a bit more advanced tool and needs a separate lecture to understand it BUT
        // you rarely need to use it in your projects yourself, and it would be a bit risky to use it in your
        // projects

        // Using reflection API, I want to find the methods in this class that are annotated with @CustomAnnotation and
        // print to the console the first and second values inside the element 'value' array
        Method[] methods = this.getClass().getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(CustomAnnotation.class)) {
                CustomAnnotation annotation = method.getAnnotation(CustomAnnotation.class);
                System.out.println(annotation.value()[0]);
                System.out.println(annotation.value()[1]);
            }
        }
    }

    // TODO: print out to console the name of the method or methods annotated with @Deprecated
    public void processDeprecatedAnnotation() {

    }

}
