package com.naveen.learning.Modifiers;

/**
 * ============================================================
 *  JAVA MODIFIERS — MASTER DEMO RUNNER
 * ============================================================
 *
 *  This class runs ALL modifier demos in sequence.
 *
 *  JAVA MODIFIERS CHEAT SHEET:
 *  ━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  ACCESS MODIFIERS (who can see it?):
 *    • public      → visible everywhere
 *    • protected   → visible in same package + subclasses
 *    • default     → visible in same package only (no keyword)
 *    • private     → visible only within the class
 *
 *  NON-ACCESS MODIFIERS (how does it behave?):
 *    • static       → belongs to the class, not any object
 *    • final        → cannot be changed/overridden/extended
 *    • abstract     → incomplete; subclass must implement
 *    • synchronized → thread-safe; one thread at a time
 *    • volatile     → always read from main memory (thread visibility)
 *    • transient    → skip during serialization
 *
 *  Run this main method to see all demos!
 */
public class ApplicationForm {

    public static void main(String[] args) {

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃   JAVA MODIFIERS — COMPLETE LEARNING GUIDE            ┃");
        System.out.println("┃   by Naveen                                            ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println();

        // ── 1. ACCESS MODIFIERS ──────────────────
        AccessModifiersDemo accessDemo = new AccessModifiersDemo("Naveen", "ACC-2024-001", "1234");
        accessDemo.runDemo();

        System.out.println("━".repeat(55));
        System.out.println();

        // ── 2. PROTECTED — SUBCLASS ACCESS ───────
        SavingsAccount savingsDemo = new SavingsAccount("Priya", "SAV-2024-002", "5678", 6.5);
        savingsDemo.showInheritedAccess();

        System.out.println("━".repeat(55));
        System.out.println();

        // ── 3. STATIC MODIFIER ───────────────────
        StaticModifierDemo staticDemo = new StaticModifierDemo("DemoStudent");
        staticDemo.runDemo();

        System.out.println("━".repeat(55));
        System.out.println();

        // ── 4. FINAL MODIFIER ────────────────────
        FinalModifierDemo finalDemo = new FinalModifierDemo("Naveen", 25, "1234-5678-9012");
        finalDemo.runDemo();

        System.out.println("━".repeat(55));
        System.out.println();

        // ── 5. ABSTRACT MODIFIER ─────────────────
        AbstractModifierDemo abstractDemo = new AbstractModifierDemo();
        abstractDemo.runDemo();

        System.out.println("━".repeat(55));
        System.out.println();

        // ── 6. SYNCHRONIZED & VOLATILE ───────────
        SynchronizedVolatileDemo syncDemo = new SynchronizedVolatileDemo();
        syncDemo.runDemo();

        System.out.println("━".repeat(55));
        System.out.println();

        // ── 7. TRANSIENT MODIFIER ────────────────
        TransientModifierDemo transientDemo = new TransientModifierDemo(
                "naveen", "naveen@email.com", 25, "secret@123");
        transientDemo.runDemo();

        System.out.println("━".repeat(55));
        System.out.println();

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃   ✅ ALL MODIFIER DEMOS COMPLETED!                     ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }
}
