Feature: Files and folders listing and sorting

  Background:
    Given I am logged in

  Scenario: Sorting the files by default sort
    Given I am on the studio page
    When I am on the default sort
    Then the files are sorted by Name ascending

  Scenario: Sorting the files by Name ascending
    Given I am on the studio page
    When I sort by Name ascending
    Then the files are sorted by Name ascending

  Scenario: Sorting the files by Name descending
    Given I am on the studio page
    When I sort by Name descending
    Then the files are sorted by Name descending

  Scenario: Sorting the files by Description ascending
    Given I am on the studio page
    When I sort by Description ascending
    Then the files are sorted by Description ascending

  Scenario: Sorting the files by Description descending
    Given I am on the studio page
    When I sort by Description descending
    Then the files are sorted by Description descending

  Scenario: Sorting the files by Last Modified ascending
    Given I am on the studio page
    When I sort by Last Modified ascending
    Then the files are sorted by Last Modified ascending

  Scenario: Sorting the files by Last Modified descending
    Given I am on the studio page
    When I sort by Last Modified descending
    Then the files are sorted by Last Modified descending