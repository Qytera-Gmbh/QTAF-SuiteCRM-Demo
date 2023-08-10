package de.qytera.suite_crm.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactEntity {
    /**
     * First name
     */
    private String firstName;

    /**
     * Last name
     */
    private String lastName;

    /**
     * Phone number
     */
    private String phoneNumber;

    /**
     * Cell phone number
     */
    private String cellPhoneNumber;
}
