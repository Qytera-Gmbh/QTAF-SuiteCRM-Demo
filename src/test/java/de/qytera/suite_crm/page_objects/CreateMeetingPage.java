package de.qytera.suite_crm.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.suite_crm.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class CreateMeetingPage extends TestContext {
    String saveButtonSelector = "#SAVE_HEADER";
    String cancelButtonSelector = "#CANCEL";

    @Step(name = "Click save button", description = "Click save button")
    public void clickSaveButton() {
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(saveButtonSelector)));
        //WebElement menu = driver.findElement(By.cssSelector(saveButtonSelector));
        //menu.click();
        WebElement webElement = driver.findElement(By.cssSelector(saveButtonSelector));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
    }

    @Step(name = "Click cancel button", description = "Click cancel button")
    public void clickCancelButton() {
        WebElement menu = driver.findElement(By.cssSelector(cancelButtonSelector));
        menu.click();
    }
}
