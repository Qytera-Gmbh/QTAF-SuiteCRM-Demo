package de.qytera.suite_crm.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.qtaf.testng.context.QtafTestNGContext;
import org.openqa.selenium.Dimension;


public class DriverManager extends QtafTestNGContext {
    @Step(name = "resize_browser", description = "Set the width and the height of the browser")
    public void resizeBrowser(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }
}
