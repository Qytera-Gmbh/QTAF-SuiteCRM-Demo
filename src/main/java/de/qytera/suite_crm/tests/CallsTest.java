package de.qytera.suite_crm.tests;

import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.suite_crm.TestContext;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.inject.Singleton;

@TestFeature(
        name = "Calls form",
        description = "Create call form"
)
@Singleton
public class CallsTest extends TestContext {
    @Test(testName = "QTAF-567", description = "Calls Test", dependsOnGroups = {"login"})
    public void testCalls() {
        //Navigate to calls page
        topNavbar.openMobileMenu();
        topNavbar.clickMobileCallsMenu();
        callsPage.clickCallsModuleButton();
        topBarCallsMenu.clickLogCallLink();

        // Fill call form
        createCallForm.fillSubjectField("Neuer Anruf");
        createCallForm.fillDurationField();
        createCallForm.fillDescriptionField("Anruf von John Doe");
        createCallPage.clickSaveButton();

        //Navigate to Home page
        topNavbar.openMobileMenu();
        topNavbar.clickHomeMenuFromNotHomePage();
        Assert.assertEquals(2*2, 3);
    }
}
