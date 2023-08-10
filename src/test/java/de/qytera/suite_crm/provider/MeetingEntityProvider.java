package de.qytera.suite_crm.provider;

import de.qytera.suite_crm.entity.MeetingEntity;

public class MeetingEntityProvider {
    public static MeetingEntity[][] getMeetingEntities() {
        return new MeetingEntity[][]{
                new MeetingEntity[]{MeetingEntity.builder().subject("Daily Montag").location("Raum 123").description("Daily für alle Mitarbeiter").build()},
                new MeetingEntity[]{MeetingEntity.builder().subject("Daily Dienstag").location("Raum 124").description("Daily für Entwickler").build()},
                new MeetingEntity[]{MeetingEntity.builder().subject("Daily Mittwoch").location("Raum 125").description("Daily für alle Mitarbeiter").build()},
                new MeetingEntity[]{MeetingEntity.builder().subject("Daily Donnerstag").location("Raum 126").description("Daily für Marketingabteilung").build()},
                new MeetingEntity[]{MeetingEntity.builder().subject("Daily Freitag").location("Raum 127").description("Daily für alle Mitarbeiter").build()},
        };
    }
}
