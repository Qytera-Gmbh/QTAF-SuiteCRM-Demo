package de.qytera.suite_crm.processes;

import de.qytera.qtaf.testng.context.QtafTestNGContext;
import de.qytera.suite_crm.entity.LoginCredentials;
import de.qytera.suite_crm.page_objects.LoginFormPO;
import de.qytera.suite_crm.page_objects.Navigator;
import de.qytera.suite_crm.patterns.Command;

/**
 * Login process
 */
public class LoginProcess extends QtafTestNGContext implements Command {
    /**
     * Visit login form and enter credentials. Then click on submit button.
     */
    public void execute() {
        Navigator navigator = load(Navigator.class);
        LoginFormPO loginForm = load(LoginFormPO.class);
        LoginCredentials loginCredentials = LoginCredentials.defaultUser();

        navigator.goToRootPage();
        loginForm.fillUsernameField(loginCredentials.getUsername());
        loginForm.fillPasswordField(loginCredentials.getPassword());
        loginForm.clickSubmitButton();
    }
}
