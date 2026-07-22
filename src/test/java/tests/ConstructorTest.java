package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Переход к разделу Булки")
    @Description("После переключения на раздел Соусы и обратно на Булки, вкладка Булки должна быть активной")
    public void shouldOpenBunsSection(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickSauces();
        mainPage.clickBuns();
        Assert.assertTrue(mainPage.isBunsActive());
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    @Description("После клика по вкладке Соусы, вкладка должна стать активной")
    public void shouldOpenSaucesSection(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickSauces();
        Assert.assertTrue(mainPage.isSaucesActive());
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    @Description("После клика по вкладке Начинки, вкладка должна стать активной")
    public void shouldOpenFillingSection(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickFillings();
        Assert.assertTrue(mainPage.isFillingsActive());
    }
}
