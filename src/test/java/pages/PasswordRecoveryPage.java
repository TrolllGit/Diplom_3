package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    private final WebDriver driver;
    private final By loginLink = By.xpath("//*[@id='root']/div/main/div/div/p/a");

    public PasswordRecoveryPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickLoginLink(){
        driver.findElement(loginLink).click();
    }
}
