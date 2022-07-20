package de.qytera.suite_crm;

import de.qytera.qtaf.testng.context.QtafTestNGContext;
import de.qytera.suite_crm.page_objects.*;
import foo.PageObject;

import javax.inject.Inject;

@PageObject
public class SuiteCRMTestContext extends QtafTestNGContext {

    protected Navigator navigator = new Navigator();

    @Inject
    protected LoginFormPO loginForm;

    protected TopNavbar topNavbar = new TopNavbar();

    @Inject
    protected TopBarMenu topBarMenu;

    @Inject
    protected TopBarCallsMenu topBarCallsMenu;

    @Inject
    protected CalendarPage calendarPage;

    @Inject
    protected CreateContactPage createContactPage;

    @Inject
    protected CreateContactForm createContactForm;

    @Inject
    protected CreateMeetingPage createMeetingPage;

    @Inject
    protected CreateMeetingForm createMeetingForm;

    @Inject
    protected CallsPage callsPage;

    @Inject
    protected CreateCallPage createCallPage;

    @Inject
    protected CreateCallForm createCallForm;

    @Inject
    protected TasksPage tasksPage;
}
