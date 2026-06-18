package com.naveen.learning.AbstractClass;

// ============================================================================
// HomePage - SECOND CHILD CLASS that EXTENDS AbstractClass (BasePage)
// ============================================================================
// LoginPage maathiri, ithu vum abstract class extend panrathu.
// But ithu HomePage -- so implementation DIFFERENT aah irukkum!
//
// Ithu thaan ABSTRACT CLASS oda POWER:
//   SAME abstract methods, but DIFFERENT implementations!
//   waitForPageToLoad() --> LoginPage la login form check pannum
//   waitForPageToLoad() --> HomePage la dashboard elements check pannum
//
// Real automation la: After login success, HomePage ku navigate aaguvom.
// Dashboard widgets, user profile, navigation menu -- ithu laam check pannanum.
// ============================================================================

public class HomePage extends AbstractClass {

    // ----- HomePage-specific fields -----
    private String welcomeBannerLocator;
    private String navigationMenuLocator;
    private String userProfileLocator;
    private String logoutButtonLocator;
    private String loggedInUser;

    // ----- CONSTRUCTOR -----
    public HomePage(String driverInfo, String baseUrl) {
        super(driverInfo, baseUrl);  // Parent constructor call ✅
        this.pageName = "Home Page";
        this.welcomeBannerLocator = "#welcomeBanner";
        this.navigationMenuLocator = "#navMenu";
        this.userProfileLocator = "#userProfile";
        this.logoutButtonLocator = "#logoutBtn";
        this.loggedInUser = "";
        System.out.println("🏠 HomePage initialized with locators!");
    }

    // =====================================================================
    // ABSTRACT METHOD IMPLEMENTATIONS -- HomePage-SPECIFIC!
    // =====================================================================

    /**
     * waitForPageToLoad() -- HomePage ku DIFFERENT implementation!
     * Dashboard elements visible aagura varai wait pannanum.
     * LoginPage la login form check pannom, INGAE dashboard check panrom!
     */
    @Override
    public void waitForPageToLoad() {
        System.out.println("⏳ HomePage: Waiting for dashboard to load...");
        System.out.println("   Checking element: " + welcomeBannerLocator);
        System.out.println("   Checking element: " + navigationMenuLocator);
        System.out.println("   Checking element: " + userProfileLocator);
        System.out.println("✅ HomePage: Dashboard is fully loaded!");
    }

    /**
     * getPageTitle() -- HomePage oda title return pannum.
     * LoginPage la "MyApp - Login" return pannom,
     * INGAE "MyApp - Dashboard" return panrom -- DIFFERENT implementation!
     */
    @Override
    public String getPageTitle() {
        String title = "MyApp - Dashboard";
        System.out.println("📌 HomePage title: " + title);
        return title;
    }

    /**
     * isPageDisplayed() -- Welcome banner visible irundha HomePage display aagirukku.
     */
    @Override
    public boolean isPageDisplayed() {
        System.out.println("👀 Checking if Home Page is displayed...");
        System.out.println("   Looking for welcome banner: " + welcomeBannerLocator);
        System.out.println("✅ Home Page is displayed!");
        return true;
    }

    /**
     * verifyPageElements() -- HomePage la enna elements irukku verify pannum.
     * LoginPage la 3 elements check pannom, INGAE 4 elements check panrom!
     */
    @Override
    public void verifyPageElements() {
        System.out.println("🔍 Verifying Home Page elements:");
        System.out.println("   ✅ Welcome banner found: " + welcomeBannerLocator);
        System.out.println("   ✅ Navigation menu found: " + navigationMenuLocator);
        System.out.println("   ✅ User profile found: " + userProfileLocator);
        System.out.println("   ✅ Logout button found: " + logoutButtonLocator);
        System.out.println("   All home page elements verified!");
    }

    // =====================================================================
    // HomePage-SPECIFIC METHODS
    // =====================================================================

    /**
     * Get welcome message from banner.
     */
    public String getWelcomeMessage() {
        String message = "Welcome back, " + loggedInUser + "!";
        System.out.println("👋 " + message);
        return message;
    }

    /**
     * Click on navigation menu item.
     */
    public void clickMenuItem(String menuItem) {
        System.out.println("📋 Clicking menu item: " + menuItem);
        System.out.println("   In navigation: " + navigationMenuLocator);
    }

    /**
     * Click logout button.
     */
    public void clickLogout() {
        System.out.println("🚪 Clicking Logout button: " + logoutButtonLocator);
        System.out.println("✅ User logged out successfully!");
    }

    /**
     * Set the currently logged in user.
     */
    public void setLoggedInUser(String username) {
        this.loggedInUser = username;
    }

    /**
     * Verify user is on dashboard after login.
     */
    public void verifyDashboardAfterLogin(String expectedUser) {
        System.out.println("\n🏠 === Verifying Dashboard After Login ===");
        waitForPageToLoad();
        verifyPageElements();
        setLoggedInUser(expectedUser);
        getWelcomeMessage();
        System.out.println("🏠 === Dashboard Verification Complete ===\n");
    }
}
