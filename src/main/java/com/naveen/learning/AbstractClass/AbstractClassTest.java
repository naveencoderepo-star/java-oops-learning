package com.naveen.learning.AbstractClass;

// ============================================================================
// ABSTRACT CLASS - COMPLETE DEMO & TEST
// ============================================================================
// Ithu la ellaa concepts ah demo pannuvom:
//
//   1. ❌ Abstract class la object create panna mudiyaathu -- proof!
//   2. ✅ Child class la object create pannalam
//   3. ✅ Abstract methods -- each child DIFFERENT-ah implement panirukku
//   4. ✅ Normal methods -- parent la irundhu INHERIT aagum (navigateTo, takeScreenshot)
//   5. ✅ Constructor chaining -- child -> parent constructor call aagum
//   6. ✅ POLYMORPHISM -- BasePage reference la child object store pannalam!
//   7. ✅ Real automation flow -- Login -> Home -> Product page navigation
// ============================================================================

public class AbstractClassTest {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║    ABSTRACT CLASS & ABSTRACT METHODS - DEMO     ║");
        System.out.println("║    UI Automation Perspective (Selenium / POM)    ║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");

        // =================================================================
        // DEMO 1: Abstract class la object CREATE PANNA MUDIYAATHU! ❌
        // =================================================================
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("DEMO 1: Abstract class la object create panna mudiyaathu!");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        // ❌ THE FOLLOWING LINE WOULD CAUSE COMPILE ERROR IF UNCOMMENTED:
        // AbstractClass basePage = new AbstractClass("chrome", "http://example.com");
        //                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        //                          ERROR: Cannot instantiate the type AbstractClass
        //
        // WHY? Because abstract class la abstract methods irukku.
        // Avanga ku body illa -- so incomplete class ah instantiate panna Java allow pannathu!

        System.out.println("❌ new AbstractClass() --> COMPILE ERROR!");
        System.out.println("   Reason: Abstract class is INCOMPLETE -- abstract methods ku body illa!");
        System.out.println("   Solution: Child class extend pannu, abstract methods implement pannu,");
        System.out.println("             aprom CHILD class object create pannu! ✅\n");

        // =================================================================
        // DEMO 2: Child class objects create pannalam ✅
        // =================================================================
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("DEMO 2: Child class objects create pannalam!");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");

        // Constructor chaining: LoginPage constructor -> super() -> AbstractClass constructor
        LoginPage loginPage = new LoginPage("ChromeDriver v120", "https://myapp.com");
        System.out.println(); // spacing

        HomePage homePage = new HomePage("ChromeDriver v120", "https://myapp.com");
        System.out.println(); // spacing

        ProductPage productPage = new ProductPage("ChromeDriver v120", "https://myapp.com");
        System.out.println();

        // =================================================================
        // DEMO 3: Abstract methods -- DIFFERENT implementations!
        // =================================================================
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("DEMO 3: SAME abstract method, DIFFERENT implementations!");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");

        System.out.println("--- waitForPageToLoad() - Each page waits DIFFERENTLY ---\n");
        loginPage.waitForPageToLoad();
        System.out.println();
        homePage.waitForPageToLoad();
        System.out.println();
        productPage.waitForPageToLoad();
        System.out.println();

        System.out.println("--- getPageTitle() - Each page returns DIFFERENT title ---\n");
        loginPage.getPageTitle();
        homePage.getPageTitle();
        productPage.setProductDetails("Selenium Book", 599.99);
        productPage.getPageTitle();
        System.out.println();

        // =================================================================
        // DEMO 4: Normal (inherited) methods -- SAME for all pages!
        // =================================================================
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("DEMO 4: Normal methods -- INHERITED from parent, SAME for all!");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");

        // navigateTo() is defined in AbstractClass (parent)
        // All child classes INHERIT it -- no need to write again! CODE REUSE!
        loginPage.navigateTo("https://myapp.com/login");
        homePage.navigateTo("https://myapp.com/dashboard");
        productPage.navigateTo("https://myapp.com/products/123");
        System.out.println();

        // takeScreenshot() is also INHERITED from parent
        loginPage.takeScreenshot("login_page_screenshot");
        homePage.takeScreenshot("home_page_screenshot");
        productPage.takeScreenshot("product_page_screenshot");
        System.out.println();

        // printPageInfo() -- common utility, INHERITED
        loginPage.printPageInfo();
        homePage.printPageInfo();
        productPage.printPageInfo();
        System.out.println();

