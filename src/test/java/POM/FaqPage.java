package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;
public class FaqPage {
    private WebDriver driver;

    /*Вопросы о важном*/
    private By headerQue = By.xpath("//div[text()='Вопросы о важном']");

    /*Лист вопросов*/
    private By buttonsQue = By.xpath("//div[contains(@class,'FAQ')]//div[@class='accordion__button']");

    /*Ответ на вопрос*/
    private By answerAfterClick = By.xpath("(//div[contains(@class,'FAQ')]//div[@class='accordion__panel' and not(@hidden)])/p");

    /*Согласие Cookie*/
    private By buttonCookie = By.xpath("//button[text()='да все привыкли']");

    public FaqPage(WebDriver driver) {
        this.driver = driver;
    }

    /*Скролл до FAQ*/
    public void scrollToFaq() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(headerQue));
    }

    /*Ожидание загрузки FAQ*/
    public void waitLoadFaq() {
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(headerQue));
    }

    /* клик по N-ой кнопке вопроса*/
    public String clickButtonQue (int num) {
        List<WebElement> elements = driver.findElements(buttonsQue);
        elements.get(num-1).click();
        return elements.get(num-1).getText();
    }
    /*Возврат ответа после клика*/
    public String getTextAnswerAfterClick() {                       // возврат текста ответа после клика
        return driver.findElement(answerAfterClick).getText();
    }

    /*Согласие на Cookie*/
    public void closeCookie() {                             // жмем кнопку, чтобы закрыть сообщение об использовании Cookie
        driver.findElement(buttonCookie).click();
    }
}
