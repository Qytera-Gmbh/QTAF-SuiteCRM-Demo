package de.qytera.suite_crm.provider;

import com.github.javafaker.Faker;
import de.qytera.suite_crm.entity.ContactEntity;

public class ContactEntityProvider {
    public static ContactEntity[][] getContactEntities() {
        Faker faker = new Faker();
        int n = 5;
        ContactEntity[][] data = new ContactEntity[n][1];

        for (int i = 0; i < n; i++) {
            ContactEntity contactEntity = ContactEntity.builder()
                    .firstName(faker.name().firstName())
                    .lastName(faker.name().lastName())
                    .phoneNumber(faker.phoneNumber().phoneNumber())
                    .cellPhoneNumber(faker.phoneNumber().cellPhone())
                    .build();
            data[i] = new ContactEntity[]{contactEntity};
        }

        return data;

    }
}
