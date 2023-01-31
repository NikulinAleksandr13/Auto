package RegistrationHeder;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Steps {

    public void waitElement(WebDriverWait wait, WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));}



    public void moveAndClick(Actions action, WebElement element) {
        action.moveToElement(element)
                .click()
                .build()
                .perform();
    }
    public void move(Actions action, WebElement element) {
        action.moveToElement(element)
                .perform();
}
    public void clickOnButton(WebElement element) {
        element.click();
    }

}
