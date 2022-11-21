package browserfactory;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseUrl) {
// Browser set up code
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); // setting the properties
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize(); // Maximise window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // to give implicit time to driver to load the page before it throw exception
    }

    public void closeBrowser() {
        driver.quit();
    }

}
