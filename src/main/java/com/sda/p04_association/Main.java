package com.sda.p04_association;

/*
* Association:
* A type of relationship between two or more classes in Java.
* When two objects have "uses-a" or "knows-a" relationship
*
* Represents the relationship between objects that can exist independently.
* Example below:
* If we destroy the student object, the teacher object still lives and exists.
*
* Association can be a one-way, two-way(bidirectional), one-to-one, one-to-many,
* many-to-one, or many-to-many relationship
*
* Example: A Teacher and Student relationship
* Every student can have only one teacher (one-to-one)
* */
public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mr. Smith");
        Student student = new Student("Alice", teacher);
    }
}
