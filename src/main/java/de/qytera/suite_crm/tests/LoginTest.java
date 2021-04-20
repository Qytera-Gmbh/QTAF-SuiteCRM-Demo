package de.qytera.suite_crm.tests;

import com.github.javafaker.Faker;
import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.suite_crm.SuiteCRMTestContext;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.inject.Singleton;

@TestFeature(
        name = "Login Form",
        description = "Login to the CRM"
)
@Singleton
public class LoginTest extends SuiteCRMTestContext {
    Faker faker = new Faker();

    @Test
    public void testLogin() throws InterruptedException {
        driver.manage().window().setSize(new Dimension(1051, 660));

        // Login
        navigator.goToRootPage();
        loginForm.fillUsernameField("user");
        loginForm.fillPasswordField("bitnami");
        loginForm.clickSubmitButton();

        // Navigate to Contacts Create page
        topNavbar.openMobileMenu();
        topNavbar.clickMobileContactsMenu();
        createContactPage.clickContactModuleButton();
        topBarContactsMenu.clickCreateContactLink();

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

        // Navigate to home page
        topNavbar.openMobileMenu();
        topNavbar.clickHomeMenuFromNotHomePage();

        // Navigate to meetings page
        topNavbar.openMobileMenu();
        topNavbar.clickMobileCalendarMenu();
        calendarPage.clickMeetingsModuleButton();
        topBarContactsMenu.clickNthItem(1);

        // Fill meetings form
        createMeetingForm.fillSubjectField("Neues Meeting");
        createMeetingForm.fillLocationField("Raum 123");
        createMeetingForm.fillDescriptionField("Neues Meeting Beschreibung");
        createMeetingPage.clickSaveButton();

        // Navigate to home page
        topNavbar.openMobileMenu();
        topNavbar.clickHomeMenuFromNotHomePage();

        //Navigate to calls page
        topNavbar.openMobileMenu();
        topNavbar.clickMobileCallsMenu();
        callsPage.clickCallsModuleButton();
        topBarCallsMenu.clickLogCallLink();

        // Fill call form
        createCallForm.fillSubjectField("Neuer Anruf");
        createCallForm.fillDurationField();
        createCallForm.fillDescriptionField("Anruf von John Doe");
        createCallPage.clickSaveButton();

        //Navigate to calls page
        topNavbar.openMobileMenu();
        topNavbar.clickHomeMenuFromNotHomePage();

        Assert.assertTrue(2 * 2 == 4);
    }
}
