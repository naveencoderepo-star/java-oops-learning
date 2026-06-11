package com.naveen.learning.Modifiers.Public;

// ============================================================================
// TEST CLASS - Demonstrates what PUBLIC modifier allows
// ============================================================================
// This class is in the SAME PACKAGE as StudentProfile.
// Since everything in StudentProfile is PUBLIC, we can access ALL of it!
//
// Even if this class was in a DIFFERENT package, it would STILL work
// because PUBLIC = accessible from EVERYWHERE.
// ============================================================================

public class StudentProfileTest {

    public static void main(String[] args) {

        System.out.println("=== PUBLIC MODIFIER DEMO ===\n");

        // --- Creating an object ---
        StudentProfile student1 = new StudentProfile();

        // ✅ Directly setting PUBLIC fields — this is allowed because they are public!
        // No getter/setter needed — we write directly to the fields
        student1.studentName = "Naveen";
        student1.age = 22;
        student1.course = "Automation Testing";
        student1.collegeName = "Tech Academy";

        // ✅ Calling PUBLIC method — accessible from here (same package)
        student1.displayProfile();

        // ✅ Calling another PUBLIC method
        System.out.println(student1.getWelcomeMessage());

        // ✅ Calling PUBLIC method that returns a value — useful for assertions in testing
        System.out.println("\n--- Exam Eligibility Check ---");
        student1.isEligibleForExam();   // age is 22, so eligible ✅

        System.out.println("\n--- Creating a second student (underage) ---");
        StudentProfile student2 = new StudentProfile();
        student2.studentName = "Kumar";
        student2.age = 16;
        student2.course = "Java Basics";
        student2.collegeName = "Code School";

        student2.displayProfile();
        student2.isEligibleForExam();   // age is 16, so NOT eligible ❌

        // ⚠ THE RISK OF PUBLIC FIELDS — No validation, anyone can set bad data!
        System.out.println("\n--- Showing the RISK of public fields ---");
        student2.age = -5;             // ⚠ This is ALLOWED but makes no sense!
        student2.studentName = "";     // ⚠ Empty name — no one stops us!
        System.out.println("Age set to    : " + student2.age + "  (invalid! but public allows it)");
        System.out.println("Name set to   : '" + student2.studentName + "'  (empty! but public allows it)");

        // COMPARE WITH PRIVATE:
        // In EmployeeRecord (Private example), doing emp.salary = -500 would
        // cause a COMPILE ERROR because salary is private.
        // Here, student2.age = -5 works because age is public — no protection!

        System.out.println("\n=== LESSON ===");
        System.out.println("Public = Accessible from EVERYWHERE (same class, same package, different package).");
        System.out.println("No restrictions = convenient but RISKY (no validation on direct access).");
        System.out.println("In Automation = Test classes, test methods, and page action methods are PUBLIC.");
        System.out.println("Best Practice = Keep fields PRIVATE, keep action methods PUBLIC.");
    }
}
