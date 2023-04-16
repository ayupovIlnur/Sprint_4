import POM.HeaderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class NegativeNumOrderTest {

    /*Картинка, появляющая при вводе неправильного номера*/
    private By imgNotFound = By.xpath("//img[@alt='Not found']");
    WebDriver driver;
    @Before
    public void startUp() {
        /*Выбор браузера*/
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
    }


    /*Если тест прошел - картинка о том, что заказ не найдет - появилась.*/
    @Test
    public void NegativNumOrderTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.closeCookie();
        headerPage.clickStatusOrder();
        headerPage.inputNumOrder("7118401");
        headerPage.clickButtonGo();
        new WebDriverWait(driver,3)
                .until(ExpectedConditions.visibilityOfElementLocated(imgNotFound));
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }

}