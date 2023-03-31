package de.qytera.suite_crm.page_objects;

import de.qytera.qtaf.core.QtafFactory;
import de.qytera.qtaf.core.config.entity.ConfigMap;
import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.suite_crm.TestContext;
import io.cucumber.java.de.Wenn;

import javax.inject.Singleton;


@Singleton
public class Navigator extends TestContext {
    @Step(
            name = "Go to SuiteCRM main page",
            description = "Navigate to the SuiteCRM main home page"
    )
    public void goToRootPage() {
        ConfigMap configMap = QtafFactory.getConfiguration();
        String url = configMap.getString("pageUrl", "http://127.0.0.1:80");
        driver.get(url);
    }

}
