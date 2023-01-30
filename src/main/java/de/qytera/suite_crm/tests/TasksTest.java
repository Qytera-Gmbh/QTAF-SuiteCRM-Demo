package de.qytera.suite_crm.tests;

import com.github.javafaker.Faker;
import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.suite_crm.TestContext;
import org.testng.annotations.Test;

import javax.inject.Singleton;

@TestFeature(
        name = "Tasks from ",
        description = "Create tasks form"
)
@Singleton
public class TasksTest extends TestContext {
    Faker faker = new Faker();

    @Test(testName = "QTAF-572", description = "Tasks Test", dependsOnGroups = {"login"})
    public void testTasks() {

        //Navigate to Tasks Create Page
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