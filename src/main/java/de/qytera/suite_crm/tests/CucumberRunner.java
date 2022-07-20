package de.qytera.suite_crm.tests;

import de.qytera.qtaf.cucumber.context.QtafTestNGCucumberContext;
import de.qytera.qtaf.cucumber.entity.QTAFCucumberScenarioEntity;
import de.qytera.qtaf.cucumber.entity.QTAFCucumberScenarioEntityFactory;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.Test;

/**
 * Main class to execute Cucumber Tests
 */
@CucumberOptions(
        features = {"src/main/resources/features"}, // Pfad zu den Feature-Files
        glue = {"de.qytera.suite_crm.page_objects"},        // Java-Paket, in dem die Steps definiert sind
        plugin = {"pretty"},
        tags = ""
)
public class CucumberRunner extends QtafTestNGCucumberContext {
    @Test(
            groups = {"cucumber"},
            description = "Runs Cucumber Scenarios",
            dataProvider = "scenarios"
    )
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        QTAFCucumberScenarioEntity scenarioEntity = QTAFCucumberScenarioEntityFactory.getEntity(pickleWrapper, featureWrapper);
        this.onBeforeScenario(scenarioEntity);
        super.runScenario(pickleWrapper, featureWrapper);
    }
}
