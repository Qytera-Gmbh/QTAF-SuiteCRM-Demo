package de.qytera.suite_crm;

import de.qytera.qtaf.testng.context.QtafTestNGContext;
import de.qytera.suite_crm.page_objects.LoginFormPO;
import de.qytera.suite_crm.page_objects.Navigator;
import de.qytera.suite_crm.page_objects.TopNavbar;

import javax.inject.Inject;

public class SuiteCRMTestContext extends QtafTestNGContext {
    @Inject
    protected Navigator navigator;

    @Inject
    protected LoginFormPO loginForm;

    @Inject
    protected TopNavbar topNavbar;
}
