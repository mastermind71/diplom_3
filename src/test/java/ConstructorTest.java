import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import pages.RegistrationPage;

public class ConstructorTest {
    private WebDriver driver;

    @Test
    public void bunTest() {
        System.setProperty("webdriver.chrome.driver","/users/anastasia/downloads/WebDriver/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/users/anastasia/Applications/Yandex Browser");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.pushFilling();
        registrationPage.pushBun();
        String expectedClass = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
        String actualClass = registrationPage.getClassBun();
        Assert.assertEquals(expectedClass, actualClass);
    }
    @Test
    public void sauseTest() {
        System.setProperty("webdriver.chrome.driver","/users/anastasia/downloads/WebDriver/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/users/anastasia/Applications/Yandex Browser");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.pushFilling();
        registrationPage.pushSause();
        String expectedClass = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
        String actualClass = registrationPage.getClassSause();
        Assert.assertEquals(expectedClass, actualClass);
    }
    @Test
    public void fillingTest() {
        System.setProperty("webdriver.chrome.driver","/users/anastasia/downloads/WebDriver/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/users/anastasia/Applications/Yandex Browser");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.pushSause();
        registrationPage.pushFilling();
        String expectedClass = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
        String actualClass = registrationPage.getClassFilling();
        Assert.assertEquals(expectedClass, actualClass);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
