package task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkoutPOM {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:/BackUpC/Documents/MiniBootcampQA/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/inventory.html");

        //scenario login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("secret_sauce");

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input.submit-button.btn_action")).click();

        Thread.sleep(1000);

        //add product
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        Thread.sleep(1000);
        //checkout
        driver.findElement(By.name("checkout")).click();

        Thread.sleep(1000);

        driver.findElement(By.id("first-name")).sendKeys("Ryrie");

        Thread.sleep(1000);

        driver.findElement(By.id("last-name")).sendKeys("Ceisha");

        Thread.sleep(1000);

        driver.findElement(By.id("postal-code")).sendKeys("40162");

        Thread.sleep(1000);

        driver.findElement(By.cssSelector(".submit-button.btn_primary.cart_button")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@id='finish']")).click();

        Thread.sleep(1000);

        // Scenario confirmation page
        driver.findElement(By.cssSelector(".complete-header")).getText();

        Thread.sleep(1000);

        driver.quit();
    }
}
