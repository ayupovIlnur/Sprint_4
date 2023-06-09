import POM.HeaderPage;
import POM.StepOnePage;
import POM.StepTwoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.core.StringContains.containsString;
public class OrderingTest {

    WebDriver driver;
    @Before
    public void startUp() {
        /*Выбор браузера*/
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
    }


    // Заказ через верхнюю кнопку (которая в хэдере)
    @Test
    public void OrderingTestUpButton() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.closeCookie();
        headerPage.clickOrderHeader();
        StepOnePage stepOne = new StepOnePage(driver);
        /*Страница ввода персональных данных*/
        stepOne.inputName("Евгений");
        stepOne.inputSurname("Вольнов");
        stepOne.inputAddress("ул. Пушкина, дом. 7");
        stepOne.inputStationMetro("Сокольники");
        stepOne.inputPhone("89021324455");
        stepOne.nextStep();
        /*Страница параметров заказа и подтверждения заказа*/
        StepTwoPage stepTwoPage = new StepTwoPage(driver);
        stepTwoPage.inputDataDelivery("30.04.2023");
        stepTwoPage.clickRentDay(7);
        stepTwoPage.clickCheckboxBlack();
        stepTwoPage.clickCheckboxGrey();
        stepTwoPage.inputComment("Тестовый комменатрий для курьера от Евгения Вольнова");

        /*Проверка появления модального окна "Хотите оформить заказ?*/
        stepTwoPage.clickOrder();
        MatcherAssert.assertThat(String.format("Отсуствие модального окна '%s'",DataForTesting.MODAL_WINDOW_QUE_PLACE_ORDER),stepTwoPage.getModalWindowPropertyTextContent(),containsString(DataForTesting.MODAL_WINDOW_QUE_PLACE_ORDER));

        /*Проверка появления модального окна "Заказ оформлен"*/
        stepTwoPage.orderConfirmation();
        MatcherAssert.assertThat(String.format("Отсуствие модального окна '%s'",DataForTesting.MODAL_WINDOW_PLACE_ORDER),stepTwoPage.getModalWindowPropertyTextContent(),containsString(DataForTesting.MODAL_WINDOW_PLACE_ORDER));
    }

    /* Заказ через нижнюю кнопку*/
    @Test
    public void OrderingTestDownButton() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.closeCookie();
        headerPage.clickOrderHome();
        StepOnePage stepOne = new StepOnePage(driver);
        /*Страница ввода персональных данных*/
        stepOne.inputName("Нурлан");
        stepOne.inputSurname("Сабуров");
        stepOne.inputAddress("ул. Нурсултана-Назарбаева, дом. 77");
        stepOne.inputStationMetro("Каширская");
        stepOne.inputPhone("89021324455");
        stepOne.nextStep();
        /*Страница параметров заказа и подтверждения заказа*/
        StepTwoPage stepTwoPage = new StepTwoPage(driver);
        stepTwoPage.inputDataDelivery("29.04.2023");
        stepTwoPage.clickRentDay(2);
        stepTwoPage.clickCheckboxBlack();
        stepTwoPage.clickCheckboxGrey();
        stepTwoPage.inputComment("Тестовый комменатрий для курьера от Нурлана");

        /*Проверка появления модального окна "Хотите оформить заказ?*/
        stepTwoPage.clickOrder();
        MatcherAssert.assertThat(String.format("Отсуствие модального окна '%s'",DataForTesting.MODAL_WINDOW_QUE_PLACE_ORDER),stepTwoPage.getModalWindowPropertyTextContent(),containsString(DataForTesting.MODAL_WINDOW_QUE_PLACE_ORDER));

        /*Проверка появления модального окна "Заказ оформлен"*/
        stepTwoPage.orderConfirmation();
        MatcherAssert.assertThat(String.format("Отсуствие модального окна '%s'",DataForTesting.MODAL_WINDOW_PLACE_ORDER),stepTwoPage.getModalWindowPropertyTextContent(),containsString(DataForTesting.MODAL_WINDOW_PLACE_ORDER));
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }

}