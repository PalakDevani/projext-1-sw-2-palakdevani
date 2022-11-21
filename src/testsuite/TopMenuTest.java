package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before    // this will open the browser before running @test
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputersPageSuccessfully() {
        clickOnElement(By.linkText("Computers"));
        String expectedText = "Computers";
        String actualText = getTextFromElement(By.xpath("//div[@class = 'header-menu'] /ul[1]/li[1]/a"));
        Assert.assertEquals("NavigateToComputersPageSuccessfully", expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
/*        clickOnElement(By.linkText("Electronics"));
        String expectedText = "Electronics";
        String actualText = getTextFromElement(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/a"));
        Assert.assertEquals("NavigateToElectronicsPageSuccessfully",expectedText,actualText);*/


        clickOnElement(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/a"));
        String expectedMessage = "Electronics";
        String actualMessage = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test

    public void userShouldNavigateToApparelPageSuccessfully() {
        clickOnElement(By.linkText("Apparel"));
        String expectedMessage = "Apparel";
        String actualMessage = getTextFromElement(By.xpath("//div[@class= 'header-menu']/ul[1]/li[3]/a"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test

    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        clickOnElement(By.linkText("Digital downloads"));
        String expectedText = "Digital downloads";
        String actualText = getTextFromElement(By.xpath("//div[@class='header-menu']/ul[1]/li[4]/a"));
        Assert.assertEquals("NavigateToDigitalDownloadsPageSuccessfully", expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        clickOnElement(By.linkText("Books"));
        String expectedText = "Books";
        String actualText = getTextFromElement(By.xpath("//div[@class='header-menu']/ul[1]/li[5]/a"));
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void userShouldNavigateToJewelleryPageSuccessfully() throws InterruptedException {
        Thread.sleep(10); // allows time before closing ;holds the browser after execu. and before closing.
        clickOnElement(By.linkText("Jewelry"));
        String expectedText = "Jewelry";
        String actualText = getTextFromElement(By.xpath("//div[@class='header-menu']/ul[1]/li[6]/a"));
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        clickOnElement(By.linkText("Gift Cards"));
        String expectedText = "Gift Cards";
        String actualText = getTextFromElement(By.xpath("//div[@class='header-menu']/ul[1]/li[7]/a"));
        Assert.assertEquals(expectedText, actualText);

    }

    @After
    public void testDown() {
        closeBrowser();
    }
}
