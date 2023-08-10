package de.qytera.suite_crm.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CallEntity {
    /**
     * Call subject
     */
    private String subject;

    /**
     * Call description
     */
    private String description;
}
