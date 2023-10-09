package de.qytera.suite_crm.driver;

import de.qytera.qtaf.core.selenium.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Create a new driver factory
 */
public class MyChrome extends ChromeDriver {
    /**
     * The name of the browser that you use in the qtaf.json file or in the argument -Ddriver.name
     * @return  driver name
     */
    public String getName() {
        return "my-chrome";
    }

    /**
     * Set the capabilities of the browser
     * @return capabilities
     */
    protected ChromeOptions getCapabilities() {
        ChromeOptions options = super.getCapabilities();
        options.setCapability("download.default_directory", "C:\\Users\\John\\Downloads");

        return options;
    }
}
