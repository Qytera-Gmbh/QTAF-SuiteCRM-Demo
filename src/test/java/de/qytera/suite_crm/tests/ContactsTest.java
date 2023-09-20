package de.qytera.suite_crm.tests;

import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.qtaf.testng.context.QtafTestNGContext;
import de.qytera.qtaf.xray.annotation.XrayTest;
import de.qytera.suite_crm.entity.ContactEntity;
import de.qytera.suite_crm.page_objects.*;
import de.qytera.suite_crm.processes.contacts.FillContactFormProcess;
import de.qytera.suite_crm.provider.ContactEntityProvider;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@TestFeature(
        name = "Contacts form",
        description = "Create contact form"
)
public class ContactsTest extends QtafTestNGContext {
    @DataProvider(name = "contactsData")
    public Object[][] contactsData() {
        return ContactEntityProvider.getContactEntities();
    }

    @Test(
            testName = "ContactsTest",
            description = "Contacts Test",
            groups = {"contacts"},
            dependsOnGroups = {"login"},
            dataProvider = "contactsData",
            suiteName = "suite2"
    )
    @XrayTest(key = "QTAF-568")
    public void testContacts(ContactEntity contactEntity) {
        // Instantiate page objects
        Navigator navigator = load(Navigator.class);
        TopNavbar topNavbar = load(TopNavbar.class);
        TopBarMenu topBarMenu = load(TopBarMenu.class);
        CreateContactPage createContactPage = load(CreateContactPage.class);
        FillContactFormProcess fillContactFormProcess = load(FillContactFormProcess.class);
        fillContactFormProcess.setContactEntity(contactEntity);

        // Navigate to Contacts Create page
        navigator.goToRootPage();
        topNavbar.openMobileMenu();
        topNavbar.clickMobileContactsMenu();
        createContactPage.clickContactModuleButton();
        topBarMenu.clickCreateLink();

        fillContactFormProcess.execute();

        // Navigate to calls page
        topNavbar.openMobileMenu();
        topNavbar.clickHomeMenuFromNotHomePage();
    }

}