        // =================================================================
        // DEMO 5: POLYMORPHISM -- Parent reference, Child object!
        // =================================================================
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("DEMO 5: POLYMORPHISM -- Abstract class reference with child object!");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");

        // AbstractClass reference la child object store pannalam!
        // ithu POLYMORPHISM -- "Many Forms"
        // Runtime la Java decide pannum: "Indha object actually LoginPage-a, HomePage-a?"

        AbstractClass page1 = new LoginPage("ChromeDriver", "https://myapp.com");
        System.out.println();
        AbstractClass page2 = new HomePage("ChromeDriver", "https://myapp.com");
        System.out.println();
        AbstractClass page3 = new ProductPage("ChromeDriver", "https://myapp.com");
        System.out.println();

        // SAME method call, DIFFERENT behavior -- ithu RUNTIME POLYMORPHISM!
        System.out.println("--- Calling getPageTitle() on SAME reference type ---\n");
        page1.getPageTitle();  // LoginPage version execute aagum
        page2.getPageTitle();  // HomePage version execute aagum
        page3.getPageTitle();  // ProductPage version execute aagum
        System.out.println();

        // ✅ Array of AbstractClass -- mix and match child objects!
        // Real automation la: List<BasePage> allPages = new ArrayList<>();
        System.out.println("--- Using Array of AbstractClass (Polymorphism in Action!) ---\n");
        AbstractClass[] allPages = {page1, page2, page3};

        for (AbstractClass page : allPages) {
            page.isPageDisplayed();  // Each page oda OWN implementation run aagum!
        }
        System.out.println();

        // =================================================================
        // DEMO 6: Real Automation Flow -- Login -> Home -> Product
        // =================================================================
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("DEMO 6: Real Automation Flow using Abstract Class Pattern!");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");

        // Step 1: Login
        System.out.println("STEP 1: LOGIN");
        System.out.println("─────────────");
        loginPage.navigateTo("https://myapp.com/login");
        loginPage.performLogin("naveen", "password123");

        // Step 2: Verify Home Page
        System.out.println("STEP 2: VERIFY HOME PAGE");
        System.out.println("────────────────────────");
        homePage.navigateTo("https://myapp.com/dashboard");
        homePage.verifyDashboardAfterLogin("naveen");

        // Step 3: Go to Product Page
        System.out.println("STEP 3: VERIFY PRODUCT PAGE");
        System.out.println("───────────────────────────");
        productPage.navigateTo("https://myapp.com/products/selenium-book");
        productPage.verifyProductPage("Selenium WebDriver Book", 1299.99);
        productPage.clickAddToCart();

        // Step 4: Take screenshots
        System.out.println("\nSTEP 4: TAKE SCREENSHOTS (Inherited method!)");
        System.out.println("─────────────────────────────────────────────");
        loginPage.takeScreenshot("after_login");
        homePage.takeScreenshot("dashboard_verified");
        productPage.takeScreenshot("product_added_to_cart");

        // =================================================================
        // SUMMARY
        // =================================================================
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║              📝 SUMMARY / LESSON                ║");
        System.out.println("╠══════════════════════════════════════════════════╣");
        System.out.println("║                                                  ║");
        System.out.println("║  1. Abstract class = INCOMPLETE template         ║");
        System.out.println("║     Object create panna MUDIYAATHU ❌            ║");
        System.out.println("║                                                  ║");
        System.out.println("║  2. Abstract methods = Body ILLA                 ║");
        System.out.println("║     Child class MUST implement pannanum ✅       ║");
        System.out.println("║                                                  ║");
        System.out.println("║  3. Normal methods = Body IRUKKU                 ║");
        System.out.println("║     Child classes ku INHERIT aagum ✅            ║");
        System.out.println("║                                                  ║");
        System.out.println("║  4. Constructor = Abstract class la irukkum      ║");
        System.out.println("║     Child super() moolam call pannum ✅          ║");
        System.out.println("║                                                  ║");
        System.out.println("║  5. Polymorphism = Parent ref + Child object     ║");
        System.out.println("║     Runtime la correct method execute aagum ✅   ║");
        System.out.println("║                                                  ║");
        System.out.println("║  6. UI Automation la:                            ║");
        System.out.println("║     BasePage = Abstract class                    ║");
        System.out.println("║     LoginPage, HomePage = Concrete children      ║");
        System.out.println("║     Common actions = Inherited (navigateTo)      ║");
        System.out.println("║     Page-specific = Abstract (waitForPageLoad)   ║");
        System.out.println("║                                                  ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
    }
}
