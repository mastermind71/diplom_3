import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import pages.RegistrationPage;

public class ConstructorTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/users/anastasia/downloads/WebDriver/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/users/anastasia/Applications/Yandex Browser");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Test
    public void bunTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.pushFilling();
        registrationPage.pushBun();
        String expectedText = "Булки";
        String actualText = registrationPage.getTextSelectSection();
        Assert.assertEquals("Переход на раздел булки не осуществлен",expectedText, actualText);
    }
    @Test
    public void sauseTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.pushSause();
        String expectedText = "Соусы";
        String actualText = registrationPage.getTextSelectSection();
        Assert.assertEquals("Переход на раздел соусы не осуществлен",expectedText, actualText);
    }
    @Test
    public void fillingTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.pushFilling();
        String expectedText = "Начинки";
        String actualText = registrationPage.getTextSelectSection();
        Assert.assertEquals("Переход на раздел начинки не осуществлен",expectedText, actualText);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
