package de.qytera.suite_crm.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.qtaf.testng.context.QtafTestNGContext;
import org.openqa.selenium.WebElement;


public class TopBarCallsMenu extends QtafTestNGContext {

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
