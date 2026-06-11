package com.naveen.learning.Modifiers.Private;

// ============================================================================
// TEST CLASS - Demonstrates what PRIVATE does (and doesn't) allow
// ============================================================================
// This class is in the SAME PACKAGE as EmployeeRecord.
// Even so, it CANNOT access private members directly!
// ============================================================================

public class EmployeeTest {

    public static void main(String[] args) {

        System.out.println("=== PRIVATE MODIFIER DEMO ===\n");

        // --- Creating an object using the public constructor ---
        EmployeeRecord emp = new EmployeeRecord("EMP001", "Naveen", 50000);

        // ❌ THE FOLLOWING LINES WOULD CAUSE COMPILE ERRORS IF UNCOMMENTED:
        // Because employeeId, employeeName, salary are PRIVATE in EmployeeRecord
        //
        // emp.employeeId = "EMP999";     // ❌ ERROR: employeeId has private access
        // emp.employeeName = "Hacker";   // ❌ ERROR: employeeName has private access
        // emp.salary = -100;             // ❌ ERROR: salary has private access
        // emp.formatDisplay();           // ❌ ERROR: formatDisplay() has private access
        //
        // 👆 This is the POWER of private — it BLOCKS direct access from outside!

        // ✅ Instead, we use PUBLIC getters (controlled read access)
        System.out.println("Employee ID   : " + emp.getEmployeeId());
        System.out.println("Employee Name : " + emp.getEmployeeName());
        System.out.println("Salary        : ₹" + emp.getSalary());

        System.out.println("\n--- Trying to set invalid salary ---");
        // ✅ The setter has VALIDATION — it rejects negative values
        emp.setSalary(-500);    // This will print a warning, salary stays unchanged

        System.out.println("\n--- Setting a valid salary ---");
        emp.setSalary(75000);   // This will succeed

        System.out.println("\n--- Display using public method (which internally calls private method) ---");
        emp.displayRecord();    // This calls formatDisplay() internally — we don't need to know HOW it formats!

        System.out.println("\n--- Testing constructor validation ---");
        // Even the constructor validates! Try creating with negative salary:
        EmployeeRecord emp2 = new EmployeeRecord("EMP002", "Kumar", -1000);
        emp2.displayRecord();   // Salary will be 0, not -1000

        System.out.println("\n=== LESSON ===");
        System.out.println("Private = Only accessible within the SAME class.");
        System.out.println("Use getters/setters = Controlled access with validation.");
        System.out.println("In Automation (POM) = Keep locators PRIVATE, expose actions as PUBLIC methods.");
    }
}
