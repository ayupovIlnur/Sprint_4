package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import javax.swing.*;


public class HeaderPage {
    private WebDriver driver;
    /*Кнопка заказать в хэдере*/
    private By buttonOrderHeader = By.xpath("//div[contains(@class,'Header')]//button[text()='Заказать']");

    /*Кнопка СтатусЗаказа в хэдере*/
    private By buttonStatusOrderHeader = By.xpath("//div[contains(@class,'Header')]//button[text()='Статус заказа']");

    /*Кнопка Заказать в середине страницы сайта*/
    private By buttonOrderHome = By.xpath("//div[contains(@class,'Home_Road')]//button[text()='Заказать']");

    /*Кнопка Cookie*/
    private By buttonCookie = By.xpath("//button[text()='да все привыкли']");

    /*Лого Самоката*/
    private By logoSamokat = By.xpath("//img[@alt='Scooter']");

    /*Лого Яндекса*/
    private By logoYandex = By.xpath("//img[@alt='Yandex']");

    /*Поле ввода номера заказа*/
    private By fielNumOrder = By.xpath("//input[@placeholder='Введите номер заказа']");

    /*Кнопка проверки заказа (Go!)*/
    private By buttonGoStatus = By.xpath("//button[text()='Go!']");



    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    /*Клик по кнопке Заказать в хэдере*/
    public void clickOrderHeader() {
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonOrderHeader));
        driver.findElement(buttonOrderHeader).click();
    }
    /*Клик по кнопке Заказать в середине страницы сайта*/
    public void clickOrderHome() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(buttonOrderHome));
        driver.findElement(buttonOrderHome).click();
    }
    /*Клик по кнопке СтатусЗаказа в хэдере*/
    public void clickStatusOrder() {
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonStatusOrderHeader));
        driver.findElement(buttonStatusOrderHeader).click();
    }
    /*Согласие Cookie*/
    public void closeCookie() {
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonCookie));
        driver.findElement(buttonCookie).click();
    }
    /*Клик по лого Самаката и возврат baseURI новой страницы*/
    public String clickSamokat() {
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(logoSamokat));
        driver.findElement(logoSamokat).click();
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html")));
        return driver.findElement(By.xpath("//html")).getAttribute("baseURI");

    }

    /* Клик по кнопке Go! (проверка статуса заказа)*/
    public void clickButtonGo () {
        driver.findElement(buttonGoStatus).click();
    }

    /*Воод номера заказа*/
    public void inputNumOrder (String num) {
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.elementToBeClickable(fielNumOrder));
        driver.findElement(fielNumOrder).click();
        driver.findElement(fielNumOrder).sendKeys(num);
    }

}
