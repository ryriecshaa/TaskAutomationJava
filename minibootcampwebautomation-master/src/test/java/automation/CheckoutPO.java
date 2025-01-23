package automation;

import java.util.HashMap;
//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import com.webautomation.pageobjects.Login;
//import com.webautomation.pageobjects.ProductListPage;

public class CheckoutPO {

    WebDriver driver;

    @Test(dataProvider = "getData")
    public void checkoutProduct (HashMap<String, String>inputMap) throws InterruptedException {
       
        System.setProperty("webdriver.chrome.driver", "/Users/bytedance/CourseQAAutomation/Web Automation/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/client");

        Login login = new Login(driver);
        System.out.println("ini " + inputMap.get("email"));
        login.loginApplication(inputMap.get("email"), inputMap.get("password"));

        //Scenario add product
        Thread.sleep(1000);

        String productName = inputMap.get("productName");
       

        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.addProduct(productName);

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

        driver.findElement(By.cssSelector(".action__submit")).click();

        Thread.sleep(1000);


        // Scenario confirmation page

        String confirmationPage = driver.findElement(By.cssSelector(".hero-primary")).getText();

        Assert.assertTrue(confirmationPage.equals("THANKYOU FOR THE ORDER."));

        driver.quit();
    }

    @DataProvider(name = "getData")
    public Object[][] getData(){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("email", "simanjuntakalbert57@gmail.com");
        map.put("password", "XBf@rWNvByn!#K8");
        map.put("productName", "QWERTY");

        return new Object[][] {{map}};
    }
}