package de.qytera.suite_crm.page_objects;

import de.qytera.suite_crm.SuiteCRMTestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



import javax.inject.Singleton;


@Singleton
public class CreateCallForm extends SuiteCRMTestContext {

    private String name = "name";
    private String description = "description";
    private String durationMinutes = "duration_minutes";

    public void fillSubjectField(String value) {
        driver.findElement(By.id(name)).click();
        driver.findElement(By.id(name)).sendKeys(value);
    }

    public void fillDurationField() {
        driver.findElement(By.id(durationMinutes)).click();
        WebElement dropdown = driver.findElement(By.id(durationMinutes));
        dropdown.findElement(By.xpath("//option[. = '30']")).click();
    }

    public void fillDescriptionField(String value) {
        driver.findElement(By.id(description)).click();
        driver.findElement(By.id(description)).sendKeys(value);
    }

}
