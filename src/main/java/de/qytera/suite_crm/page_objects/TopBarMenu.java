package de.qytera.suite_crm.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.suite_crm.TestContext;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;



import javax.inject.Singleton;


@Singleton
public class TopBarMenu extends TestContext {

    @Step(name = "Click n-th item", description = "Click n-th item of the menu")
    public void clickNthItem(int n) {
        WebElement we = topNavbar.getModuleLinks().get(n -1);
        we.click();
    }

    @Step(name = "Click create contact menu item", description = "Click create contact menu item")
    @When("Ich klicke in der Topbar auf 'Erstelle Link'")
    public void clickCreateLink() {
        WebElement we = topNavbar.getModuleLinks().get(0);
        we.click();
    }

    @Step(name = "Click view contacts menu item", description = "Click view contacts menu item")
    public void clickViewLink() {
        WebElement we = topNavbar.getModuleLinks().get(2);
        we.click();
    }
}
