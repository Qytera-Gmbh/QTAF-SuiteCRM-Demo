package de.qytera.suite_crm.tests;

import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.qtaf.xray.annotation.XrayTest;
import de.qytera.suite_crm.TestContext;
import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import javax.inject.Singleton;

@TestFeature(
        name = "Login Form",
        description = "Login to the CRM"
)
@Singleton
public class LoginTest extends TestContext {
    @Test(testName = "LoginTest", description = "Login Test", groups = {"login"}, suiteName = "suite1")
    @XrayTest(key = "QTAF-496")
    public void testLogin(){
        navigator.goToRootPage();
        loginForm.fillUsernameField("user");
        loginForm.fillPasswordField("bitnami");
        loginForm.clickSubmitButton();
    }
}
