package de.qytera.suite_crm.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.suite_crm.TestContext;
import org.openqa.selenium.By;


/**
 * Login form page object
 */
public class LoginFormPO extends TestContext {
    protected By usernameFieldSelector = By.id("user_name");
    protected By passwordFieldSelector = By.cssSelector("input#username_password");
    protected By loginButtonSelector = By.cssSelector("input#bigbutton");

    @Step(name = "Fill username field", description = "Fill the username field")
    public void fillUsernameField(String username) {
        driver.findElement(usernameFieldSelector).sendKeys(username);
    }

    @Step(name = "Fill password field", description = "Fill the password field")
    public void fillPasswordField(String password) {
        driver.findElement(passwordFieldSelector).sendKeys(password);
    }

    @Step(name = "Submit Form", description = "Submit the login form")
    public void clickSubmitButton() {
        driver.findElement(loginButtonSelector).click();
    }
}
