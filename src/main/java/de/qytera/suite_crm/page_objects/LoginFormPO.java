package de.qytera.suite_crm.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.suite_crm.TestContext;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;



import javax.inject.Singleton;


@Singleton
public class LoginFormPO extends TestContext {
    protected String usernameFieldId = "user_name";
    protected String passwordFieldId = "input#username_password";
    protected String loginButtonId = "input#bigbutton";
    protected String languageSelectionName = "input#bigbutton";

    @Step(name = "Fill username field", description = "Fill the username field")
    @When("Ich gebe den Usernamen {} ein")
    public void fillUsernameField(String username) {
        driver.findElement(By.id(usernameFieldId)).sendKeys(username);
    }

    @Step(name = "Fill password field", description = "Fill the password field")
    @When("Ich gebe das Passwort {} ein")
    public void fillPasswordField(String password) {
        driver.findElement(By.cssSelector(passwordFieldId)).sendKeys(password);
    }

    @Step(name = "Submit Form", description = "Submit the login form")
    @When("Ich klicke auf den Login-Button")
    public void clickSubmitButton() {
        driver.findElement(By.cssSelector(loginButtonId)).click();
    }
}
