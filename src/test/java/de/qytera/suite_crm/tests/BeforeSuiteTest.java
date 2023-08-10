package de.qytera.suite_crm.tests;

import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.qtaf.xray.annotation.XrayTest;
import de.qytera.suite_crm.TestContext;
import de.qytera.suite_crm.page_objects.DriverManager;
import org.testng.annotations.BeforeSuite;

import javax.inject.Singleton;

@TestFeature(
        name = "Suite Preconditions",
        description = "Prepare test environment"
)
@Singleton
public class BeforeSuiteTest extends TestContext {
    @BeforeSuite(groups = {"login"})
    @XrayTest(key = "QTAF-989")
    public void beforeLogin() {
        DriverManager driverManager = load(DriverManager.class);
        driverManager.resizeBrowser(1051, 900);
    }
}
