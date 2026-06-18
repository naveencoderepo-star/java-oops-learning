package com.naveen.learning.AbstractClass;

// ============================================================================
// ABSTRACT CLASS - Enna da ithu? (What is this?)
// ============================================================================

// ABSTRACT CLASS nu sonna -- "INCOMPLETE class" da!
// Normal class la FULL-ah ellaam define pannuvom, but abstract class la
// sila methods ku BODY (implementation) kudukka maatom.
//
// Appo yaar kudukurathu? --> Child class (subclass) thaan kudukanum!
//
// Easiya solli sonna:
//   Abstract class = "Oru TEMPLATE / BLUEPRINT da"
//   It says: "Enna pananum nu solren, YEPPADI pananum nu nee decide pannu!"

// ============================================================================
// RULES OF ABSTRACT CLASS:
// ============================================================================
//   1. "abstract" keyword USE pannanum --> abstract class BasePage { }
//   2. Abstract class la OBJECT CREATE panna MUDIYAATHU ❌
//      --> new BasePage() --> COMPILE ERROR!
//   3. Abstract class la BOTH irukkum:
//      --> abstract methods (body illama) --> child MUST implement
//      --> normal methods (body irukku) --> child ku inherited aagum
//   4. Child class abstract method ah implement panna-la na,
//      child class um ABSTRACT aaganum!
//   5. Constructor, variables, normal methods -- ellaam vaikkalam abstract class la

// ============================================================================
// WHERE CAN WE USE ABSTRACT CLASS?
// ============================================================================
//   Same class           → YES ✅ (but object create panna mudiyaathu)
//   Subclass (extends)   → YES ✅ (ithu thaan main USE)
//   Multiple inheritance → NO  ❌ (oru class oru abstract class ah thaan extend pannum)

// ============================================================================
// WHY USE ABSTRACT CLASS? (Real-life example)
// ============================================================================
// Imagine pannu -- nee oru SCHOOL la irukka.
// Principal solli vachi irukaru: "Every teacher MUST take attendance"
// But HOW they take attendance is UP TO THEM:
//   - Math teacher --> roll call pannuvaru
//   - PT teacher --> whistle adichi line la nirkka vaipparu
//   - Computer teacher --> login system use pannuvaru
//
// Here, the RULE (take attendance) is SAME for everyone (abstract method)
// But HOW they do it is DIFFERENT (each child class implements differently)

// ============================================================================
// HOW IS THIS USED IN UI AUTOMATION? (Selenium / POM)
// ============================================================================
//
// Automation la namma Page Object Model (POM) use pannuvom.
// Every page la COMMON actions irukku:
//   - waitForPageToLoad()  --> every page load aaganum
//   - getPageTitle()       --> every page ku title irukku
//   - isPageDisplayed()    --> page display aagudha check pannanum
//
// But HOW each page loads, WHAT title it has -- ithu page-by-page DIFFERENT!
//
//   abstract class BasePage {
//       abstract void waitForPageToLoad();   ← each page implements differently
//       abstract String getPageTitle();      ← each page returns its own title
//
//       // Common method -- same for ALL pages
//       public void navigateTo(String url) {
//           driver.get(url);
//       }
//   }
//
//   class LoginPage extends BasePage { ... implements abstract methods ... }
//   class HomePage extends BasePage { ... implements abstract methods ... }
//
// BENEFIT:
// ✅ Code REUSE -- common methods oru jaagai la ezhudhi, ellaa pages ku share
// ✅ FORCE structure -- every page MUST implement waitForPageToLoad()
// ✅ CONSISTENCY -- team la yaar ezhudhinaalum SAME structure follow pannuvanga
// ============================================================================

// ============================================================================
// ABSTRACT CLASS vs NORMAL CLASS vs INTERFACE -- Quick Comparison:
// ============================================================================
//   NORMAL CLASS    → Full implementation, object create pannalam ✅
//   ABSTRACT CLASS  → Partial implementation, object create panna MUDIYAATHU ❌
//                     Both abstract + normal methods vaikkalam
//   INTERFACE       → Only method signatures (Java 8 la default methods irukku)
//                     Multiple interfaces implement pannalam
// ============================================================================

