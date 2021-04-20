package de.qytera.suite_crm.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.suite_crm.SuiteCRMTestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



import javax.inject.Singleton;


@Singleton
public class CreateMeetingForm extends SuiteCRMTestContext {
    String subjectInputSelector = "#name";
    String locationInputSelector = "#location";
    String descriptionInputSelector = "#description";

    @Step(name = "Fill subject field", description = "Fill subject field")
    public void fillSubjectField(String value) {
        WebElement nameField = driver.findElement(By.cssSelector(subjectInputSelector));
        nameField.sendKeys(value);
    }

    @Step(name = "Fill location field", description = "Fill location field")
    public void fillLocationField(String value) {
        WebElement nameField = driver.findElement(By.cssSelector(locationInputSelector));
        nameField.sendKeys(value);
    }

    @Step(name = "Fill description field", description = "Fill description field")
    public void fillDescriptionField(String value) {
        WebElement nameField = driver.findElement(By.cssSelector(descriptionInputSelector));
        nameField.sendKeys(value);
    }

    @Step(name = "Fill office phone field", description = "Fill office phone field")
    public void fillOfficePhoneField(String value) {
        WebElement nameField = driver.findElement(By.cssSelector(descriptionInputSelector));
        nameField.sendKeys(value);
    }

}
