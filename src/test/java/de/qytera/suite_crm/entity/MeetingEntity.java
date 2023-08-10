package de.qytera.suite_crm.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MeetingEntity {
    /**
     * Meeting subject
     */
    private String subject;

    /**
     * Meeting location
     */
    private String location;

    /**
     * Meeting description
     */
    private String description;
}
