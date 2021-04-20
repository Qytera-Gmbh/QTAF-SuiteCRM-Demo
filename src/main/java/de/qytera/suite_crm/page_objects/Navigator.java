package de.qytera.suite_crm.page_objects;

import de.qytera.qtaf.core.QtafFactory;
import de.qytera.qtaf.core.config.entity.ConfigMap;
import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.suite_crm.SuiteCRMTestContext;

import javax.inject.Singleton;


import javax.inject.Singleton;


@Singleton
public class Navigator extends SuiteCRMTestContext {
    @Step(
            name = "Go to SuiteCRM main page",
            description = "Navigate to the SuiteCRM main home page"
    )
    public void goToRootPage() {
        ConfigMap configMap = QtafFactory.getConfiguration();
        String url = configMap.getString("pageUrl", "http://127.0.0.1:8080");
        System.out.println("Page URL: " + url);
        driver.get(url);
    }

}
