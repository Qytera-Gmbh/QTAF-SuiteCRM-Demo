package de.qytera.suite_crm.tests;

import com.github.javafaker.Faker;
import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.qtaf.xray.annotation.XrayTest;
import de.qytera.suite_crm.TestContext;
import org.testng.annotations.*;

import javax.inject.Singleton;

@TestFeature(
        name = "Calls form",
        description = "Create call form"
)
@Singleton
public class CallsTest extends TestContext {
    Faker faker = new Faker();

    @DataProvider(name = "callsData")
    public Object[][] getCallsData() {
        return new Object[][]{
                {"Daily", "Daily conference"},
                {"Weekly", "Weekly conference"},
                {"Meeting John Doe", "Meeting with John Doe"},
                {"Meeting Jane Doe", "Meeting with Jane Doe"},
        };
    }

    @BeforeMethod(description = "Navigate to the calls form")
    @XrayTest(key = "QTAF-993")
    public void beforeCallsTest() {
        //Navigate to calls page
        navigator.goToRootPage();
        topNavbar.openMobileMenu();
        topNavbar.clickMobileCallsMenu();
        callsPage.clickCallsModuleButton();
        topBarCallsMenu.clickLogCallLink();
    }

    @Test(testName = "CallsTest", description = "Calls Test", dependsOnGroups = {"login"}, dataProvider = "callsData", suiteName = "suite2")
    @XrayTest(key = "QTAF-567")
    public void testCalls(String subject, String description) {
        // Fill call form
        createCallForm.fillSubjectField(subject);
        createCallForm.fillDurationField();
        createCallForm.fillDescriptionField(description);
        createCallPage.clickSaveButton();
    }

    @AfterMethod(description = "Navigate to the home page")
    @XrayTest(key = "QTAF-994")
    public void afterCallsTest() {
        //Navigate to Home page
        topNavbar.openMobileMenu();
        topNavbar.clickHomeMenuFromNotHomePage();
    }
}



