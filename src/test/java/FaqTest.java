import POM.FaqPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.firefox.GeckoDriverService;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FaqTest {
    WebDriver driver;
    private final String que;
    private final String answer;
    private final int position;

    public FaqTest(int position, String que, String answer) {

        this.que = que;
        this.answer = answer;
        this.position = position;
    }

    @Before
    public void startUp() {

        /*Выбор браузера*/

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();

    }
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {1, "Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {2, "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {3, "Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {4, "Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {5, "Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {6, "Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {7, "Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {8, "Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    /*Проверка на соответсвие ответа к вопросу. Также, проверяется клик по вопросу.*/
    @Test
    public void faqTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        FaqPage faqPage = new FaqPage(driver);
        faqPage.waitLoadFaq();
        faqPage.closeCookie();
        faqPage.scrollToFaq();
        assertEquals(String.format("Ошибка в вопросе №%d",position),que,faqPage.clickButtonQue(position));
        assertEquals(String.format("Ответ не соответствует вопросу №%d",position),answer,faqPage.getTextAnswerAfterClick());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}