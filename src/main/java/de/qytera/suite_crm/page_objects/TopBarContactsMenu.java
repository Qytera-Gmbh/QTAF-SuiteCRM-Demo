package de.qytera.suite_crm.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.suite_crm.SuiteCRMTestContext;
import org.openqa.selenium.WebElement;



import javax.inject.Singleton;


@Singleton
public class TopBarContactsMenu extends SuiteCRMTestContext {

    public void clickNthItem(int n) {
        WebElement we = topNavbar.getModuleLinks().get(n -1);
        we.click();
    }

    @Step(name = "Click create contact menu item", description = "Click create contact menu item")
    public void clickCreateContactLink() {
        WebElement we = topNavbar.getModuleLinks().get(0);
        we.click();
    }

    @Step(name = "Click view contacts menu item", description = "Click view contacts menu item")
    public void clickViewContactsLink() {
        WebElement we = topNavbar.getModuleLinks().get(2);
        we.click();
    }
}
