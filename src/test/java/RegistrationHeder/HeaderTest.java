package RegistrationHeder;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class HeaderTest {
    public static Page page;

    public static WebDriver driver;

    @BeforeAll
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", Property.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        page = new Page(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //получение ссылки на страницу входа из файла настроек
        driver.get(Property.getProperty("loginpages"));
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Test
    public void headerTest() {
        page.moveToHeader();
        page.acceptEmail();
        page.inputlEmail();
        page.inputlPassword();
        page.SendEnter();
        assertTrue(page.isElementPresent(By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div[4]/main/div/div[2]/h4[1]")));

    }
    @AfterAll
 public static void shotDown(){
      driver.close();
  }
}