package de.qytera.suite_crm.processes.contacts;

import de.qytera.qtaf.testng.context.QtafTestNGContext;
import de.qytera.suite_crm.entity.ContactEntity;
import de.qytera.suite_crm.page_objects.CreateContactForm;
import de.qytera.suite_crm.page_objects.CreateContactPage;
import de.qytera.suite_crm.patterns.Command;
import lombok.Data;

/**
 * Fill the contact form
 */
@Data
public class FillContactFormProcess extends QtafTestNGContext implements Command {
    /**
     * The data that will be used to fill the contact form
     */
    private ContactEntity contactEntity;

    @Override
    public void execute() {
        // Instantiate page objects
        CreateContactPage createContactPage = load(CreateContactPage.class);
        CreateContactForm createContactForm = load(CreateContactForm.class);

        // Fill contact form
        createContactForm.fillFirstNameField(contactEntity.getFirstName());
        createContactForm.fillLastNameField(contactEntity.getLastName());
        createContactForm.fillOfficePhoneField(contactEntity.getPhoneNumber());
        createContactForm.fillMobilePhoneField(contactEntity.getCellPhoneNumber());
        createContactForm.fillFaxPhoneField(contactEntity.getCellPhoneNumber());
        createContactForm.fillJobTitleField("Manager");
        createContactForm.fillAccountNameField(String.format("%s-&s", contactEntity.getFirstName(), contactEntity.getLastName()));
        createContactForm.fillEmailField(String.format("%s-&s@inet.com", contactEntity.getFirstName(), contactEntity.getLastName()));
        createContactPage.clickSaveButton();
    }
}
