package de.qytera.suite_crm.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.suite_crm.TestContext;
import org.openqa.selenium.Dimension;

import javax.inject.Singleton;

@Singleton
public class DriverManager extends TestContext {
    @Step(name = "resize_browser", description = "Set the width and the height of the browser")
    public void resizeBrowser(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }
}
