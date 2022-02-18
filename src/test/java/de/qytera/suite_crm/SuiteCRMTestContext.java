package de.qytera.suite_crm;

import de.qytera.qtaf.testng.context.QtafTestNGContext;
import de.qytera.suite_crm.page_objects.*;
import foo.PageObject;

import javax.inject.Inject;

@PageObject
public class SuiteCRMTestContext extends QtafTestNGContext {


    @Inject
    protected QyteraPO qyteraPO;
}
