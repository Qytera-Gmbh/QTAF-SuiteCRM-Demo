package de.qytera.suite_crm.tests;

import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.qtaf.testng.context.QtafTestNGContext;
import de.qytera.qtaf.xray.annotation.XrayTest;
import de.qytera.suite_crm.entity.CallEntity;
import de.qytera.suite_crm.page_objects.*;
import de.qytera.suite_crm.processes.calls.FillCallFormProcess;
import de.qytera.suite_crm.provider.CallEntityProvider;
import org.testng.annotations.*;


@TestFeature(
        name = "Calls form",
        description = "Create call form"
)
public class CallsTest extends QtafTestNGContext {
    @DataProvider(name = "callsData")
    public CallEntity[][] getCallsData() {
        return CallEntityProvider.getCallEntities();
    }

    @BeforeMethod(description = "Navigate to the calls form")
    @XrayTest(key = "QTAF-993", scenarioReport = true, screenshots = true)
    public void beforeCallsTest() {
        // Instantiate page objects
        Navigator navigator = load(Navigator.class);
        TopNavbar topNavbar = load(TopNavbar.class);
        TopBarCallsMenu topBarCallsMenu = load(TopBarCallsMenu.class);
        CallsPage callsPage = load(CallsPage.class);

        // Actions
        navigator.goToRootPage();
        topNavbar.openMobileMenu();
        topNavbar.clickMobileCallsMenu();
        callsPage.clickCallsModuleButton();
        topBarCallsMenu.clickLogCallLink();
    }

    @Test(
            testName = "CallsTest",
            description = "Calls Test",
            groups = {"calls"},
            dependsOnGroups = {"login"},
            dataProvider = "callsData",
            suiteName = "suite2"
    )
    @XrayTest(key = "QTAF-567", scenarioReport = true, screenshots = true)
    public void testCalls(CallEntity callEntity) {
        FillCallFormProcess fillCallFormProcess = load(FillCallFormProcess.class);
        fillCallFormProcess.setCallEntity(callEntity);
        fillCallFormProcess.execute();
    }

    @AfterMethod(description = "Navigate to the home page")
    @XrayTest(key = "QTAF-994", scenarioReport = true, screenshots = true)
    public void afterCallsTest() {
        // Instantiate page objects
        TopNavbar topNavbar = load(TopNavbar.class);

        //Navigate to Home page
        topNavbar.openMobileMenu();
        topNavbar.clickHomeMenuFromNotHomePage();
    }
}



