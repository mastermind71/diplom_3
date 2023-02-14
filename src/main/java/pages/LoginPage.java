package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    private WebDriver driver;
    public String mail = "dmitry.kazakov1998@icloud.com";
    public String password = "123456789";
    private By buttonLogin = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");
    private By fieldEmailForLogin = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    private By fieldPasswordForLogin = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    private By buttonFinalLogin = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");
    private By orderButton = By.xpath(".//button[text()='Оформить заказ']");
    private By buttonPersonalAccount = By.xpath("//*[@id=\"root\"]/div/header/nav/a/p");
    private By registrationButton = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[1]/a");
    private By loginFromRegistrationPage = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a");
    private By recoveryPasswordButton = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[2]/a");
    private By loginOnRecoveryPasswordPage = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a");
    private By buttonStellarBurger = By.xpath("//*[@class='AppHeader_header__logo__2D0X2']");
    private By buttonConstructor = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p");
    private By logoutButton = By.xpath(".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive' and text()='Выход']");
     public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void pushLogin(){
        driver.findElement(buttonLogin).click();
    }
    public void fillingEmail(){
        driver.findElement(fieldEmailForLogin).sendKeys(mail);
    }
    public void fillingPassword(){
        driver.findElement(fieldPasswordForLogin).sendKeys(password);
    }
    public void pushFinalLogin(){
        driver.findElement(buttonFinalLogin).click();
    }
    public String getOrderButton(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver.findElement(orderButton).getText();
    }
    public void pushButtonPersonalAccount(){
        driver.findElement(buttonPersonalAccount).click();
    }
    public void pushRegistrationButton(){
        driver.findElement(registrationButton).click();
    }
    public void pushLoginButton(){
        driver.findElement(loginFromRegistrationPage).click();
    }
    public void pushButtonRecoveryPassword(){
         driver.findElement(recoveryPasswordButton).click();
    }
    public void pushLoginOnRecoveryPasswordPage(){
         driver.findElement(loginOnRecoveryPasswordPage).click();
    }
    public void pushStellarBurger(){
         driver.findElement(buttonStellarBurger).click();
    }
    public void pushConstructor(){
         driver.findElement(buttonConstructor).click();
    }
    public void pushLogoutButton(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         driver.findElement(logoutButton).click();
    }
    public String getTextFinalLogin(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         return driver.findElement(buttonFinalLogin).getText();
    }
}
