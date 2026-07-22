package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import models.User;
import org.junit.Assert;
import org.junit.Test;
import pages.RegistrationPage;
import utils.TestData;

public class RegistrationTest extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация нового пользователя")
    @Description("Проверка, что пользователь может успешно зарегистрироваться с валидными данными")
    public void shouldRegisterSuccessfully(){
        User user = TestData.randomUser();
        RegistrationPage page = new RegistrationPage(driver);

        driver.get(baseUrl + "/register");
        page.register(user.getName(), user.getEmail(), user.getPassword());
        waitForUrlContains("/login");

        Assert.assertTrue("После регистрации должен произойти переход на страницу входа",
                driver.getCurrentUrl().contains("/login"));
    }

    @Test
    @DisplayName("Ошибка при регистрации с коротким паролем")
    @Description("Проверка, что система выдает ошибку при вводе пароля менее 6 символов")
    public void shouldShowErrorForShortPassword(){
        User user = TestData.shortPasswordUser();
        RegistrationPage page = new RegistrationPage(driver);

        driver.get(baseUrl + "/register");
        page.register(user.getName(), user.getEmail(), user.getPassword());

        Assert.assertEquals("Должно появиться сообщение об ошибке",
                "Некорректный пароль", page.getPasswordError());
    }
}
