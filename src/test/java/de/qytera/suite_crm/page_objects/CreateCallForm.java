package de.qytera.suite_crm.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.suite_crm.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class CreateCallForm extends TestContext {

    private String name = "name";
    private String description = "description";
    private String durationMinutes = "duration_minutes";

    @Step(name = "Fill subject field", description = "Fill the subject field")
    public void fillSubjectField(String value) {
        driver.findElement(By.id(name)).click();
        driver.findElement(By.id(name)).sendKeys(value);
    }

    @Step(name = "Fill duration field", description = "Fill the duration field")
    public void fillDurationField() {
        driver.findElement(By.id(durationMinutes)).click();
        WebElement dropdown = driver.findElement(By.id(durationMinutes));
        dropdown.findElement(By.xpath("//option[. = '30']")).click();
    }

    @Step(name = "Fill description field", description = "Fill the description field")
    public void fillDescriptionField(String value) {
        driver.findElement(By.id(description)).click();
        driver.findElement(By.id(description)).sendKeys(value);
    }

}
