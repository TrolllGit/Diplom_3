package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    private final By emailField = By.xpath("//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input");
    private final By passwordField = By.xpath("//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input");
    private final By loginButton = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");
    private final By registerLink = By.xpath("//*[@id='root']/div/main/div/div/p[1]/a");
    private final By passwordRecoveryLink = By.xpath("//*[@id='root']/div/main/div/div/p[2]/a");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void login(String email, String password){
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void clickRegisterLink(){
        driver.findElement(registerLink).click();
    }

    public void clickPasswordRecoveryLink(){
        driver.findElement(passwordRecoveryLink).click();
    }







}
