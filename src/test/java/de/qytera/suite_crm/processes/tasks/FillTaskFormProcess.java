package de.qytera.suite_crm.processes.tasks;

import de.qytera.qtaf.testng.context.QtafTestNGContext;
import de.qytera.suite_crm.entity.TaskEntity;
import de.qytera.suite_crm.page_objects.TasksPage;
import de.qytera.suite_crm.patterns.Command;
import lombok.Data;

@Data
public class FillTaskFormProcess extends QtafTestNGContext implements Command {
    /**
     * Data that will be used to fill the form
     */
    private TaskEntity taskEntity;
    @Override
    public void execute() {
        TasksPage tasksPage = load(TasksPage.class);

        //Create a Task
        tasksPage.fillSubjectName(taskEntity.getSubject());
        tasksPage.fillContactName(taskEntity.getContactName());
        tasksPage.fillDescription(taskEntity.getDescription());
        tasksPage.clickSaveButton();
    }
}
