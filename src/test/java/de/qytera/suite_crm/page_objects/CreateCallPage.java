package de.qytera.suite_crm.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.qtaf.testng.context.QtafTestNGContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class CreateCallPage extends QtafTestNGContext {
    String saveButtonSelector = "#SAVE_HEADER";
    String cancelButtonSelector = "#CANCEL";

    @Step(name = "Click save button", description = "Click save button")
    public void clickSaveButton() {
        WebElement menu = driver.findElement(By.cssSelector(saveButtonSelector));
        menu.click();
    }

    @Step(name = "Click cancel button", description = "Click cancel button")
    public void clickCancelButton() {
        WebElement menu = driver.findElement(By.cssSelector(cancelButtonSelector));
        menu.click();
    }

}
