Feature: Login test
  Background:
    Given Ich navigiere zur Startseite

  @TestName:QTAF-496
  Scenario: Login
    When Ich gebe den Usernamen user ein
    And Ich gebe das Passwort bitnami ein
    And Ich klicke auf den Login-Button

  Scenario: Ich erstelle einen Task
    When Ich öffne das Menü
    And Ich klicke im Menü auf Tasks
    And Ich klicke in der Task-Ansicht auf den Modul-Button
    And Ich klicke in der Topbar auf 'Erstelle Link'
    And Ich gebe in der Task-Ansicht ein Betreff ein
    And Ich gebe in der Task-Ansicht einen Namen für den Kontakt ein
    And Ich gebe in der Task-Ansicht eine Beschreibung für den neuen Kontakt ein
    And Ich klicke in der Task-Ansicht auf den Button 'Speichern'
    And Ich öffne das Menü
    And Ich navigiere zurück zur Startseite
