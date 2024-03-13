package de.qytera.suite_crm.tests;

import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.qtaf.testng.context.QtafTestNGContext;
import de.qytera.qtaf.xray.annotation.XrayTest;
import de.qytera.suite_crm.entity.MeetingEntity;
import de.qytera.suite_crm.page_objects.*;
import de.qytera.suite_crm.processes.meetings.FillMeetingsFormProcess;
import de.qytera.suite_crm.provider.MeetingEntityProvider;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@TestFeature(
        name = "Meetings Form",
        description = "Create meetings form"
)
public class MeetingsTest extends QtafTestNGContext {
    @DataProvider(name = "meetingsData")
    public Object[][] getCallsData() {
        return MeetingEntityProvider.getMeetingEntities();
    }

    @Test(
            testName = "MeetingsTest",
            description = "Meetings Test",
            groups = {"meetings"},
            dependsOnGroups = {"login"},
            dataProvider = "meetingsData",
            suiteName = "suite2"
    )
    @XrayTest(key = "QTAF-573", scenarioReport = true, screenshots = true)
    public void testMeetings(MeetingEntity meetingEntity){
        // Instantiate page objects
        Navigator navigator = load(Navigator.class);
        TopNavbar topNavbar = load(TopNavbar.class);
        TopBarMenu topBarMenu = load(TopBarMenu.class);
        CalendarPage calendarPage = load(CalendarPage.class);
        FillMeetingsFormProcess fillMeetingsFormProcess = load(FillMeetingsFormProcess.class);
        fillMeetingsFormProcess.setMeetingEntity(meetingEntity);

        // Navigate to meetings page
        navigator.goToRootPage();
        topNavbar.openMobileMenu();
        topNavbar.clickMobileCalendarMenu();
        calendarPage.clickMeetingsModuleButton();
        topBarMenu.clickNthItem(1);

        fillMeetingsFormProcess.execute();

        //Navigate to Home page
        topNavbar.openMobileMenu();
        topNavbar.clickHomeMenuFromNotHomePage();
    }
}
