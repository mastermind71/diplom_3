package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationPage {
    private WebDriver driver;
    public String name = "Dmitry";
    public String mail = "dmitry.kazakov1998@icloud.com";
    public String password = "123456789";
    public String nonValidePassword = "1234";
    private By buttonLogin = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");
    private By registrationButton = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[1]/a");
    private By fieldName = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    private By fieldEmail = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    private By fieldPassword = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input");
    private By finalRegistrationButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private By fieldEmailForLogin = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    private By fieldPasswordForLogin = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    private By buttonFinalLogin = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");
    private By buttonPersonalAccount = By.xpath("//*[@id=\"root\"]/div/header/nav/a/p");
    private By fieldErrorPassword = By.xpath(".//*[@class='input__error text_type_main-default']");
    private By textInPersonalAccount = By.xpath("//*[@id=\"root\"]/div/main/div/nav/p");
    private By buttonBun = By.xpath(".//span[@class = 'text text_type_main-default' and text()='Булки']/parent::div");
    private By buttonSause = By.xpath(".//span[@class = 'text text_type_main-default' and text()='Соусы']/parent::div");
    private  By buttonFilling = By.xpath(".//span[@class = 'text text_type_main-default' and text()='Начинки']/parent::div");
    private By selectedSection = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span");
public RegistrationPage(WebDriver driver){
    this.driver = driver;
}
public void pushLogin(){
    driver.findElement(buttonLogin).click();
}
public void pushRegistration(){
    driver.findElement(registrationButton).click();
}
public void fillingName(){
    driver.findElement(fieldName).sendKeys(name);
}
public void fillingEmail(){
    driver.findElement(fieldEmail).sendKeys(mail);
}
public void fillingPassword(){
    driver.findElement(fieldPassword).sendKeys(password);
}
public void pushEndRegistration(){
    driver.findElement(finalRegistrationButton).click();
}
public void fillingEmailForLogin(){
    driver.findElement(fieldEmailForLogin).sendKeys(mail);
}
public void fillingPasswordForLogin(){
    driver.findElement(fieldPasswordForLogin).sendKeys(password);
}
public void pushFinalLogin(){
    driver.findElement(buttonFinalLogin).click();
}
public void pushEntryInPersonalAccount(){
    driver.findElement(buttonPersonalAccount).click();
}
public String getUrl(){
            return driver.getCurrentUrl();
}
public void fillingNonValidePassword(){
    driver.findElement(fieldPassword).sendKeys(nonValidePassword);
}
public String getErrorPassword(){
    return driver.findElement(fieldErrorPassword).getText();
}
public String getTextInPersonalAccount(){
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    return driver.findElement(textInPersonalAccount).getText();
}
public void pushBun(){
    driver.findElement(buttonBun).click();
}
public void pushSause(){
    driver.findElement(buttonSause).click();
}
public void pushFilling(){
    driver.findElement(buttonFilling).click();
}
public String getTextSelectSection(){
    return driver.findElement(selectedSection).getText();
}
}
