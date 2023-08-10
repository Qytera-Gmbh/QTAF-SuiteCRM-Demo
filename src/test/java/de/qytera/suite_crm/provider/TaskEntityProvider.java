package de.qytera.suite_crm.provider;

import com.github.javafaker.Faker;
import de.qytera.suite_crm.entity.TaskEntity;

public class TaskEntityProvider {
    public static TaskEntity[][] getTaskEntities() {
        Faker faker = new Faker();
        return new TaskEntity[][] {
                new TaskEntity[]{TaskEntity.builder().subject(faker.name().title()).contactName("John Doe").description(faker.name().title()).build()},
                new TaskEntity[]{TaskEntity.builder().subject(faker.name().title()).contactName("Jane Doe").description(faker.name().title()).build()},
                new TaskEntity[]{TaskEntity.builder().subject(faker.name().title()).contactName("William Smith").description(faker.name().title()).build()},
        };
    }
}
