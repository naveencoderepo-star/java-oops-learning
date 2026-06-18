package com.naveen.learning.AbstractClass;

// ============================================================================
// LoginPage - CHILD CLASS that EXTENDS AbstractClass (BasePage)
// ============================================================================
// Ithu oru CONCRETE class -- ellaa abstract methods ah implement pannirukku.
// Login page specific behavior ithu la irukku.
//
// Real automation la ithu LoginPage.java -- login form oda actions irukku:
//   - enterUsername(), enterPassword(), clickLoginButton()
//   - waitForPageToLoad() la login form visible check pannum
// ============================================================================

public class LoginPage extends AbstractClass {

    // ----- LoginPage-specific fields -----
    // Real automation la: @FindBy(id = "username") WebElement usernameField;
    private String usernameLocator;
    private String passwordLocator;
    private String loginButtonLocator;
    private boolean isLoggedIn;

    // ----- CONSTRUCTOR: super() call panrathu MUST! -----
    // Abstract class oda constructor ah child class MUST call pannanum.
    // Real automation la: public LoginPage(WebDriver driver) { super(driver); }
    public LoginPage(String driverInfo, String baseUrl) {
        // 👆 FIRST line la super() call pannanum -- parent constructor execute aagum
        super(driverInfo, baseUrl);
        this.pageName = "Login Page";
        this.usernameLocator = "#username";
        this.passwordLocator = "#password";
        this.loginButtonLocator = "#loginBtn";
        this.isLoggedIn = false;
        System.out.println("🔑 LoginPage initialized with locators!");
    }

    // =====================================================================
    // ABSTRACT METHOD IMPLEMENTATIONS -- Parent la body illa, INGAE kudukurom!
    // =====================================================================

    /**
     * waitForPageToLoad() -- Login page ku SPECIFIC implementation.
     * Login form visible aagura varai wait pannanum.
     * Real automation la: WebDriverWait + ExpectedConditions use pannuvom.
     */
    @Override
    public void waitForPageToLoad() {
        System.out.println("⏳ LoginPage: Waiting for login form to be visible...");
        System.out.println("   Checking element: " + usernameLocator);
        System.out.println("   Checking element: " + passwordLocator);
        System.out.println("   Checking element: " + loginButtonLocator);
        System.out.println("✅ LoginPage: Login form is loaded and visible!");
        // Real automation:
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username")));
    }

    /**
     * getPageTitle() -- Login page oda title return pannum.
     * Real automation la: return driver.getTitle();
     */
    @Override
    public String getPageTitle() {
        String title = "MyApp - Login";
        System.out.println("📌 LoginPage title: " + title);
        return title;
    }

    /**
     * isPageDisplayed() -- Login page display aagudha check pannum.
     * Login button visible irundha page display aagirukku.
     */
    @Override
    public boolean isPageDisplayed() {
        System.out.println("👀 Checking if Login Page is displayed...");
        System.out.println("   Looking for login button: " + loginButtonLocator);
        System.out.println("✅ Login Page is displayed!");
        return true;
        // Real automation: return loginButton.isDisplayed();
    }

    /**
     * verifyPageElements() -- Login page la enna elements irukku verify pannum.
     */
    @Override
    public void verifyPageElements() {
        System.out.println("🔍 Verifying Login Page elements:");
        System.out.println("   ✅ Username field found: " + usernameLocator);
        System.out.println("   ✅ Password field found: " + passwordLocator);
        System.out.println("   ✅ Login button found: " + loginButtonLocator);
        System.out.println("   All login page elements verified!");
    }

    // =====================================================================
    // LoginPage-SPECIFIC METHODS (ithu parent class la ILLA, only LoginPage ku)
    // =====================================================================

    /**
     * Enter username -- LoginPage-specific action.
     */
    public void enterUsername(String username) {
        System.out.println("⌨ Entering username: " + username);
        System.out.println("  Into field: " + usernameLocator);
        // Real automation: usernameField.sendKeys(username);
    }

    /**
     * Enter password -- LoginPage-specific action.
     */
    public void enterPassword(String password) {
        System.out.println("🔒 Entering password: " + "*".repeat(password.length()));
        System.out.println("  Into field: " + passwordLocator);
        // Real automation: passwordField.sendKeys(password);
    }

    /**
     * Click login button -- LoginPage-specific action.
     */
    public void clickLoginButton() {
        System.out.println("🖱 Clicking Login button: " + loginButtonLocator);
        this.isLoggedIn = true;
        System.out.println("✅ Login button clicked! User logged in successfully.");
        // Real automation: loginButton.click();
    }

    /**
     * Complete login flow -- combines multiple actions.
     * Ithu oru HELPER method, test class la easy-ah call pannalam.
     */
    public void performLogin(String username, String password) {
        System.out.println("\n🔐 === Performing Complete Login Flow ===");
        waitForPageToLoad();
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        System.out.println("🔐 === Login Flow Complete ===\n");
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }
}
