Feature: Files and folders listing and sorting

  Background:
    Given I am logged in

  Scenario: Sorting the files by default sort
    Given I am on the files page
    When I am on the default sort
    Then the files are sorted by name ascending

  Scenario: Sorting the files by name ascending
    Given I am on the files page
    When I sort by name ascending
    Then the files are sorted by name ascending

  Scenario: Sorting the files by name descending
    Given I am on the files page
    When I sort by name descending
    Then the files are sorted by name descending

  Scenario: Sorting the files by description ascending
    Given I am on the files page
    When I sort by description ascending
    Then the files are sorted by description ascending

  Scenario: Sorting the files by description descending
    Given I am on the files page
    When I sort by description descending
    Then the files are sorted by description descending

  Scenario: Sorting the files by last modified ascending
    Given I am on the files page
    When I sort by last modified ascending
    Then the files are sorted by last modified ascending

  Scenario: Sorting the files by last modified descending
    Given I am on the files page
    When I sort by last modified descending
    Then the files are sorted by last modified descending