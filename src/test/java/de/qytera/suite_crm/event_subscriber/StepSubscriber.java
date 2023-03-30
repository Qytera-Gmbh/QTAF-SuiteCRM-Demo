package de.qytera.suite_crm.event_subscriber;

import com.google.gson.Gson;
import de.qytera.qtaf.core.events.QtafEvents;
import de.qytera.qtaf.core.events.interfaces.IEventSubscriber;
import de.qytera.qtaf.core.events.payload.IQtafTestingContext;
import de.qytera.qtaf.core.gson.GsonFactory;
import de.qytera.qtaf.core.gson.GsonHelper;
import de.qytera.qtaf.core.guice.invokation.StepExecutionInfo;
import de.qytera.qtaf.core.io.DirectoryHelper;

import java.util.ArrayList;

public class StepSubscriber implements IEventSubscriber {
    private static ArrayList<StepEntity> stepEntities = new ArrayList<>();

    @Override
    public void initialize() {
        QtafEvents.beforeStepExecution.subscribe(this::onStep);
        QtafEvents.finishedTesting.subscribe(this::onTestingFinished);
    }

    public void onStep(StepExecutionInfo step) {
        StepEntity stepEntity = new StepEntity();
        stepEntity
                .setThreadId(step.getThread().getId())
                .setThreadName(step.getThread().getName())
                .setStackTraceElements(step.getStackTraceElements());

        stepEntities.add(stepEntity);
    }

    public void onTestingFinished(IQtafTestingContext testingContext) {
        try {
            System.out.println("PATH: " + DirectoryHelper.preparePath("$USER_DIR/logs/steps.json"));
            GsonHelper.saveJsonFile(stepEntities, "$USER_DIR/logs/steps.json");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class StepEntity {
    private long threadId;
    private String threadName = "";
    private StackTraceElement[] stackTraceElements;

    /**
     * Get threadId
     *
     * @return threadId
     */
    public long getThreadId() {
        return threadId;
    }

    /**
     * Set threadId
     *
     * @param threadId ThreadId
     * @return this
     */
    public StepEntity setThreadId(long threadId) {
        this.threadId = threadId;
        return this;
    }

    /**
     * Get methodName
     *
     * @return methodName
     */
    public String getThreadName() {
        return threadName;
    }

    /**
     * Set methodName
     *
     * @param threadName MethodName
     * @return this
     */
    public StepEntity setThreadName(String threadName) {
        this.threadName = threadName;
        return this;
    }

    /**
     * Get stackTraceElements
     *
     * @return stackTraceElements
     */
    public StackTraceElement[] getStackTraceElements() {
        return stackTraceElements;
    }

    /**
     * Set stackTraceElements
     *
     * @param stackTraceElements StackTraceElements
     * @return this
     */
    public StepEntity setStackTraceElements(StackTraceElement[] stackTraceElements) {
        this.stackTraceElements = stackTraceElements;
        return this;
    }
}
