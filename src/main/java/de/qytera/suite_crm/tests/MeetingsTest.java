package de.qytera.suite_crm.tests;

import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.suite_crm.SuiteCRMTestContext;
import org.testng.annotations.Test;

import javax.inject.Singleton;

@TestFeature(
        name = "Meetings Form",
        description = "Create meetings form"
)
@Singleton
public class MeetingsTest extends SuiteCRMTestContext {
    @Test(testName = "QTAF-573", description = "Meetings Test", dependsOnGroups = {"login"})
    public void testMeetings(){
        // Navigate to meetings page
        topNavbar.openMobileMenu();
        topNavbar.clickMobileCalendarMenu();
        calendarPage.clickMeetingsModuleButton();
        topBarMenu.clickNthItem(1);

        // Fill meetings form
        createMeetingForm.fillSubjectField("Neues Meeting");
        createMeetingForm.fillLocationField("Raum 123");
        createMeetingForm.fillDescriptionField("Neues Meeting Beschreibung");
        createMeetingPage.clickSaveButton();

        //Navigate to Home page
        topNavbar.openMobileMenu();
        topNavbar.clickHomeMenuFromNotHomePage();

    }
}
