package de.qytera.suite_crm.tests;

import com.github.javafaker.Faker;
import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.suite_crm.SuiteCRMTestContext;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.inject.Singleton;

@TestFeature(
        name = "Login Form",
        description = "Login to the CRM"
)
@Singleton
public class LoginTest extends SuiteCRMTestContext {

    @Test(testName = "QTAF-496", description = "Login Test", groups = {"login"})
    public void testLogin(){
        driver.manage().window().setSize(new Dimension(1051, 900));

        // Login
        navigator.goToRootPage();
        loginForm.fillUsernameField("user");
        loginForm.fillPasswordField("bitnami");
        loginForm.clickSubmitButton();
    }
}
