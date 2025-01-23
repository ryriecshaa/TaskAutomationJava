package task1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import task1.pages.LoginPage;
import task1.pages.InventoryPage;
import task1.pages.CheckoutPage;

public class checkoutTestNG {
    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CheckoutPage checkoutPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "E:/BackUpC/Documents/MiniBootcampQA/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/inventory.html");

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    public void testCheckoutFlow() throws InterruptedException {
        // Login
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(1000);

        // Tambahkan produk
        inventoryPage.addProductToCart();
        Thread.sleep(1000);

        // Checkout
        checkoutPage.startCheckout("Ryrie", "Ceisha", "40162");
        Thread.sleep(1000);

        // Verifikasi halaman konfirmasi
        String confirmationText = checkoutPage.finishCheckout();
        Assert.assertEquals(confirmationText, "Thank you for your order!", "Pesan konfirmasi tidak sesuai!");
        Thread.sleep(1000);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
