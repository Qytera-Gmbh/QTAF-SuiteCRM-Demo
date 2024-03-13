package de.qytera.suite_crm.tests;

import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.qtaf.testng.context.QtafTestNGContext;
import de.qytera.qtaf.xray.annotation.XrayTest;
import de.qytera.suite_crm.page_objects.DriverManager;
import org.testng.annotations.BeforeSuite;


@TestFeature(
        name = "Suite Preconditions",
        description = "Prepare test environment"
)
public class BeforeSuiteTest extends QtafTestNGContext {
    @BeforeSuite(groups = {"login"})
    @XrayTest(key = "QTAF-989", scenarioReport = true, screenshots = true)
    public void beforeLogin() {
        DriverManager driverManager = load(DriverManager.class);
        driverManager.resizeBrowser(1051, 900);
    }
}
