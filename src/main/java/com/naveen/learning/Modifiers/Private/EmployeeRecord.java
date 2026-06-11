package com.naveen.learning.Modifiers.Private;

// WHAT IS PRIVATE?

// ----------------
// The 'private' keyword restricts access to ONLY the same class.
// No other class — not even in the same package — can directly access
// a private member (variable or method).

// WHERE CAN PRIVATE MEMBERS BE ACCESSED?
// ----------------------------------------
//   Same class           → YES ✅
//   Same package subclass    → NO  ❌
//   Same package non-subclass → NO  ❌
//   Different package subclass → NO  ❌
//   Different package non-subclass → NO  ❌

// WHY USE PRIVATE? (Encapsulation)
// --------------------------------
// 1. PROTECT DATA   — prevent other classes from setting invalid values
// 2. HIDE INTERNALS — expose only what's needed (like a TV remote: you
//                     press buttons, you don't touch the circuit board)
// 3. CONTROL ACCESS — use getters/setters to add validation logic

// HOW IS THIS USED IN AUTOMATION SCRIPTING (Selenium/TestNG)?
// -----------------------------------------------------------
// In Page Object Model (POM), we make WebElement locators PRIVATE
// so that test classes can't directly access or modify locators.
// Instead, test classes call PUBLIC methods that perform actions.
//
// Example in automation:
//   private WebElement loginButton;        ← locator is hidden
//   public void clickLogin() { ... }       ← action is exposed
//
// This way, if the locator changes, we fix it in ONE place (the page class),
// and all tests still work without any changes!
// ============================================================================

public class EmployeeRecord {

    // ----- PRIVATE fields: only THIS class can read/write them -----
    private String employeeId;
    private String employeeName;
    private double salary;

    // ----- PUBLIC CONSTRUCTOR: allows creating objects from outside -----
    // We control how the object gets initialized
    public EmployeeRecord(String employeeId, String employeeName, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;

        // VALIDATION: salary cannot be negative — this is WHY we use private!
        if (salary < 0) {
            System.out.println("⚠ Warning: Salary cannot be negative. Setting to 0.");
            this.salary = 0;
        } else {
            this.salary = salary;
        }
    }

    // ----- GETTER methods: controlled READ access -----
    // Other classes can READ the value, but they CANNOT change it directly
    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public double getSalary() {
        return salary;
    }

    // ----- SETTER method with VALIDATION -----
    // Other classes can update salary, but ONLY through this method
    // which checks the value before accepting it
    public void setSalary(double newSalary) {
        if (newSalary < 0) {
            System.out.println("⚠ Error: Cannot set negative salary!");
        } else {
            this.salary = newSalary;
            System.out.println("✅ Salary updated to: " + this.salary);
        }
    }

    // ----- PRIVATE helper method: only used internally -----
    // This method is for internal use only — no other class needs to know
    // how we format the display. This is "hiding implementation details".
    private String formatDisplay() {
        return "ID: " + employeeId + " | Name: " + employeeName + " | Salary: ₹" + salary;
    }

    // ----- PUBLIC method that uses the private helper -----
    public void displayRecord() {
        // We call the private method HERE, inside the same class — this is allowed!
        System.out.println(formatDisplay());
    }
}
