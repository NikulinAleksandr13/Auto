package RegistrationHeder;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page extends Steps {
    public final WebDriver driver;
    private final Actions actions;
    private final WebDriverWait wait;

    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofMillis(Long.parseLong(Property.getProperty("login.page.time_out"))));

    }
    @FindBy(xpath = "//*[@id=\"tippy-2\"]/div[2]/div[3]/a")
    private WebElement acceptRegion;
    @FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/div/noindex/div/div[4]/a")
    private WebElement HederPopap;

    @FindBy(xpath = "(//input[@id=\"jh_username\"])[last()]")
    private WebElement Email;

    @FindBy(xpath = "(//input[@id=\"jh_password\"])[last()]")
    private WebElement Password;

    @FindBy(xpath = "(//*[@id=\"auth-form\"]/div[3]/button)[last()]")
    private WebElement Enter;


    public String login = "testbc@komus.ru";
    public String password = "Qwerty123";

    public void inputlEmail(){
        Email.sendKeys(login);
    }

    public void inputlPassword(){
        Password.sendKeys(password);}

    public void SendEnter(){
        moveAndClick(actions, Enter);
    }

    public void moveToHeader(){
        move(actions, HederPopap);
    }

    public void acceptEmail() {
        waitElement(wait, Email);
        clickOnButton(Email);
    }
    public boolean isElementPresent(By element) {
        try {
            driver.findElement(element);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
