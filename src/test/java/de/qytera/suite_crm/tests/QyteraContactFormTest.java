package de.qytera.suite_crm.tests;

import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.suite_crm.SuiteCRMTestContext;
import org.testng.annotations.Test;

@TestFeature(
        name = "FillQyteraForm",
        description = "Fill Qytera contact form"
)
public class QyteraContactFormTest extends SuiteCRMTestContext {
    @Test(
            testName = "QTAF-1",
            description = "Fill Qytera contact form",
            groups = {"Group 1", "Group 2"}
    )
    public void TestContactForm() {
        contactForm.navigateToContactForm();
        contactForm.enterData("Jane Doe", "jane.doe@inet.com", "Testnachricht");
        contactForm.enterMessage("Das ist eine Testnacricht");
        contactForm.submitData();
    }
}
