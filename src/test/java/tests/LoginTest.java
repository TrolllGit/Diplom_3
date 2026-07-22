package tests;

import base.BaseTestForLogin;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.LoginPage;
import pages.MainPage;
import pages.PasswordRecoveryPage;
import pages.RegistrationPage;


public class LoginTest extends BaseTestForLogin {

    @Test
    @DisplayName("Вход через кнопку Войти в аккаунт на главной")
    @Description("Успешный вход в систему при переходе через главную страницу")
    public void shouldLoginFromMainPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.open();
        mainPage.clickLoginButton();
        waitForUrlContains("/login");
        loginPage.login(user.getEmail(),user.getPassword());

        Assert.assertTrue("После входа должна появиться кнопка 'Личный кабинет'",
                driver.findElement(By.cssSelector(".AppHeader_header__linkText__3q_va")).isDisplayed());
}

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    @Description("Успешный вход в систему при переходе через личный кабинет")
    public void shouldLoginFromPersonalCabinet(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.open();
        mainPage.clickPersonalCabinet();
        waitForUrlContains("/login");
        loginPage.login(user.getEmail(),user.getPassword());
        Assert.assertTrue("После входа должна появиться кнопка 'Личный кабинет'",
                driver.findElement(By.cssSelector(".AppHeader_header__linkText__3q_va")).isDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Успешный вход в систему при переходе через форму регистрации")
    public void shouldLoginFromRegisterForm(){
        LoginPage loginPage = new LoginPage(driver);

        driver.get(baseUrl + "/register");
        new RegistrationPage(driver).clickLoginLink();
        waitForUrlContains("/login");
        loginPage.login(user.getEmail(), user.getPassword());
        Assert.assertTrue("После входа должна появиться кнопка 'Личный кабинет'",
                driver.findElement(By.cssSelector(".AppHeader_header__linkText__3q_va")).isDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Успешный вход в систему при переходе через форму восстановления пароля")
    public void shouldLoginFromPasswordRecovery(){
        LoginPage loginPage = new LoginPage(driver);
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);

        driver.get(baseUrl + "/forgot-password");
        passwordRecoveryPage.clickLoginLink();
        waitForUrlContains("/login");
        loginPage.login(user.getEmail(),user.getPassword());
        Assert.assertTrue("После входа должна появиться кнопка 'Личный кабинет'",
                driver.findElement(By.cssSelector(".AppHeader_header__linkText__3q_va")).isDisplayed());

    }
}
