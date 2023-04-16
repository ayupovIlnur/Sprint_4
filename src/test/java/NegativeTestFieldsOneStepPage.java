import POM.HeaderPage;
import POM.StepOnePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class NegativeTestFieldsOneStepPage {

    WebDriver driver;
    @Before
    public void startUp() {
        /*Выбор браузера*/
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
    }


    /*Негативное тестирование полей страницы ввода персональных данных (шаг 1)*/
    @Test
    public void NegativeTestFieldsOneStep() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.closeCookie();
        headerPage.clickOrderHeader();
        StepOnePage stepOne = new StepOnePage(driver);
        /*Страница ввода персональных данных*/
        stepOne.inputName("Zhenya");
        stepOne.inputSurname("Volnov");
        stepOne.inputAddress("7 house street of Pushkin");
        stepOne.inputPhone("восемь восемьсот 555 35 35");
        assertEquals("Не появилось предупреждение о неправильно введенном имени",true,stepOne.warningName());
        assertEquals("Не появилось предупреждение о неправильно введенной фамилии",true,stepOne.warningSurname());
        assertEquals("Не появилось предупреждение о неправильно введенном адресе",true,stepOne.warningAddress());
        assertEquals("Не появилось предупреждение о неправильно введенном телефоне",true,stepOne.warningPhone());
    }


    @After
    public void closeBrowser() {
        driver.quit();
    }

}