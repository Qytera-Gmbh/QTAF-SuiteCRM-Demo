package de.qytera.suite_crm.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.suite_crm.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class CreateContactPage extends TestContext {
    String moduleButtonSelector = "#moduleTab_Contacts";
    String saveButtonSelector = "#SAVE";
    String cancelButtonSelector = "#CANCEL";

    @Step(name = "Click contact module button", description = "Click contact module button")
    public void clickContactModuleButton() {
        WebElement menu = driver.findElement(By.cssSelector(moduleButtonSelector));
        menu.click();
    }

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
