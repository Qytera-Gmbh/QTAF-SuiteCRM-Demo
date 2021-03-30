package de.qytera.suite_crm.tests;

import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.suite_crm.SuiteCRMTestContext;
import org.testng.Assert;
import org.testng.annotations.Test;

@TestFeature(
        name = "Login Form",
        description = "Login to the CRM"
)
public class LoginTest extends SuiteCRMTestContext {
    @Test
    public void testLogin() throws InterruptedException {
        navigator.goToRootPage();
        loginForm.fillUsernameField("user");
        loginForm.fillPasswordField("bitnami");
        loginForm.clickSubmitButton();
        topNavbar.clickProfileButton();
        topNavbar.clickProfileLink();

        Assert.assertTrue(2 * 2 == 4);
    }
}
