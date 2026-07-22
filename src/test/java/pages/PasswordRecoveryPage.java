package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    private final WebDriver driver;
    private final By loginLink = By.xpath("//a[@href='/login']");
    public PasswordRecoveryPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Клик по ссылке Войти")
    public void clickLoginLink(){
        driver.findElement(loginLink).click();
    }
}
