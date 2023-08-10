package de.qytera.suite_crm.processes.meetings;

import de.qytera.suite_crm.TestContext;
import de.qytera.suite_crm.entity.MeetingEntity;
import de.qytera.suite_crm.page_objects.CreateMeetingForm;
import de.qytera.suite_crm.page_objects.CreateMeetingPage;
import de.qytera.suite_crm.patterns.Command;
import lombok.Data;

@Data
public class FillMeetingsFormProcess extends TestContext implements Command {
    /**
     * Data that will be used to fill meeting entities
     */
    MeetingEntity meetingEntity;

    /**
     * Fill the meeting form
     */
    @Override
    public void execute() {
        // Instantiate page objects
        CreateMeetingPage createMeetingPage = load(CreateMeetingPage.class);
        CreateMeetingForm createMeetingForm = load(CreateMeetingForm.class);

        // Fill meetings form
        createMeetingForm.fillSubjectField(meetingEntity.getSubject());
        createMeetingForm.fillLocationField(meetingEntity.getLocation());
        createMeetingForm.fillDescriptionField(meetingEntity.getDescription());
        createMeetingPage.clickSaveButton();
    }
}
