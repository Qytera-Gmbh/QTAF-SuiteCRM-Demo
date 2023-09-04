package de.qytera.suite_crm.tests;

import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.qtaf.testng.context.QtafTestNGContext;
import de.qytera.qtaf.xray.annotation.XrayTest;
import de.qytera.suite_crm.processes.LoginProcess;
import org.testng.annotations.Test;

@TestFeature(
        name = "Login Form",
        description = "Login to the CRM"
)
public class LoginTest extends QtafTestNGContext {
    @Test(testName = "LoginTest", description = "Login Test", groups = {"login"}, suiteName = "suite1")
    @XrayTest(key = "QTAF-496")
    public void testLogin(){
        load(LoginProcess.class).execute();
    }
}
