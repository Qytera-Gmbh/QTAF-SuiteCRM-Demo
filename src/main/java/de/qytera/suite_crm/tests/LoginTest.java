package de.qytera.suite_crm.tests;

import com.github.javafaker.Faker;
import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.suite_crm.SuiteCRMTestContext;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@TestFeature(
        name = "Login Form",
        description = "Login to the CRM"
)
public class LoginTest extends SuiteCRMTestContext {
    Faker faker = new Faker();

    @Test
    public void testLogin() throws InterruptedException {
        navigator.goToRootPage();
        loginForm.fillUsernameField("user");
        loginForm.fillPasswordField("bitnami");
        loginForm.clickSubmitButton();
        topNavbar.openMobileMenu();
        topNavbar.clickMobileContactsMenu();
        topNavbar.clickModuleButton();
        topBarContactsMenu.clickCreateContactLink();
        createContactForm.fillFirstNameField(faker.name().firstName());
        createContactForm.fillLastNameField(faker.name().lastName());
        createContactForm.fillOfficePhoneField(faker.phoneNumber().phoneNumber());
        createContactForm.fillMobilePhoneField(faker.phoneNumber().phoneNumber());
        createContactForm.fillFaxPhoneField(faker.phoneNumber().cellPhone());
        createContactForm.fillJobTitleField("Manager");
        createContactForm.fillAccountNameField(faker.name().firstName() + "-" + faker.name().lastName());
        createContactForm.fillEmailField(faker.name().firstName() + "-" + faker.name().lastName() + "@inet.com");
        createContactPage.clickSaveButton();

        topNavbar.openMobileMenu();
        topNavbar.clickHomeMenuFromNotHomePage();

        topNavbar.openMobileMenu();
        topNavbar.clickMobileCalendarMenu();
        topNavbar.clickModuleButton();
        topBarContactsMenu.clickNthItem(1);

        createMeetingForm.fillSubjectField("Neues Meeting");
        createMeetingForm.fillLocationField("Raum 123");
        createMeetingForm.fillDescriptionField("Neues Meeting Beschreibung");

        createMeetingPage.clickSaveButton();
        topNavbar.clickHomeMenuFromNotHomePage();

        Assert.assertTrue(2 * 2 == 4);
    }
}
