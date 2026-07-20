package tests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;

public class ConstructorTest extends BaseTest {

    @Test
    public void shouldOpenBunsSection(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickSauces();
        mainPage.clickBuns();
        Assert.assertTrue(mainPage.isBunsActive());
    }

    @Test
    public void shouldOpenSaucesSection(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickSauces();
        Assert.assertTrue(mainPage.isSaucesActive());
    }

    @Test
    public void shouldOpenFillingSection(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickFillings();
        Assert.assertTrue(mainPage.isFillingsActive());
    }
}
