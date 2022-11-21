package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegistrationTest extends Utility {
    String baseUrl = " https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        clickOnElement(By.linkText("Register"));
        sendTextToElement(By.name("Gender"), "M,F");
        sendTextToElement(By.id("FirstName"), "Krishiv");
        sendTextToElement(By.name("LastName"), "Patel");
        sendTextToElement(By.name("DateOfBirthDay"), "01");
        sendTextToElement(By.name("DateOfBirthMonth"), "12");
        sendTextToElement(By.name("DateOfBirthYear"), "1986");
        sendTextToElement(By.id("Email"), "testing@gmail.com");
        sendTextToElement(By.id("Password"), "1234Test");
        sendTextToElement(By.name("ConfirmPassword"), "1234Test");
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        String expectedMessage = "Your registration completed"; // this is from requirement
        String actualMessage = getTextFromElement(By.xpath("//div[contains(text(), 'Your registration completed')]")); // this is from elements
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @After
    public void testDown() {
        closeBrowser();
    }

}
