package de.qytera.suite_crm.tests;

import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.qtaf.xray.annotation.XrayTest;
import de.qytera.suite_crm.TestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.inject.Singleton;

@TestFeature(
        name = "Meetings Form",
        description = "Create meetings form"
)
@Singleton
public class MeetingsTest extends TestContext {
    @DataProvider(name = "meetingsData")
    public Object[][] getCallsData() {
        return new Object[][]{
                {"Daily Montag", "Raum 123", "Daily für alle Mitarbeiter"},
                {"Daily Dienstag", "Raum 102", "Daily für alle Mitarbeiter"},
                {"Daily Mittwoch", "Raum 111", "Daily für alle Mitarbeiter"},
                {"Daily Donnerstag", "Raum 123", "Daily für alle Mitarbeiter"},
                {"Daily Freitag", "Raum 104", "Daily für alle Mitarbeiter"},
                {"Weekly Donnerstag", "Raum 100", "Weekly für alle Mitarbeiter"},
        };
    }

    @Test(testName = "MeetingsTest", description = "Meetings Test", dependsOnGroups = {"login"}, dataProvider = "meetingsData", suiteName = "suite2")
    @XrayTest(key = "QTAF-573")
    public void testMeetings(String subject, String location, String description){
        // Navigate to meetings page
        navigator.goToRootPage();
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
