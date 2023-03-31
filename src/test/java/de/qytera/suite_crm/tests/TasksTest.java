package de.qytera.suite_crm.tests;

import com.github.javafaker.Faker;
import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.qtaf.xray.annotation.XrayTest;
import de.qytera.suite_crm.TestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.inject.Singleton;

@TestFeature(
        name = "Tasks from ",
        description = "Create tasks form"
)
@Singleton
public class TasksTest extends TestContext {
    Faker faker = new Faker();

    @DataProvider(name = "tasksData")
    public Object[][] tasksData() {
        return new Object[][] {
                { faker.name().title(), "John Doe", faker.name().title() },
                { faker.name().title(), "Jane Doe", faker.name().title() },
                { faker.name().title(), "William Smith", faker.name().title() },
        };
    }

    @Test(testName = "TasksTest", description = "Tasks Test", dependsOnGroups = {"login"}, dataProvider = "tasksData", suiteName = "suite2")
    @XrayTest(key = "QTAF-572")
    public void testTasks(String subject, String contactName, String description) {
        //Navigate to Tasks Create Page
        navigator.goToRootPage();
        topNavbar.openMobileMenu();
        topNavbar.clickMobileTasksMenu();
        tasksPage.clickTasksModuleButton();
        topBarMenu.clickCreateLink();

        //Create a Tasks Page
        tasksPage.fillSubjectName(faker.name().title());
        tasksPage.fillContactName(faker.name().fullName());
        tasksPage.fillDescription(faker.name().title());
        tasksPage.clickSaveButton();

        //Navigate to Home Page
        topNavbar.openMobileMenu();
        topNavbar.clickHomeMenuFromNotHomePage();

    }
}