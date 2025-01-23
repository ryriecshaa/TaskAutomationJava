package task1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    WebDriver driver;

    // Constructor
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    By cartLink = By.xpath("//a[@class='shopping_cart_link']");

    // Actions
    public void addProductToCart() {
        driver.findElement(addToCartButton).click();
        driver.findElement(cartLink).click();
    }
}
