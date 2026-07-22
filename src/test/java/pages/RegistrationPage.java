package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final WebDriver driver;

    private final By nameField = By.xpath("(//fieldset)[1]//input[@type='text']");
    private final By emailField = By.xpath("(//fieldset)[2]//input[@type='text']");
    private final By passwordField = By.xpath("(//fieldset)[3]//input[@type='password']");
    private final By registerButton = By.xpath("//button[contains(text(),'Зарегистрироваться')]");
    private final By errorText = By.xpath("//p[@class='input__error text_type_main-default']");
    private final By loginLink = By.xpath("//a[@href='/login']");

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Заполнение формы регистрации")
    public void register(String name, String email, String password){
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(registerButton).click();
    }

    @Step("Получение текста ошибки пароля")
    public String getPasswordError(){
        return driver.findElement(errorText).getText();
    }

    @Step("Клик по ссылке Войти")
    public void clickLoginLink(){
        driver.findElement(loginLink).click();
    }
}
