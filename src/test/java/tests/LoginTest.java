package tests;

import base.BaseApiTest;
import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.PasswordRecoveryPage;
import pages.RegistrationPage;

public class LoginTest extends BaseApiTest {

    @Test
    public void shouldLoginFromMainPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.open();
        mainPage.clickLoginButton();
        waitForUrlContains("/login");
        loginPage.login(user.getEmail(),user.getPassword());
        Assert.assertTrue(driver.getCurrentUrl().contains("stellarburgers.education-services.ru"));
}

    @Test
    public void shouldLoginFromPersonalCabinet(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.open();
        mainPage.clickPersonalCabinet();
        waitForUrlContains("/login");
        loginPage.login(user.getEmail(),user.getPassword());
        Assert.assertTrue(driver.getCurrentUrl().contains("stellarburgers.education-services.ru"));
    }

    @Test
    public void shouldLoginFromRegisterForm(){
        LoginPage loginPage = new LoginPage(driver);

        driver.get(baseUrl + "/register");
        new RegistrationPage(driver).clickLoginLink();
        waitForUrlContains("/login");
        loginPage.login(user.getEmail(), user.getPassword());
        Assert.assertTrue(driver.getCurrentUrl().contains("stellarburgers.education-services.ru"));
    }

    @Test
    public void shouldLoginFromPasswordRecovery(){
        LoginPage loginPage = new LoginPage(driver);
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);

        driver.get(baseUrl + "/forgot-password");
        passwordRecoveryPage.clickLoginLink();
        waitForUrlContains("/login");
        loginPage.login(user.getEmail(),user.getPassword());
        Assert.assertTrue(driver.getCurrentUrl().contains("stellarburgers.education-services.ru"));
    }
}
