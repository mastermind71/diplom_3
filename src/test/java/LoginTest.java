import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.api.UserApi;

public class LoginTest {
    private WebDriver driver;
    private String accessToken;
    @Before
    public void createUserAndSetUp(){
        UserApi.createCourier("Dmitry", "dmitry.kazakov1998@icloud.com", "123456789");
        System.setProperty("webdriver.chrome.driver", "/users/anastasia/downloads/WebDriver/bin/chromedriver");
        driver = new ChromeDriver();// драйвер для браузера Chrome
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
    public void loginOnMainPage(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.pushLogin();
        loginPage.fillingEmail();
        loginPage.fillingPassword();
        loginPage.pushFinalLogin();
        String actualText = loginPage.getOrderButton();
        Assert.assertEquals("Оформить заказ", actualText);
    }
    @Test
    public void loginThrowButtonPersonalAccount(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.pushButtonPersonalAccount();
        loginPage.fillingEmail();
        loginPage.fillingPassword();
        loginPage.pushFinalLogin();
        String actualText = loginPage.getOrderButton();
        Assert.assertEquals("Оформить заказ", actualText);
    }
    @Test
    public void loginThrowRegistration(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.pushLogin();
        loginPage.pushRegistrationButton();
        loginPage.pushLoginButton();
        loginPage.fillingEmail();
        loginPage.fillingPassword();
        loginPage.pushFinalLogin();
        String actualText = loginPage.getOrderButton();
        Assert.assertEquals("Оформить заказ", actualText);
    }
    @Test
    public void loginThrowRecoveryPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.pushLogin();
        loginPage.pushButtonRecoveryPassword();
        loginPage.pushLoginOnRecoveryPasswordPage();
        loginPage.fillingEmail();
        loginPage.fillingPassword();
        loginPage.pushFinalLogin();
        String actualText = loginPage.getOrderButton();
        Assert.assertEquals("Оформить заказ", actualText);
    }
}
