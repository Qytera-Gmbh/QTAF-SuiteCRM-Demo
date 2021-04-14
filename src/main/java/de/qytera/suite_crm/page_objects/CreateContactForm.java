package de.qytera.suite_crm.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.suite_crm.SuiteCRMTestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class CreateContactForm extends SuiteCRMTestContext {
    Random random = new Random();

    String firstNameInputSelector = "#first_name";
    String lastNameInputSelector = "#last_name";
    String phoneWorkInputSelector = "#phone_work";
    String phoneMobileInputSelector = "#phone_mobile";
    String phoneFaxInputSelector = "#phone_fax";
    String jobTitleInputSelector = "#title";
    String departmentInputSelector = "#department";
    String accountNameInputSelector = "#account_name";
    String emailInputSelector = "#Contacts0emailAddress0";

    @Step(name = "Fill first name field", description = "Fill first name field")
    public void fillFirstNameField(String value) {
        WebElement nameField = driver.findElement(By.cssSelector(firstNameInputSelector));
        nameField.sendKeys(value);
    }

    @Step(name = "Fill last name field", description = "Fill last name field")
    public void fillLastNameField(String value) {
        WebElement nameField = driver.findElement(By.cssSelector(lastNameInputSelector));
        nameField.sendKeys(value);
    }

    @Step(name = "Fill office phone field", description = "Fill office phone field")
    public void fillOfficePhoneField(String value) {
        WebElement nameField = driver.findElement(By.cssSelector(phoneWorkInputSelector));
        nameField.sendKeys(value);
    }

    @Step(name = "Fill mobile phone field", description = "Fill mobile phone field")
    public void fillMobilePhoneField(String value) {
        WebElement nameField = driver.findElement(By.cssSelector(phoneMobileInputSelector));
        nameField.sendKeys(value);
    }

    @Step(name = "Fill fax phone field", description = "Fill fax phone field")
    public void fillFaxPhoneField(String value) {
        WebElement nameField = driver.findElement(By.cssSelector(phoneFaxInputSelector));
        nameField.sendKeys(value);
    }

    @Step(name = "Fill job title field", description = "Fill job title field")
    public void fillJobTitleField(String value) {
        WebElement nameField = driver.findElement(By.cssSelector(jobTitleInputSelector));
        nameField.sendKeys(value);
    }

    @Step(name = "Fill department field", description = "Fill department field")
    public void fillDepartmentField(String value) {
        WebElement nameField = driver.findElement(By.cssSelector(departmentInputSelector));
        nameField.sendKeys(value);
    }

    @Step(name = "Fill account name field", description = "Fill account name field")
    public void fillAccountNameField(String value) {
        WebElement nameField = driver.findElement(By.cssSelector(accountNameInputSelector));
        nameField.sendKeys(value + "-" + random.nextInt());
    }

    @Step(name = "Fill email field", description = "Fill email field")
    public void fillEmailField(String value) {
        Random random = new Random();
        WebElement nameField = driver.findElement(By.cssSelector(emailInputSelector));
        nameField.sendKeys(random.nextInt() + "." + value);
    }
}
