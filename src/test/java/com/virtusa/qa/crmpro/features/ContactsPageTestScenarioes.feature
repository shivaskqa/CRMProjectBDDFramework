@contactstest
Feature: Validating Contacts feature in Home Page

  Scenario: Save details in New Contact Page
    Given  that user is in Home Page and hover on Contacts Tab and click on New Contact Link
    When user enters following details in New Contct Page
    |Mr.|Ishaan|Konduru|
    Then details should be Saved successfully