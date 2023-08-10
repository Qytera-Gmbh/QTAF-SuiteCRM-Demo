package de.qytera.suite_crm.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskEntity {
    /**
     * Task subject
     */
    private String subject;
    /**
     * Task contact name
     */
    private String contactName;
    /**
     * Task description
     */
    private String description;
}
