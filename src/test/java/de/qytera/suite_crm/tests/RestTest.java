package de.qytera.suite_crm.tests;

import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.qtaf.testng.context.QtafTestNGContext;
import de.qytera.qtaf.xray.annotation.XrayTest;
import de.qytera.suite_crm.reststeps.RestSteps;
import org.testng.annotations.Test;

@TestFeature(name = "API Tests", description = "API Tests")
public class RestTest extends QtafTestNGContext {
    @Test(testName = "API Test", groups = {"rest"})
    @XrayTest(key = "QTAF-1151")
    public void testApi() {
        RestSteps restSteps = load(RestSteps.class);
        restSteps.getSingleTodo(restSteps.getSingleTodoEndpointSpecification());
        restSteps.createTodo(restSteps.getTodoCollectionEndpointSpecification());
        restSteps.updateTodo(restSteps.getSingleTodoEndpointSpecification());
        restSteps.deleteTodo(restSteps.getSingleTodoEndpointSpecification());
    }
}