package de.qytera.suite_crm.provider;

import de.qytera.suite_crm.entity.CallEntity;

public class CallEntityProvider {
    /**
     * Get a list of call entities
     * @return list
     */
    public static CallEntity[][] getCallEntities() {
        return new CallEntity[][]{
                new CallEntity[]{CallEntity.builder().subject("Daily").description("Daily conference").build()},
                new CallEntity[]{CallEntity.builder().subject("Weekly").description("Weekly conference").build()},
                new CallEntity[]{CallEntity.builder().subject("Meeting John Doe").description("Meeting with John Doe").build()},
                new CallEntity[]{CallEntity.builder().subject("Meeting Jane Doe").description("Meeting with Jane Doe").build()},
        };
    }
}
