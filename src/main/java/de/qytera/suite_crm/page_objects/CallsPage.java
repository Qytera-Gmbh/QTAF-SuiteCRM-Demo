package de.qytera.suite_crm.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.suite_crm.SuiteCRMTestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.inject.Singleton;


@Singleton
public class CallsPage extends SuiteCRMTestContext {
    String moduleButtonSelector = "#moduleTab_Calls";

    @Step(name = "Click calls module button", description = "Click calls module button")
    public void clickCallsModuleButton() {
        WebElement menu = driver.findElement(By.cssSelector(moduleButtonSelector));
        menu.click();
    }

}
