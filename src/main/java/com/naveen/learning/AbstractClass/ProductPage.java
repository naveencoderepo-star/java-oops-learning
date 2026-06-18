package com.naveen.learning.AbstractClass;

// ============================================================================
// ProductPage - THIRD CHILD CLASS that EXTENDS AbstractClass (BasePage)
// ============================================================================
// Innum oru page! Ithu e-commerce application oda product page.
// SAME abstract methods, INNUM oru DIFFERENT implementation!
//
// 3 pages (LoginPage, HomePage, ProductPage) -- ellaam SAME BasePage extend panrathu.
// But each page oda waitForPageToLoad(), getPageTitle() etc. DIFFERENT!
//
// Ithu thaan abstract class oda beauty:
//   ✅ CODE REUSE: navigateTo(), takeScreenshot() ellaa pages ku SAME (parent la)
//   ✅ FORCED STRUCTURE: each page MUST implement waitForPageToLoad() etc.
//   ✅ POLYMORPHISM: BasePage page = new ProductPage(); --> Runtime la decide aagum!
// ============================================================================

public class ProductPage extends AbstractClass {

    // ----- ProductPage-specific fields -----
    private String productTitleLocator;
    private String productPriceLocator;
    private String addToCartButtonLocator;
    private String productImageLocator;
    private String currentProductName;
    private double currentProductPrice;

    // ----- CONSTRUCTOR -----
    public ProductPage(String driverInfo, String baseUrl) {
        super(driverInfo, baseUrl);  // Parent constructor call ✅
        this.pageName = "Product Page";
        this.productTitleLocator = "#productTitle";
        this.productPriceLocator = "#productPrice";
        this.addToCartButtonLocator = "#addToCart";
        this.productImageLocator = "#productImage";
        this.currentProductName = "";
        this.currentProductPrice = 0.0;
        System.out.println("🛒 ProductPage initialized with locators!");
    }

    // =====================================================================
    // ABSTRACT METHOD IMPLEMENTATIONS -- ProductPage-SPECIFIC!
    // =====================================================================

    @Override
    public void waitForPageToLoad() {
        System.out.println("⏳ ProductPage: Waiting for product details to load...");
        System.out.println("   Checking element: " + productTitleLocator);
        System.out.println("   Checking element: " + productPriceLocator);
        System.out.println("   Checking element: " + productImageLocator);
        System.out.println("   Checking element: " + addToCartButtonLocator);
        System.out.println("✅ ProductPage: Product details fully loaded!");
    }

    @Override
    public String getPageTitle() {
        String title = "MyApp - Product: " + currentProductName;
        System.out.println("📌 ProductPage title: " + title);
        return title;
    }

    @Override
    public boolean isPageDisplayed() {
        System.out.println("👀 Checking if Product Page is displayed...");
        System.out.println("   Looking for product title: " + productTitleLocator);
        System.out.println("✅ Product Page is displayed!");
        return true;
    }

    @Override
    public void verifyPageElements() {
        System.out.println("🔍 Verifying Product Page elements:");
        System.out.println("   ✅ Product title found: " + productTitleLocator);
        System.out.println("   ✅ Product price found: " + productPriceLocator);
        System.out.println("   ✅ Product image found: " + productImageLocator);
        System.out.println("   ✅ Add to Cart button found: " + addToCartButtonLocator);
        System.out.println("   All product page elements verified!");
    }

    // =====================================================================
    // ProductPage-SPECIFIC METHODS
    // =====================================================================

    public void setProductDetails(String name, double price) {
        this.currentProductName = name;
        this.currentProductPrice = price;
        System.out.println("📦 Product set: " + name + " - ₹" + price);
    }

    public String getProductName() {
        System.out.println("📦 Product Name: " + currentProductName);
        return currentProductName;
    }

    public double getProductPrice() {
        System.out.println("💰 Product Price: ₹" + currentProductPrice);
        return currentProductPrice;
    }

    public void clickAddToCart() {
        System.out.println("🛒 Clicking 'Add to Cart': " + addToCartButtonLocator);
        System.out.println("✅ Product '" + currentProductName + "' added to cart!");
    }

    /**
     * Complete product verification flow.
     */
    public void verifyProductPage(String expectedProduct, double expectedPrice) {
        System.out.println("\n🛒 === Verifying Product Page ===");
        waitForPageToLoad();
        verifyPageElements();
        setProductDetails(expectedProduct, expectedPrice);
        getProductName();
        getProductPrice();
        System.out.println("🛒 === Product Page Verification Complete ===\n");
    }
}
