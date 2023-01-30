package de.qytera.suite_crm.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.suite_crm.TestContext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.inject.Singleton;


@Singleton
public class CalendarPage extends TestContext {
    String moduleButtonSelector = "#moduleTab_Calendar";

    @Step(name = "Click contact module button", description = "Click contact module button")
    public void clickMeetingsModuleButton() {
        WebElement menu = driver.findElement(By.cssSelector(moduleButtonSelector));
        menu.click();
    }

}
