package tests;

import base.BaseTest;
import models.User;
import org.junit.Assert;
import org.junit.Test;
import pages.RegistrationPage;
import utils.TestData;

public class RegistrationTest extends BaseTest {

    @Test
    public void shouldRegisterSuccessfully(){
        User user = TestData.randomUser();
        RegistrationPage page = new RegistrationPage(driver);
        driver.get(baseUrl + "/register");
        page.register(user.getName(), user.getEmail(), user.getPassword());
        waitForUrlContains("/login");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void shouldShowErrorForShortPassword(){
        User user = TestData.shortPasswordUser();
        RegistrationPage page = new RegistrationPage(driver);
        driver.get(baseUrl + "/register");
        page.register(user.getName(), user.getEmail(), user.getPassword());
        Assert.assertEquals("Некорректный пароль", page.getPasswordError());
    }
}
