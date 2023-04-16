package POM;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepOnePage {
    private WebDriver driver;
    /*Поле Имя*/
    private By fieldName = By.xpath("//input[contains(@placeholder,'Имя')]");

    /*Поле Фамилия*/
    private By fieldSurname = By.xpath("//input[contains(@placeholder,'Фамилия')]");

    /*Поле Адрес*/
    private By fieldAddress = By.xpath("//input[contains(@placeholder,'Адрес')]");

    /*Поле станция Метро*/
    private By fieldStationMetro = By.xpath("//input[contains(@placeholder,'Станция метро')]");

    /*Поле Телефон*/
    private By fieldPhone = By.xpath("//input[contains(@placeholder,'Телефон')]");

    /*Кнопка Далее*/
    private By nextButton = By.xpath("//div[contains(@class,'Next')]//button[text()='Далее']");
    public StepOnePage(WebDriver driver) {
        this.driver = driver;
    }

    /*Ожидание появления поля, ввод имени*/
    public void inputName (String name) {
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(fieldName));
        driver.findElement(fieldName).sendKeys(name);
    }
    /* Ввод фамилии */
    public void inputSurname (String surname) {
        driver.findElement(fieldSurname).sendKeys(surname);
    }
    /*Воод адреса*/
    public void inputAddress (String address) {
        driver.findElement(fieldAddress).sendKeys(address);
    }
    /*Ввод станции ментро*/
    public void inputStationMetro (String station) {
        driver.findElement(fieldStationMetro).click();
        driver.findElement(fieldStationMetro).sendKeys(station, Keys.DOWN,Keys.ENTER);
    }
    /* Ввод телефона*/
    public void inputPhone (String phone) {
        driver.findElement(fieldPhone).sendKeys(phone);
    }
    /* Переход на следующий шаг*/
    public void nextStep() {
        driver.findElement(nextButton).click();
    }

}
