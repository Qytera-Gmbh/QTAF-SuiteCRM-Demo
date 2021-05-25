package de.qytera.suite_crm.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.suite_crm.SuiteCRMTestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TasksPage extends SuiteCRMTestContext {
    String tasksButtonSelector = "moduleTab_Tasks";
    String saveButtonSelector = "SAVE";
    String subjectSelector = "name";
    String contactNameSelector = "contact_name";
    String descriptionSelector = "description";



    @Step(name = "Click tasks button", description = "Click tasks button")
    public void clickTasksModuleButton() {
        WebElement menu = driver.findElement(By.id(tasksButtonSelector));
        menu.click();
    }

    @Step(name ="Fill subject name", description = "Fill subject name")
    public void fillSubjectName(String value) {
        WebElement nameField = driver.findElement(By.id(subjectSelector));
        nameField.sendKeys(value);
    }

    @Step(name = "Fill contact name", description = "Fill contact name")
    public void fillContactName(String value) {
        WebElement nameField = driver.findElement(By.id(contactNameSelector));
        nameField.sendKeys(value);
    }

    @Step(name = "Fill description", description = "Fill description")
    public void fillDescription(String value) {
        WebElement descriptionField = driver.findElement(By.id(descriptionSelector));
        descriptionField.sendKeys(value);
    }

    @Step(name="Save task", description = "Save task")
    public void clickSaveButton() {
        WebElement saveButton = driver.findElement(By.id(saveButtonSelector));
        saveButton.click();
    }

}