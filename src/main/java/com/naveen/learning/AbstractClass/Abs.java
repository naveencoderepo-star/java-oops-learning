package com.naveen.learning.AbstractClass;

// "abstract" keyword use pannirukkom -- so ithu oru INCOMPLETE class
// Object create panna MUDIYAATHU ❌
// Yaen? Because abstract method ku body illa -- Java ku theriyaathu enna execute panrathu nu
public abstract class Abs {

    // =====================================================================
    // ABSTRACT METHOD -- Body ILLA (no curly braces, no implementation)
    // =====================================================================
    // Ithu oru CONTRACT / PROMISE maathiri:
    //   "Yen child class ah extend pannuravanga, nee MUST ithai implement pannu!"
    // Body illa athaan semicolon (;) la mudiyuthu -- curly braces {} illa
    //
    // ❌ new Abs() pannumbothu --> abs.test1() call panna --> ENNA execute aagum?
    //    Body-ye illa! Athaan Java block pannidum object creation ah!
    public abstract void test1();

    // =====================================================================
    // CONCRETE METHOD -- Body IRUKKU (fully implemented)
    // =====================================================================
    // Ithu NORMAL method -- abstract class la irukkalam
    // Abstract class la abstract + normal methods BOTH vaikkalam
    // Child class inherit pannum -- rewrite panna vendaam (but @Override pannalam if needed)
    public void test2() {
        System.out.println("test2 is implemented");
    }

    // =====================================================================
    // main() METHOD -- Abstract class la main() vaikkalam! ✅
    // =====================================================================
    // main() is a STATIC method -- ithu class-ku belong panrathu, object-ku illa
    // Athaan abstract class la irundhaalum main() vaikkalam -- static ku object thevai illa
    //
    // BUT! main() INSIDE irundhalum, abstract class object create panna MUDIYAATHU!
    public static void main(String[] args) {

        // ❌ COMPILE ERROR! Abstract class la object create panna MUDIYAATHU!
        // Error: "Abs is abstract; cannot be instantiated"
        //
        // WHY? test1() ku body illa -- abs.test1() call pannumbothu
        // Java ku theriyaathu enna run panrathu nu!
        //
        // Abs abs = new Abs();   // ❌ UNCOMMENT PANNATHEY -- COMPILE ERROR VARUM!

        // ❌ ithu vum work aagaathu -- object create aagala na method call panna mudiyaathu
        // abs.test2();  // ❌ abs object illa
        // abs.test1();  // ❌ abs object illa, plus body-ye illa

        // =====================================================================
        // ✅ CORRECT WAY 1: Anonymous Inner Class (shortcut child class)
        // =====================================================================
        // new Abs() { } --> ithu oru UNNAMED child class create panrathu
        // Abstract method ku body kudukurom INLINE-ah
        Abs abs1 = new Abs() {
            @Override
            public void test1() {
                System.out.println("test1 implemented via Anonymous Inner Class!");
            }
        };
        abs1.test2();  // ✅ Works -- concrete method inherited from Abs
        abs1.test1();  // ✅ Works -- implemented just above

        System.out.println("---");

        // =====================================================================
        // ✅ CORRECT WAY 2: Use a proper child class (AbsChild.java create pannu)
        // =====================================================================
        // Abs abs2 = new AbsChild();  // ✅ child class object, parent reference
        // abs2.test1();               // ✅ AbsChild la implementation irukku
        // abs2.test2();               // ✅ inherited from Abs

    }
}
