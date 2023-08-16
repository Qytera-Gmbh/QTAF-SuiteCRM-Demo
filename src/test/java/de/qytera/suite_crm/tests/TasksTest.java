package de.qytera.suite_crm.tests;

import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.qtaf.xray.annotation.XrayTest;
import de.qytera.suite_crm.TestContext;
import de.qytera.suite_crm.entity.TaskEntity;
import de.qytera.suite_crm.page_objects.Navigator;
import de.qytera.suite_crm.page_objects.TasksPage;
import de.qytera.suite_crm.page_objects.TopBarMenu;
import de.qytera.suite_crm.page_objects.TopNavbar;
import de.qytera.suite_crm.processes.tasks.FillTaskFormProcess;
import de.qytera.suite_crm.provider.TaskEntityProvider;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@TestFeature(
        name = "Tasks from ",
        description = "Create tasks form"
)
public class TasksTest extends TestContext {
    @DataProvider(name = "tasksData")
    public Object[][] tasksData() {
        return TaskEntityProvider.getTaskEntities();
    }

    @Test(testName = "TasksTest", description = "Tasks Test", dependsOnGroups = {"login"}, dataProvider = "tasksData", suiteName = "suite2")
    @XrayTest(key = "QTAF-572")
    public void testTasks(TaskEntity taskEntity) {
        // Instantiate page objects
        Navigator navigator = load(Navigator.class);
        TopNavbar topNavbar = load(TopNavbar.class);
        TopBarMenu topBarMenu = load(TopBarMenu.class);
        TasksPage tasksPage = load(TasksPage.class);
        FillTaskFormProcess fillTaskFormProcess = load(FillTaskFormProcess.class);
        fillTaskFormProcess.setTaskEntity(taskEntity);

        //Navigate to Tasks Create Page
        navigator.goToRootPage();
        topNavbar.openMobileMenu();
        topNavbar.clickMobileTasksMenu();
        tasksPage.clickTasksModuleButton();
        topBarMenu.clickCreateLink();

        //Create a Task
        fillTaskFormProcess.execute();

        //Navigate to Home Page
        topNavbar.openMobileMenu();
        topNavbar.clickHomeMenuFromNotHomePage();

    }
}