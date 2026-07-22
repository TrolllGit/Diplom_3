package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By loginButton = By.xpath("//button[contains(text(),'Войти в аккаунт')]");
    private final By personalCabinetButton = By.xpath("//a[@href='/account']");
    private final By bunsTab = By.xpath("//span[text()='Булки']/parent::div");
    private final By saucesTab = By.xpath("//span[text()='Соусы']/parent::div");
    private final By fillingsTab = By.xpath("//span[text()='Начинки']/parent::div");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Открытие главной страницы")
    public void open() {
        driver.get(System.getProperty("base.url", "https://stellarburgers.education-services.ru"));
    }

    @Step("Клик по кнопке Войти в аккаунт")
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    @Step("Клик по кнопке Личный кабинет")
    public void clickPersonalCabinet() {
        wait.until(ExpectedConditions.elementToBeClickable(personalCabinetButton)).click();
    }

    @Step("Клик по вкладке Булки")
    public void clickBuns() {
        driver.findElement(bunsTab).click();
    }

    @Step("Клик по вкладке Соусы")
    public void clickSauces() {
        driver.findElement(saucesTab).click();
    }

    @Step("Клик по вкладке Начинки")
    public void clickFillings() {
        driver.findElement(fillingsTab).click();
    }

    @Step("Проверка активности вкладки Булки")
    public boolean isBunsActive() {
        return driver.findElement(bunsTab).getAttribute("class").contains("tab_tab_type_current");
    }

    @Step("Проверка активности вкладки Соусы")
    public boolean isSaucesActive() {
        return driver.findElement(saucesTab).getAttribute("class").contains("tab_tab_type_current");
    }

    @Step("Проверка активности вкладки Начинки")
    public boolean isFillingsActive() {
        return driver.findElement(fillingsTab).getAttribute("class").contains("tab_tab_type_current");
    }
}
