package de.qytera.suite_crm.listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.SkipException;

public class TestListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        String groups = System.getProperty("groups");
        System.out.println("GROUPS: " + groups);
        //throw new SkipException("Tests skipped by TestListener");
    }
}
