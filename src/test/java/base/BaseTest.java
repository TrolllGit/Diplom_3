package base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected String baseUrl = System.getProperty("base.url", "https://stellarburgers.education-services.ru");

    protected void waitForUrlContains(String part) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains(part));
    }

    @Before
    public void setUp(){
        String browser = System.getProperty("browser", "CHROME");
        if ("YANDEX".equalsIgnoreCase(browser)){
            System.setProperty("webdriver.chrome.driver", System.getProperty("yandex.driver.path"));
            ChromeOptions options = new ChromeOptions();
            options.setBinary(System.getProperty("yandex.browser.binary"));
            driver = new ChromeDriver(options);
        } else {
            driver = new ChromeDriver();
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
