package de.qytera.suite_crm.tests;

import com.github.javafaker.Faker;
import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.qtaf.xray.annotation.XrayTest;
import de.qytera.suite_crm.TestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@TestFeature(
        name = "Contacts form",
        description = "Create contact form"
)
@Singleton
public class ContactsTest extends TestContext {
    Faker faker = new Faker();

    @DataProvider(name = "contactsData")
    public Object[][] contactsData() {
        int n = 5;
        Object[][] data = new Object[n][4];

        for (int i = 0; i < n; i++) {
            Object[] obj = new Object[] {
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.phoneNumber().phoneNumber(),
                    faker.phoneNumber().cellPhone(),
            };
            data[i] = obj;
        }

        return data;
    }

    @Test(testName = "ContactsTest", description = "Contacts Test", dependsOnGroups = {"login"}, dataProvider = "contactsData")
    @XrayTest(key = "QTAF-568")
    public void testContacts(
            String firstName,
            String lastName,
            String phoneNumber,
            String cellPhoneNumber
    ) {
        // Navigate to Contacts Create page
        navigator.goToRootPage();
        topNavbar.openMobileMenu();
        topNavbar.clickMobileContactsMenu();
        createContactPage.clickContactModuleButton();
        topBarMenu.clickCreateLink();

        // Fill contact form
        createContactForm.fillFirstNameField(firstName);
        createContactForm.fillLastNameField(lastName);
        createContactForm.fillOfficePhoneField(phoneNumber);
        createContactForm.fillMobilePhoneField(phoneNumber);
        createContactForm.fillFaxPhoneField(cellPhoneNumber);
        createContactForm.fillJobTitleField("Manager");
        createContactForm.fillAccountNameField(firstName + "-" + lastName);
        createContactForm.fillEmailField(firstName + "-" + lastName + "@inet.com");
        createContactPage.clickSaveButton();

        // Navigate to calls page
        topNavbar.openMobileMenu();
        topNavbar.clickHomeMenuFromNotHomePage();
    }

}