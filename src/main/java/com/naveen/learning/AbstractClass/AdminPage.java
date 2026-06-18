package com.naveen.learning.AbstractClass;

// ============================================================================
// AdminPage - EXTENDS SecurePage (which EXTENDS AbstractClass)
// ============================================================================
// Ithu MULTILEVEL INHERITANCE with abstract classes!
//
//   AbstractClass (BasePage)  -->  abstract, 4 abstract methods
//        ↓ extends
//   SecurePage                -->  abstract, implements 1, still has 3 abstract
//        ↓ extends
//   AdminPage                 -->  CONCRETE! Implements remaining 3 abstract methods
//
// AdminPage MUST implement:
//   ✅ waitForPageToLoad()  -- from AbstractClass (not done by SecurePage)
//   ✅ getPageTitle()       -- from AbstractClass (not done by SecurePage)
//   ✅ verifyPageElements() -- from AbstractClass (not done by SecurePage)
//
// AdminPage INHERITS:
//   ✅ isPageDisplayed()    -- from SecurePage (already implemented!)
//   ✅ navigateTo()         -- from AbstractClass (normal method)
//   ✅ takeScreenshot()     -- from AbstractClass (normal method)
//   ✅ authenticate()       -- from SecurePage
// ============================================================================

public class AdminPage extends SecurePage {

    private String adminPanelLocator;
    private String userManagementLocator;
    private String systemSettingsLocator;

    public AdminPage(String driverInfo, String baseUrl) {
        super(driverInfo, baseUrl);  // Calls SecurePage -> AbstractClass constructors
        this.pageName = "Admin Page";
        this.adminPanelLocator = "#adminPanel";
        this.userManagementLocator = "#userMgmt";
        this.systemSettingsLocator = "#sysSettings";
        System.out.println("👨‍💼 AdminPage initialized!");
    }

    // =====================================================================
    // Implementing the REMAINING abstract methods (3 left from AbstractClass)
    // isPageDisplayed() is ALREADY implemented by SecurePage!
    // =====================================================================

    @Override
    public void waitForPageToLoad() {
        System.out.println("⏳ AdminPage: Waiting for admin panel to load...");
        System.out.println("   Checking element: " + adminPanelLocator);
        System.out.println("✅ AdminPage: Admin panel loaded!");
    }

    @Override
    public String getPageTitle() {
        String title = "MyApp - Admin Panel";
        System.out.println("📌 AdminPage title: " + title);
        return title;
    }

    @Override
    public void verifyPageElements() {
        System.out.println("🔍 Verifying Admin Page elements:");
        System.out.println("   ✅ Admin panel: " + adminPanelLocator);
        System.out.println("   ✅ User management: " + userManagementLocator);
        System.out.println("   ✅ System settings: " + systemSettingsLocator);
    }

    // AdminPage-specific methods
    public void manageUsers() {
        System.out.println("👥 Opening User Management: " + userManagementLocator);
    }

    public void openSettings() {
        System.out.println("⚙ Opening System Settings: " + systemSettingsLocator);
    }
}
