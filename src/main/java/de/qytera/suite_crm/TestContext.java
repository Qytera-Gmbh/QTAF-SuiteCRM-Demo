package de.qytera.suite_crm;

import de.qytera.qtaf.testng.context.QtafTestNGContext;
import de.qytera.suite_crm.page_objects.*;
import foo.PageObject;

import javax.inject.Inject;

@PageObject
public class TestContext extends QtafTestNGContext {

    @Inject
    protected Navigator navigator;

    @Inject
    protected LoginFormPO loginForm;

    @Inject
    protected TopNavbar topNavbar;

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
