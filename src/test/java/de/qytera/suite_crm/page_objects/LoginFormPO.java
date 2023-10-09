package de.qytera.suite_crm.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.qtaf.testng.context.QtafTestNGContext;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;

import static com.codeborne.selenide.Selenide.$;


/**
 * Login form page object
 */
public class LoginFormPO extends QtafTestNGContext {
    protected By usernameFieldSelector = By.id("user_name");
    protected By passwordFieldSelector = By.cssSelector("input#username_password");
    protected By loginButtonSelector = By.cssSelector("input#bigbutton");

    @Step(name = "Fill username field", description = "Fill the username field")
    public void fillUsernameField(String username) {
        $(usernameFieldSelector).type(username);
        String actualValue = $(usernameFieldSelector).val();
        assertEquals(
                actualValue,
                username,
                "Expected value of username field to be '%s' and it was '%s'".formatted(username, actualValue)
        );
        throw new InvalidArgumentException("This is an invalid argument");
    }

    @Step(name = "Fill password field", description = "Fill the password field")
    public void fillPasswordField(String password) {
        $(passwordFieldSelector).type(password);
        String actualValue = $(passwordFieldSelector).val();
        assertEquals(
                actualValue,
                password,
                "Expected value of password field to be '%s' and it was '%s'".formatted(password, actualValue)
        );
    }

    @Step(name = "Submit Form", description = "Submit the login form")
    public void clickSubmitButton() {
        driver.findElement(loginButtonSelector).click();
    }
}
