package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/\n";

    @Before
    public void test() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
         //Enter  username
        sendTextToElement(By.id("user-name"),"standard_user");
        //Enter  password
        sendTextToElement(By.id("password"),"secret_sauce");
        //Click on  button
        driver.findElement(By.xpath("//input[@id = 'login-button']")).click();
        String expectedtext = "Products";
        Assert.assertEquals("Product is not dispaly",expectedtext);

    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter  username
        sendTextToElement(By.id("user-name"),"standard_user");
        ////Enter  password
        sendTextToElement(By.id("password"),"secret_sauce");
        //  //Click on  button
        clickOnElement(By.xpath("//input[@id = 'login-button']"));
        List<WebElement> elementlist = driver.findElements(By.className("inventory_item"));
        System.out.println("Total Product are " + elementlist.size());
    }

    @After
    public void close() {
        closeBrowser();
    }
}
