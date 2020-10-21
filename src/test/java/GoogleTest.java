import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GoogleTest {

    private WebDriver webDriver;


    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver",
                "D:/programistyczny/chromeDriver/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.navigate().to("http://google.pl");
    }

    @AfterMethod
    public void after() {
        webDriver.close();
        webDriver.quit();
    }

    @Test
    public void testGoogle() {
        WebElement searchInput = webDriver.findElement(By.name("q"));
        searchInput.sendKeys("wp.pl");
        searchInput.submit();
        String pageTitle = webDriver.getTitle();
        assertTrue(pageTitle.contains("wp.pl"));
    }
}
