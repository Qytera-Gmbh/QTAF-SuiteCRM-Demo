package de.qytera.suite_crm.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.suite_crm.TestContext;
import org.openqa.selenium.WebElement;



import javax.inject.Singleton;


@Singleton
public class TopBarCallsMenu extends TestContext {

    @Step(name = "Click n-th ite", description = "Click n-th item of menu")
    private void clickNthItem(int n) {
        TopNavbar topNavbar = load(TopNavbar.class);
        WebElement we = topNavbar.getModuleLinks().get(n -1);
        we.click();
    }

    @Step(name = "Click log call menu item", description = "Click log call menu item")
    public void clickLogCallLink() {
        this.clickNthItem(1);
    }
}
