package de.qytera.suite_crm;

import de.qytera.qtaf.testng.QtafTestNGRunner;

/**
 * Main runner class that runs the test classes.
 * This class inherits from QtafTestNGRunner which provides a main function that can be executed.
 */
public class TestRunner extends QtafTestNGRunner {
    public static void main(String[] args) {
        System.setProperty("config", "de/qytera/suite_crm");
        QtafTestNGRunner.main(args);
    }
}
