package de.qytera.suite_crm.page_objects;

import de.qytera.qtaf.core.QtafFactory;
import de.qytera.qtaf.core.config.entity.ConfigMap;
import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.suite_crm.SuiteCRMTestContext;
import org.openqa.selenium.By;





public class QyteraPO extends SuiteCRMTestContext {
    public static final By solutions = By.id("menu-438-1");

    @Step(
            name = "Go to Qytera main page",
            description = "Navigate to the Qytera home page"
    )
    public void goToRootPage() {
        ConfigMap configMap = QtafFactory.getConfiguration();
        String url = configMap.getString("pageUrl", "https://www.qytera.de");
        System.out.println("Page URL: " + url);
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Step(
            name ="Go to Solutions Page",
            description = "Go to Solutions Page"
    )
    public void goToSolutions(){
        driver.findElement(solutions).isDisplayed();
    }

}
