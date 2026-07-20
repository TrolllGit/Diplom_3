package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;

    private final By loginButton = By.xpath("//*[@id=\"root\"]/div/main/section[2]/div/button");
    private final By personalCabinetButton = By.xpath("//*[@id=\"root\"]/div/header/nav/a/p");
    private final By bunsTab =  By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]");
    private final By saucesTab = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]");
    private final By fillingsTab = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[3]");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get(System.getProperty("base.url", "https://stellarburgers.education-services.ru"));
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void clickPersonalCabinet(){
        driver.findElement(personalCabinetButton).click();
    }

    public void clickBuns(){
        driver.findElement(bunsTab).click();
    }

    public void clickSauces(){
        driver.findElement(saucesTab).click();
    }

    public void clickFillings(){
        driver.findElement(fillingsTab).click();
    }

    public boolean isBunsActive(){
        return driver.findElement(bunsTab).getAttribute("class").contains("tab_tab_type_current__2BEPc");
    }

    public boolean isSaucesActive(){
        return driver.findElement(saucesTab).getAttribute("class").contains("tab_tab_type_current__2BEPc");
    }

    public boolean isFillingsActive(){
        return driver.findElement(fillingsTab).getAttribute("class").contains("tab_tab_type_current__2BEPc");
    }
}
