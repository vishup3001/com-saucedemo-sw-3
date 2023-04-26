package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        // Open browser and launch url
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        //Close all browser
        closeBrowser();
    }

    @Test
    public void userSholdLoginSuccessfullyWithValid() {
        // Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        // Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        //Verify the text “PRODUCTS”
        String expectedMessage = "Products";
        String actualMessage = getTextFromElement(By.xpath("//span[@class='title']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        // Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        // Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));

        // Verify that six products are displayed on page
        int expectedMessage = 6;
        List<WebElement> totalproduct = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int acceptedMessage = totalproduct.size();
        verifyTwoTextMessage(expectedMessage,acceptedMessage);

    }

}
