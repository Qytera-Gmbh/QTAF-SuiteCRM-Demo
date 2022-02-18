package de.qytera.suite_crm.tests;

import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.suite_crm.SuiteCRMTestContext;
import org.testng.annotations.Test;

import javax.inject.Singleton;

@TestFeature(
        name = "Calls form",
        description = "Create call form"
)
@Singleton
public class QyteraTest extends SuiteCRMTestContext {
    @Test(testName = "QTAF-754", description = "Calls Test")
    public void testCalls() {
        //Navigate to calls page
        qyteraPO.goToRootPage();
        qyteraPO.goToSolutions();
    }
}
