import POM.HeaderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import static org.junit.Assert.assertEquals;
public class LogoProjectTest {

    WebDriver driver;
    @Before
    public void startUp() {
        /*Выбор браузера*/
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
    }


    /*Проверка: если нажать на лого Самоката, попадешь на главную стр. Самоката*/
    @Test
    public void logoSamokatTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.closeCookie();
        assertEquals("Возврат на страницу Самоката не был совершен","https://qa-scooter.praktikum-services.ru/",headerPage.clickSamokat());
    }


    @After
    public void closeBrowser() {
        driver.quit();
    }

}