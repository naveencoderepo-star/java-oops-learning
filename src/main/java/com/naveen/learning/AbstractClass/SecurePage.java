package com.naveen.learning.AbstractClass;

// ============================================================================
// PARTIAL IMPLEMENTATION - What if child class ALL abstract methods implement pannala?
// ============================================================================
//
// RULE: If a child class doesn't implement ALL abstract methods from parent,
//       then child class also ABSTRACT aaganum!
//
// Ithu oru REAL scenario da:
//   BasePage la 4 abstract methods irukku.
//   But sila pages ku COMMON behavior irukku -- like all "secure pages"
//   (pages that need login) have SAME isPageDisplayed() logic.
//
//   So we create a MIDDLE abstract class:
//     AbstractClass (BasePage) --> SecurePage (abstract) --> actual pages
//
//   SecurePage SOME abstract methods implement pannum,
//   but still SOME methods abstract-ah vuddum -- so SecurePage um abstract thaan!
//
// This is called a "LAYERED ABSTRACTION" pattern.
// Automation la: BasePage -> SecurePage -> LoginPage, HomePage
// ============================================================================

/**
 * SecurePage -- An abstract class that extends another abstract class!
 * Partial implementation matum panirukku.
 * Remaining abstract methods ah final child class implement pannanum.
 *
 * ❌ Object create panna MUDIYAATHU (ithu vum abstract thaan!)
 * ✅ But some common behavior define pannirukkum for all secure pages.
 */
public abstract class SecurePage extends AbstractClass {

    protected boolean isAuthenticated;
    protected String sessionToken;

    // Constructor -- calls parent (AbstractClass) constructor via super()
    public SecurePage(String driverInfo, String baseUrl) {
        super(driverInfo, baseUrl);
        this.isAuthenticated = false;
        this.sessionToken = "";
        System.out.println("🔐 SecurePage layer initialized!");
    }

    // =====================================================================
    // IMPLEMENTING *SOME* abstract methods -- partial implementation!
    // =====================================================================

    /**
     * isPageDisplayed() -- ALL secure pages have SAME check:
     * "Is user authenticated?" If not, page is NOT displayed!
     *
     * Since we implemented this HERE, child classes DON'T need to implement again.
     * But they CAN @Override if they want custom behavior.
     */
    @Override
    public boolean isPageDisplayed() {
        System.out.println("🔐 SecurePage: Checking authentication...");
        if (isAuthenticated) {
            System.out.println("   ✅ User is authenticated. Page can be displayed.");
            return true;
        } else {
            System.out.println("   ❌ User is NOT authenticated! Redirecting to login...");
            return false;
        }
    }

    // =====================================================================
    // waitForPageToLoad() --> NOT implementing! Still ABSTRACT!
    // getPageTitle()      --> NOT implementing! Still ABSTRACT!
    // verifyPageElements()--> NOT implementing! Still ABSTRACT!
    //
    // Because these are still abstract, SecurePage MUST be abstract too!
    // Final child classes (like AdminPage below) will implement them.
    // =====================================================================

    // =====================================================================
    // SecurePage-SPECIFIC METHODS
    // =====================================================================

    /**
     * Simulate authentication.
     */
    public void authenticate(String token) {
        this.sessionToken = token;
        this.isAuthenticated = true;
        System.out.println("🔑 Authenticated with token: " + token);
    }

    /**
     * Check session validity.
     */
    public boolean isSessionValid() {
        boolean valid = isAuthenticated && !sessionToken.isEmpty();
        System.out.println("🔐 Session valid: " + (valid ? "YES ✅" : "NO ❌"));
        return valid;
    }
}
