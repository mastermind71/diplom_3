import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegistrationPage;
import pages.api.UserApi;

public class Registration {
    private WebDriver driver;
    private String accessToken;
    String expectedUrl = "https://stellarburgers.nomoreparties.site/account";

    @Test
    public void Registration() {
        System.setProperty("webdriver.chrome.driver", "/users/anastasia/downloads/WebDriver/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.pushLogin();
        registrationPage.pushRegistration();
        registrationPage.fillingName();
        registrationPage.fillingEmail();
        registrationPage.fillingPassword();
        registrationPage.pushEndRegistration();
        registrationPage.pushEntryInPersonalAccount();
        registrationPage.fillingEmailForLogin();
        registrationPage.fillingPasswordForLogin();
        registrationPage.pushFinalLogin();
        registrationPage.pushEntryInPersonalAccount();
        String actualUrl = registrationPage.getUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
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
    public void registrationWithNonValidePassword() {
        System.setProperty("webdriver.chrome.driver", "/users/anastasia/downloads/WebDriver/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.pushLogin();
        registrationPage.pushRegistration();
        registrationPage.fillingName();
        registrationPage.fillingEmail();
        registrationPage.fillingNonValidePassword();
        registrationPage.pushEndRegistration();
        String actualError = registrationPage.getErrorPassword();
        Assert.assertEquals("Некорректный пароль", actualError);
    }
}
