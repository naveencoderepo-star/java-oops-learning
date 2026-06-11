package com.naveen.learning.Modifiers.Protected;

/**
 * Demonstrates the use of the 'protected' access modifier.
 * Protected members are accessible within the same package and also
 * in subclasses even if they are in a different package.
 */
public class ProtectedStudent {

    // ----- PROTECTED fields: visible to same package and subclasses -----
    protected String studentName;
    protected int age;
    protected String course;

    // ----- PROTECTED method: can be overridden by subclasses -----
    protected void displayProtectedInfo() {
        System.out.println("[Protected] Student: " + studentName + ", Age: " + age + ", Course: " + course);
    }

    // ----- PUBLIC constructor: allows creating objects from anywhere -----
    public ProtectedStudent(String studentName, int age, String course) {
        this.studentName = studentName;
        this.age = age;
        this.course = course;
    }

    // ----- PUBLIC method: uses protected members internally -----
    public void showProfile() {
        // Can call protected method directly because we are in the same class
        displayProtectedInfo();
    }
}
