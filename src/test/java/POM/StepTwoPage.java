package POM;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class StepTwoPage {
    private WebDriver driver;

    /*Поле КогдаПривезтиСамокат*/
    private By fieldDataDelivery = By.xpath("//input[contains(@placeholder,'Когда привезти самокат')]");

    /*Поле СрокАренды*/
    private By fieldTimeRent = By.xpath("//div[text()='* Срок аренды']");

    /*Спиок с выбором срока аренды*/
    private By rentDay = By.xpath("//div[@role='option']");

    /*Чек бокс цвета*/
    private By checkboxBlack = By.xpath("//label[text()='чёрный жемчуг']//input");

    /*Чек бокс цвета*/
    private By checkboxGrey = By.xpath("//label[text()='серая безысходность']//input");

    /*Поле комментарий*/
    private By comment = By.xpath("//input[@placeholder='Комментарий для курьера']");

    /*Кнопка Заказать*/
    private By buttonOrder = By.xpath("//div[contains(@class,'Order')]//button[text()='Заказать']");

    /*Кнопка Да (подтверждение заказа)*/
    private By buttonYes = By.xpath("//div[contains(@class,'Order')]//button[text()='Да']");

    /*Кнопка Да (подтверждение заказа)*/
    private By buttonNo = By.xpath("//div[contains(@class,'Order')]//button[text()='Нет']");

    /*Модальное окно с оформленным заказом*/
    private  By modalOrder = By.xpath(".//div[contains(@class, 'Order_ModalHeader')]");

    public StepTwoPage(WebDriver driver) {
        this.driver = driver;
    }

    /*Ожидание загрузки, ввод даты доставки*/
    public void inputDataDelivery (String data) {
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(fieldDataDelivery));
        driver.findElement(fieldDataDelivery).sendKeys(data, Keys.ENTER);
    }
    /* Выбор срока аренды. Ввиду того, что есть элементы, до которых без скролла не добравться (7 сдней) -
     * применен скролл */
    public void clickRentDay (int day) {
        driver.findElement(fieldTimeRent).click();
        List<WebElement> days = driver.findElements(rentDay);
        Actions action = new Actions(driver);
        action.moveToElement(days.get(day-1));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",days.get(day-1));
        days.get(day-1).click();
    }
    /*Выбор цветов самоката*/
    public void clickCheckboxBlack() {
        driver.findElement(checkboxBlack).click();
    }
    public void clickCheckboxGrey() {
        driver.findElement(checkboxGrey).click();
    }
    /*Ввод комментария для курьера*/
    public void inputComment (String com) {
        driver.findElement(comment).sendKeys(com);
    }
    /*Заказать самокат*/
    public void clickOrder() {
        driver.findElement(buttonOrder).click();
    }

    /*Возврат атрибута textContent текущего модального окна*/
    public String getModalWindowPropertyTextContent() {
        return driver.findElement(modalOrder).getAttribute("textContent");
    }

    /*Подтверждение заказа*/
    public void orderConfirmation() {
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonYes));
        driver.findElement(buttonYes).click();
    }

}
