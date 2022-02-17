package de.qytera.suite_crm.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.qtaf.testng.context.QtafTestNGContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactForm extends QtafTestNGContext {
    @Step(
            name = "Navigate to contact form",
            description = "Navigate to contact form"
    )
    public void navigateToContactForm() {
        driver.navigate().to("https://www.qytera.de/kontakt");
    }

    @Step(
            name = "Enter data",
            description = "Enter contact data into contact form"
    )
    public void enterData(String name, String email, String message) {
        WebElement nameField = driver.findElement(By.id("edit-name"));
        WebElement emailField = driver.findElement(By.id("edit-mail"));
        WebElement subjectField = driver.findElement(By.id("edit-subject"));

        nameField.sendKeys(name);
        emailField.sendKeys(email);
        subjectField.sendKeys(message);
    }

    @Step(
            name = "Enter message",
            description = "Ener message into contact form"
    )
    public void enterMessage(Object dt) {
        WebElement messageField = driver.findElement(By.id("edit-message"));
        messageField.sendKeys(dt.toString());
    }

    @Step(
            name = "Submit form",
            description = "Submit contact form"
    )
    public void submitData() {
        WebElement submitButton = driver.findElement(By.id("edit-submit"));
        submitButton.click();
    }

}
