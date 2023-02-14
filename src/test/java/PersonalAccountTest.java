import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.RegistrationPage;
import pages.api.UserApi;

public class PersonalAccountTest {
    private WebDriver driver;
    private String accessToken;
    @Before
    public void createUser(){
        UserApi.createCourier("Dmitry", "dmitry.kazakov1998@icloud.com", "123456789");
        System.setProperty("webdriver.chrome.driver", "/users/anastasia/downloads/WebDriver/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
    }
    @After
    public void deleteUser(){
        Response response = UserApi.loginUser("dmitry.kazakov1998@icloud.com", "123456789");
        if (response.statusCode() != 200) {
            return;
        }
        accessToken = response.then().extract().path("accessToken").toString();
        UserApi.deleteUser(accessToken);
        driver.quit();
    }
    @Test
    public void openPersonalAccount(){
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        loginPage.pushLogin();
        loginPage.fillingEmail();
        loginPage.fillingPassword();
        loginPage.pushFinalLogin();
        registrationPage.pushEntryInPersonalAccount();
        String actual = registrationPage.getTextInPersonalAccount();
        Assert.assertEquals("В этом разделе вы можете изменить свои персональные данные", actual);
    }
    @Test
    public void openMainPageFromButtonStellarBurger(){
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        loginPage.pushLogin();
        loginPage.fillingEmail();
        loginPage.fillingPassword();
        loginPage.pushFinalLogin();
        registrationPage.pushEntryInPersonalAccount();
        loginPage.pushStellarBurger();
        String actual = loginPage.getOrderButton();
        Assert.assertEquals("Оформить заказ", actual);
    }
    @Test
    public void openMainPageFromButtonConstructor(){
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        loginPage.pushLogin();
        loginPage.fillingEmail();
        loginPage.fillingPassword();
        loginPage.pushFinalLogin();
        registrationPage.pushEntryInPersonalAccount();
        loginPage.pushConstructor();
        String actual = loginPage.getOrderButton();
        Assert.assertEquals("Оформить заказ", actual);
    }
    @Test
    public void logoutTest(){
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        loginPage.pushLogin();
        loginPage.fillingEmail();
        loginPage.fillingPassword();
        loginPage.pushFinalLogin();
        registrationPage.pushEntryInPersonalAccount();
        loginPage.pushLogoutButton();
        String actualTextButton = loginPage.getTextFinalLogin();
        Assert.assertEquals("Войти", actualTextButton);
    }
}
