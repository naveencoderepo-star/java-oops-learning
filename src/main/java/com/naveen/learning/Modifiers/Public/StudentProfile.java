package com.naveen.learning.Modifiers.Public;

// WHAT IS PUBLIC?

// ----------------
// The 'public' keyword means the member (variable, method, or class)
// can be accessed from ANYWHERE — any class, any package, no restrictions.
// It is the MOST OPEN access level in Java.

// WHERE CAN PUBLIC MEMBERS BE ACCESSED?
// ----------------------------------------
//   Same class                    → YES ✅
//   Same package subclass         → YES ✅
//   Same package non-subclass     → YES ✅
//   Different package subclass    → YES ✅
//   Different package non-subclass → YES ✅

// WHY USE PUBLIC?
// --------------------------------
// 1. EXPOSE FUNCTIONALITY — let other classes use your methods and data
// 2. BUILD APIs           — public methods are the "contract" you offer
//                           to other parts of the code
// 3. ENTRY POINTS         — main() method MUST be public so the JVM
//                           can call it from outside your class

// HOW IS THIS USED IN AUTOMATION SCRIPTING (Selenium/TestNG)?
// -----------------------------------------------------------
// In Page Object Model (POM), we make ACTION METHODS public
// so that test classes can call them freely.
//
// Example in automation:
//   private WebElement loginButton;          ← locator is PRIVATE (hidden)
//   public void clickLogin() {              ← action is PUBLIC (exposed)
//       loginButton.click();
//   }
//
// In TestNG test classes:
//   public class LoginTest {                ← test class is PUBLIC
//       @Test
//       public void verifyLogin() {         ← test method is PUBLIC
//           loginPage.clickLogin();         ← calling the public action method
//       }
//   }
//
// KEY POINT: Test classes, test methods, and page action methods are ALL public
// because TestNG/JUnit needs to access them from outside your class!
// ============================================================================

public class StudentProfile {

    // ----- PUBLIC fields: ANY class from ANY package can read/write them -----
    // This means there is NO protection — anyone can change these directly!
    public String studentName;
    public int age;
    public String course;
    public String collegeName;

    // ----- PUBLIC method: accessible from everywhere -----
    // Any class can call this method — no restrictions at all
    public void displayProfile() {
        System.out.println("===== Student Profile =====");
        System.out.println("Name    : " + studentName);
        System.out.println("Age     : " + age);
        System.out.println("Course  : " + course);
        System.out.println("College : " + collegeName);
        System.out.println("===========================");
    }

    // ----- PUBLIC method: can be called from any test class -----
    // In automation, this is like a reusable action method in a Page class
    public String getWelcomeMessage() {
        return "Welcome " + studentName + "! You are enrolled in " + course + ".";
    }

    // ----- PUBLIC method: shows how public enables sharing data -----
    // Any class can call this to check eligibility — useful for test validations
    public boolean isEligibleForExam() {
        // Simple rule: age must be 18 or above
        if (age >= 18) {
            System.out.println("✅ " + studentName + " is eligible for the exam.");
            return true;
        } else {
            System.out.println("❌ " + studentName + " is NOT eligible (age below 18).");
            return false;
        }
    }

    // ----- COMPARISON: PUBLIC vs PRIVATE -----
    // Notice: ALL fields and methods here are PUBLIC
    //   → Any class can do: student.studentName = "anything"  (no control!)
    //   → Any class can do: student.age = -5                  (no validation!)
    //
    // Compare with EmployeeRecord (Private example):
    //   → Fields are PRIVATE, so you MUST use getters/setters
    //   → Setters have VALIDATION (e.g., salary can't be negative)
    //
    // LESSON: Public is convenient but RISKY — anyone can set invalid values!
    // In real automation projects, prefer PRIVATE fields + PUBLIC methods.
}
