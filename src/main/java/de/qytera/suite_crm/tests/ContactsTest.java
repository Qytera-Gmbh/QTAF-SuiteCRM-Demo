package de.qytera.suite_crm.tests;

import com.github.javafaker.Faker;
import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.suite_crm.SuiteCRMTestContext;
import org.testng.annotations.Test;

import javax.inject.Singleton;

@TestFeature(
        name = "Contacts form",
        description = "Create contact form"
)
@Singleton
public class ContactsTest extends SuiteCRMTestContext {
    Faker faker = new Faker();

    @Test(testName = "Contacts Test", description = "Contacts Test", dependsOnGroups = {"login"})
    public void testContacts() throws InterruptedException {

        // Navigate to Contacts Create page
        topNavbar.openMobileMenu();
        topNavbar.clickMobileContactsMenu();
        createContactPage.clickContactModuleButton();
        topBarMenu.clickCreateLink();

        // Fill contact form
        createContactForm.fillFirstNameField(faker.name().firstName());
        createContactForm.fillLastNameField(faker.name().lastName());
        createContactForm.fillOfficePhoneField(faker.phoneNumber().phoneNumber());
        createContactForm.fillMobilePhoneField(faker.phoneNumber().phoneNumber());
        createContactForm.fillFaxPhoneField(faker.phoneNumber().cellPhone());
        createContactForm.fillJobTitleField("Manager");
        createContactForm.fillAccountNameField(faker.name().firstName() + "-" + faker.name().lastName());
        createContactForm.fillEmailField(faker.name().firstName() + "-" + faker.name().lastName() + "@inet.com");
        createContactPage.clickSaveButton();

        //Navigate to calls page
        topNavbar.openMobileMenu();
        topNavbar.clickHomeMenuFromNotHomePage();
    }

}