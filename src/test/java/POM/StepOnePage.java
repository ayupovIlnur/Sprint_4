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

    /*Предупреждение о неправильно введеннеом имени*/
    private By warningName = By.xpath("//div[text()='Введите корректное имя']");

    /*Предупреждение о неправильно введеннеой фамилии*/
    private By warningSurname = By.xpath("//div[text()='Введите корректную фамилию']");

    /*Предупреждение о неправильно введенном адресе*/
    private By warningAddress = By.xpath("//div[text()='Введите корректный адрес']");

    /*Предупреждение о неправильно введенном телефоне*/
    private By warningPhone = By.xpath("//div[text()='Введите корректный номер']");

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
        driver.findElement(fieldPhone).sendKeys(phone,Keys.TAB);
    }
    /* Переход на следующий шаг*/
    public void nextStep() {
        driver.findElement(nextButton).click();
    }

    /*Появилось ли предупреждение о неправльно введенном имени*/
    public boolean warningName () {
        return driver.findElement(warningName).isDisplayed();
    }

    /*Появилось ли предупреждение о неправльно введенной фамилии*/
    public boolean warningSurname () {
        return driver.findElement(warningSurname).isDisplayed();
    }

    /*Появилось ли предупреждение о неправльно введенном адресе*/
    public boolean warningAddress () {
        return driver.findElement(warningAddress).isDisplayed();
    }

    /*Появилось ли предупреждение о неправльно введенном телефоне*/
    public boolean warningPhone () {
        return driver.findElement(warningPhone).isDisplayed();
    }

}
