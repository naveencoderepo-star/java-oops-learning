package com.naveen.learning.SubclassDemo;

import com.naveen.learning.Modifiers.Protected.ProtectedStudent;

/**
 * Subclass in a different package demonstrating protected member access.
 */
public class ProtectedStudentChild extends ProtectedStudent {

    private String additionalInfo;

    public ProtectedStudentChild(String studentName, int age, String course, String additionalInfo) {
        super(studentName, age, course);
        this.additionalInfo = additionalInfo;
    }

    // Can access protected method from superclass
    @Override
    protected void displayProtectedInfo() {
        System.out.println("[ProtectedChild] Student: " + studentName + ", Age: " + age + ", Course: " + course + ", Extra: " + additionalInfo);
    }

    public void showFullProfile() {
        // Calls the overridden protected method
        displayProtectedInfo();
    }
}
