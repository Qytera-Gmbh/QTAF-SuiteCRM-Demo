package de.qytera.suite_crm;

import de.qytera.qtaf.testng.QtafTestNGRunner;
import de.qytera.qtaf.testng.event_listener.TestNGEventListener;
import de.qytera.qtaf.testng.test_factory.TestNGFactory;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.util.Collections;

/**
 * Main runner class that runs the test classes.
 * This class inherits from QtafTestNGRunner which provides a main function that can be executed.
 */
public class TestRunner extends QtafTestNGRunner {

    @Test
    public void run(){
        TestNG testNG = new TestNG();
        testNG.setListenerClasses(Collections.singletonList(TestNGEventListener.class));
        testNG.setTestClasses(new Class[]{TestNGFactory.class});
        testNG.run();
    }
}
