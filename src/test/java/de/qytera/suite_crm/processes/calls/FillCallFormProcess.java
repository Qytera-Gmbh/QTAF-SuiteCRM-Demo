package de.qytera.suite_crm.processes.calls;

import de.qytera.suite_crm.TestContext;
import de.qytera.suite_crm.entity.CallEntity;
import de.qytera.suite_crm.page_objects.CreateCallForm;
import de.qytera.suite_crm.page_objects.CreateCallPage;
import de.qytera.suite_crm.patterns.Command;
import lombok.Data;

@Data
public class FillCallFormProcess extends TestContext implements Command {
    /**
     * The data that will be used to fill the form
     */
    private CallEntity callEntity;

    @Override
    public void execute() {
        // Instantiate page objects
        CreateCallForm createCallForm = load(CreateCallForm.class);
        CreateCallPage createCallPage = load(CreateCallPage.class);

        // Fill call form
        createCallForm.fillSubjectField(callEntity.getSubject());
        createCallForm.fillDurationField();
        createCallForm.fillDescriptionField(callEntity.getDescription());
        createCallPage.clickSaveButton();
    }
}
