package automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
//import org.openqa.selenium.JavascriptExecutor;

public class Checkout {
    public static void main(String[] args) throws InterruptedException {
        //setup driver
        System.setProperty("webdriver.chrome.driver", "E:/BackUpC/Documents/MiniBootcampQA/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/client");

        //scenario login
        driver.findElement(By.id("userEmail")).sendKeys("ryriecshaa@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Ryrie1234.");

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input.login-btn")).click();

        Thread.sleep(1000);
        
        //Scenario add product
        Thread.sleep(1000);

        String productName = "QWERTY";
        WebElement cardElement = null;

        List<WebElement>listProducts = driver.findElements(By.cssSelector(".mb-3"));

        for (WebElement webElement : listProducts) {
            String product = webElement.findElement(By.cssSelector("b")).getText();
            // System.out.println("ini adladh product" + product);
            if (product.equals(productName)) {
                cardElement = webElement;
                // System.out.println("stop");
                break;
            }
        }

        cardElement.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        Thread.sleep(3000);

        //Scenario checkout
        driver.findElement(By.xpath("//li[@class='totalRow']/button[@type='button']")).click();

        Thread.sleep(1000);

        //Scenario shipping
        driver.findElement(By.xpath("//input[@placeholder='Select Country' and contains(@class, 'input txt text-validated')]")).sendKeys("Indonesia");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[@class='ng-star-inserted']")).click();

        Thread.sleep(1000);

        // Scroll ke elemen sebelum klik
        Actions actions = new Actions(driver);
        WebElement submitButton = driver.findElement(By.cssSelector(".action__submit"));
        actions.moveToElement(submitButton).perform(); // Menggulung layar hingga elemen terlihat

        submitButton.click();

        Thread.sleep(1000);

        // Scenario confirmation page

        String confirmationPage = driver.findElement(By.cssSelector(".hero-primary")).getText();

        Assert.assertTrue(confirmationPage.equals("THANKYOU FOR THE ORDER."));

        Thread.sleep(1000);

        driver.quit();


    }
}
