package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before    // this will open the browser before running @test
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test   // replaces main method and gives run access
    public void userShouldNavigateToLoginPageSuccessfully() {
        clickOnElement(By.linkText("Log in")); // find and click on login link
        String expectedMessage = "Welcome, Please Sign In!"; // this is from requirement
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")); //find the welcome text element and get the text
        Assert.assertEquals(expectedMessage, actualMessage);// validate actual and expected message
    }

    @Test
    public void userShouldLoginWithValidCredentials() {
        //Thread.sleep(10);// reduces the speed of browser execu. before close/ waiting for 10 sec before closing browser
        clickOnElement(By.linkText("Log in")); // find and click on log in link
        sendTextToElement(By.id("Email"), "testsele@gmail.com");
        sendTextToElement(By.name("Password"), "1234567");
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));
        String expectedMessage = "Log out";
        String actualMessage = getTextFromElement(By.xpath("//a[text()= 'Log out']"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheErrorMessage() {
        clickOnElement(By.linkText("Log in")); // find and click on log in link
        sendTextToElement(By.id("Email"), "testing13@gmail.com"); // find the email field and type email to email field
        sendTextToElement(By.name("Password"), "test1234"); // find and type in password field
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found"; // this is from requirement
        String actualMessage = getTextFromElement(By.xpath("//div[text()='Login was unsuccessful. Please correct the errors and try again.']")); //find the error text element and get the text
        Assert.assertEquals(expectedMessage, actualMessage);// validate actual and expected message


    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}