// ============================================================================
// 🔥 INTERVIEW QUESTIONS (Abstract Class) -- Tanglish la easy-ah padikkalam!
// ============================================================================
//
// Q1: What is an abstract class?
// A1: Abstract class oru INCOMPLETE class da. Object create panna mudiyaathu.
//     Abstract methods (body illama) + normal methods (body irukkum) BOTH
//     vaikkalam. Child class thaan abstract methods ah implement pannanum.
//
// Q2: Can we create an object of an abstract class?
// A2: ILLA da! ❌ new AbstractClass() --> COMPILE ERROR varum.
//     But REFERENCE variable create pannalam:
//     BasePage page = new LoginPage();  --> ithu POLYMORPHISM!
//
// Q3: Can an abstract class have a constructor?
// A3: YES da! ✅ Abstract class la constructor vaikkalam.
//     But direct-ah call panna mudiyaathu -- child class super() moolam call pannum.
//     WebDriver ah pass panna constructor use pannalam -- automation la ithu common.
//
// Q4: Can an abstract class have normal (non-abstract) methods?
// A4: YES! ✅ Ithu thaan abstract class oda POWER.
//     Common logic abstract class la ezhudhi, child class ku inherit aagum.
//     Example: navigateTo(), takeScreenshot() -- ithu ellaa page ku SAME,
//     so abstract class la ezhudhi reuse pannalam.
//
// Q5: What happens if a child class doesn't implement all abstract methods?
// A5: Appo child class um ABSTRACT aaganum! ❌
//     Illana COMPILE ERROR varum.
//
// Q6: Abstract class vs Interface -- enna difference?
// A6: Abstract class la:
//       - constructor irukku ✅
//       - instance variables irukku ✅
//       - abstract + normal methods BOTH irukku ✅
//       - single inheritance ONLY (extends one class)
//     Interface la:
//       - constructor ILLA ❌
//       - only constants (public static final)
//       - Java 8 onwards default methods irukku
//       - multiple implementation OK (implements many interfaces)
//     Automation la: BasePage = abstract class, ClickableElement = interface
//
// Q7: When to use abstract class vs interface?
// A7: Use ABSTRACT CLASS when:
//       - Common code SHARE pannanum (like navigateTo, takeScreenshot)
//       - IS-A relationship irukku (LoginPage IS-A BasePage)
//     Use INTERFACE when:
//       - Only CONTRACT define pannanum (like "this page must be searchable")
//       - Multiple behaviors combine pannanum
//
// Q8: Can abstract class have static methods?
// A8: YES! ✅ Static methods irukku, ithu class name la call pannalam directly.
//
// Q9: Can we have abstract class without abstract methods?
// A9: YES! ✅ Technically possible. But yenna use?
//     Object create panna mudiyaathu, athaan ithu use pannuvom
//     when we want to PREVENT direct instantiation.
//
// Q10: Real Selenium example la abstract class explain pannu?
// A10: BasePage abstract class la:
//        - WebDriver store pannuvom (common for all pages)
//        - waitForPageToLoad() abstract ah vaippom (each page different)
//        - navigateTo(url) normal method ah vaippom (same for all)
//        - takeScreenshot() normal method ah vaippom (same for all)
//      LoginPage extends BasePage:
//        - waitForPageToLoad() la login form visible check pannum
//      HomePage extends BasePage:
//        - waitForPageToLoad() la dashboard element visible check pannum
// ============================================================================

/**
 * BasePage - Abstract class representing a base page in our automation framework.
 *
 * Ithu oru TEMPLATE for all page classes.
 * Common functionality irukku (navigateTo, takeScreenshot).
 * But each page-specific behavior abstract methods la define panniyirukku
 * -- child classes MUST implement pannanum!
 */
public abstract class AbstractClass {

    // ----- Instance variables: common for ALL pages -----
    // Real automation la ithu WebDriver, WebDriverWait etc. ah irukkum
    protected String driverInfo;
    protected String baseUrl;
    protected String pageName;

    // ----- CONSTRUCTOR: Abstract class la constructor vaikkalam! -----
    // Child class super() call pannum
    // Real automation la: public BasePage(WebDriver driver) { this.driver = driver; }
    public AbstractClass(String driverInfo, String baseUrl) {
        this.driverInfo = driverInfo;
        this.baseUrl = baseUrl;
        System.out.println("🔧 BasePage Constructor called! Driver: " + driverInfo);
        System.out.println("   Base URL: " + baseUrl);
    }

    // =====================================================================
    // ABSTRACT METHODS - Body ILLA! Child class MUST implement pannanum!
    // =====================================================================

    /**
     * Every page load aaganum -- but HOW it loads is page-by-page DIFFERENT!
     * LoginPage la: username field visible check pannum
     * HomePage la: dashboard widget visible check pannum
     */
    public abstract void waitForPageToLoad();

    /**
     * Every page ku oru title irukku -- but ENNA title nu each page solli thaan
     * theriyum. So child class return pannum.
     */
    public abstract String getPageTitle();

    /**
     * Page display aagudha nu check pannanum -- but enna element check panrathu
     * is different for each page.
     */
    public abstract boolean isPageDisplayed();

    /**
     * Each page la DIFFERENT elements irukku -- so each page sollanun
     * what are the key elements to verify.
     */
    public abstract void verifyPageElements();

    // =====================================================================
    // NORMAL (CONCRETE) METHODS - Body IRUKKU! All child classes ku inherit aagum
    // =====================================================================

    /**
     * Navigate to a URL -- ithu EVERY page ku SAME logic.
     * So abstract class la ezhudhi reuse pannalam!
     * Real automation la: driver.get(url) use pannuvom.
     */
    public void navigateTo(String url) {
        System.out.println("🌐 Navigating to: " + url);
        System.out.println("   Using driver: " + driverInfo);
        // Real automation: driver.get(url);
    }

    /**
     * Take screenshot -- SAME logic for ALL pages.
     * Real automation la: TakesScreenshot interface use pannuvom.
     */
    public void takeScreenshot(String fileName) {
        System.out.println("📸 Screenshot taken: " + fileName + ".png");
        System.out.println("   Page: " + pageName);
        // Real automation: ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    }

    /**
     * Get current page info -- common utility method.
     */
    public void printPageInfo() {
        System.out.println("\n📄 Page Info:");
        System.out.println("   Page Name : " + pageName);
        System.out.println("   Base URL  : " + baseUrl);
        System.out.println("   Driver    : " + driverInfo);
    }

    /**
     * Refresh page -- SAME for ALL pages.
     */
    public void refreshPage() {
        System.out.println("🔄 Refreshing page: " + pageName);
        // Real automation: driver.navigate().refresh();
    }
}
