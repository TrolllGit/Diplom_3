package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final WebDriver driver;

    private final By nameField = By.xpath("//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input");
    private final By emailField = By.xpath("//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input");
    private final By passwordField = By.xpath("//*[@id='root']/div/main/div/form/fieldset[3]/div/div/input");
    private final By registerButton = By.xpath("//*[@id='root']/div/main/div/form/button");
    private final By errorText = By.xpath("//*[@id='root']/div/main/div/form/fieldset[3]/div/p");
    private final By loginLink = By.xpath("//*[@id='root']/div/main/div/div/p/a");

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    public void register(String name, String email, String password){
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(registerButton).click();
    }

    public String getPasswordError(){
        return driver.findElement(errorText).getText();
    }

    public void clickLoginLink(){
        driver.findElement(loginLink).click();
    }
}
