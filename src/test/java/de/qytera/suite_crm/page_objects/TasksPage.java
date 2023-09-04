package de.qytera.suite_crm.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.qtaf.testng.context.QtafTestNGContext;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TasksPage extends QtafTestNGContext {
    String tasksButtonSelector = "moduleTab_Tasks";
    String saveButtonSelector = "SAVE";
    String subjectSelector = "name";
    String contactNameSelector = "contact_name";
    String descriptionSelector = "description";



    @Step(name = "Click tasks button", description = "Click tasks button")
    @When("Ich klicke in der Task-Ansicht auf den Modul-Button")
    public void clickTasksModuleButton() {
        WebElement menu = driver.findElement(By.id(tasksButtonSelector));
        menu.click();
    }

    @Step(name ="Fill subject name", description = "Fill subject name")
    @When("Ich gebe in der Task-Ansicht ein Betreff ein")
    public void fillSubjectName(String value) {
        WebElement nameField = driver.findElement(By.id(subjectSelector));
        nameField.sendKeys(value);
    }

    @Step(name = "Fill contact name", description = "Fill contact name")
    @When("Ich gebe in der Task-Ansicht einen Namen für den Kontakt ein")
    public void fillContactName(String value) {
        WebElement nameField = driver.findElement(By.id(contactNameSelector));
        nameField.sendKeys(value);
    }

    @Step(name = "Fill description", description = "Fill description")
    @When("Ich gebe in der Task-Ansicht eine Beschreibung für den neuen Kontakt ein")
    public void fillDescription(String value) {
        WebElement descriptionField = driver.findElement(By.id(descriptionSelector));
        descriptionField.sendKeys(value);
    }

    @Step(name="Save task", description = "Save task")
    @When("Ich klicke in der Task-Ansicht auf den Button 'Speichern'")
    public void clickSaveButton() {
        WebElement saveButton = driver.findElement(By.id(saveButtonSelector));
        saveButton.click();
    }

}