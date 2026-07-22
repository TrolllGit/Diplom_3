package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    private final By emailField = By.xpath("(//fieldset)[1]//input[@type='text']");
    private final By passwordField = By.xpath("(//fieldset)[2]//input[@type='password']");
    private final By loginButton = By.xpath("//button[contains(text(),'Войти')]");
    private final By registerLink = By.xpath("//a[contains(text(),'Зарегистрироваться')]");
    private final By passwordRecoveryLink = By.xpath("//a[contains(text(),'Восстановить пароль')]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Ввод логина, пароля и нажатие кнопки Войти")
    public void login(String email, String password){
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    @Step("Клик по ссылке Зарегистрироваться")
    public void clickRegisterLink(){
        driver.findElement(registerLink).click();
    }

    @Step("Клик по ссылке Восстановить пароль")
    public void clickPasswordRecoveryLink(){
        driver.findElement(passwordRecoveryLink).click();
    }
}
