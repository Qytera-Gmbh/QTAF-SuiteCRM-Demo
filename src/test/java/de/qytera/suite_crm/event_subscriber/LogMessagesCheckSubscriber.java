package de.qytera.suite_crm.event_subscriber;

import de.qytera.qtaf.core.QtafFactory;
import de.qytera.qtaf.core.events.QtafEvents;
import de.qytera.qtaf.core.events.interfaces.IEventSubscriber;
import de.qytera.qtaf.core.events.payload.IQtafTestingContext;
import de.qytera.qtaf.core.log.model.collection.TestFeatureLogCollection;
import de.qytera.qtaf.core.log.model.collection.TestScenarioLogCollection;
import de.qytera.qtaf.core.log.model.collection.TestSuiteLogCollection;
import de.qytera.qtaf.core.log.model.message.LogMessage;

public class LogMessagesCheckSubscriber implements IEventSubscriber {
    @Override
    public void initialize() {
        QtafEvents.finishedTesting.subscribe(this::onFinished);
    }

    public void onFinished(IQtafTestingContext context) {
        System.out.println("Checking Log Messages ...");
        TestSuiteLogCollection logCollection = QtafFactory.getTestSuiteLogCollection();

        for (TestFeatureLogCollection feature : logCollection.getTestFeatureLogCollections()) {
            for (TestScenarioLogCollection scenario : feature.getScenarioLogCollection()) {
                for (LogMessage logMessage : scenario.getLogMessages()) {
                    if (logMessage.getStart() == null) {
                        System.out.println("LOG_ERROR: Missing start date");
                        System.out.println("LOG_MESSAGE: " + logMessage.getMessage());
                    }

                    if (logMessage.getEnd() == null) {
                        System.out.println("LOG_ERROR: Missing end date");
                        System.out.println("LOG_MESSAGE: " + logMessage.getMessage());
                    }
                }
            }
        }
        System.out.println("Finished checking log messages");
    }
}
