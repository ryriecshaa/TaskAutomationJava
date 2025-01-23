package task1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By checkoutButton = By.name("checkout");
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By postalCodeField = By.id("postal-code");
    By continueButton = By.cssSelector(".submit-button.btn_primary.cart_button");
    By finishButton = By.xpath("//button[@id='finish']");
    By confirmationMessage = By.cssSelector(".complete-header");

    // Actions
    public void startCheckout(String firstName, String lastName, String postalCode) {
        driver.findElement(checkoutButton).click();
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
        driver.findElement(continueButton).click();
    }

    public String finishCheckout() {
        driver.findElement(finishButton).click();
        return driver.findElement(confirmationMessage).getText();
    }
}
