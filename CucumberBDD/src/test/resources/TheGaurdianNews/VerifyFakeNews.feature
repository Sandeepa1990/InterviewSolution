#Author: sandeepa.1990@gmail.com
#Keywords Summary : This feature is to verify the news published in News The Gaurdian in authentic(not fake)
#Feature: Here fake new validator will be searching for the 1st news appeared on The Gaurdian and search other source to validate
Feature: Verify the AUTHENTICITY of THE GAURDIAN NEWS

  Background: The automation environment is set with all initial condition
    Given Web browser is selected as Chrome

  Scenario: Verify the first news in The Garudian News Home Page
    Given Jhon is a fake new validator at The Gaurdian
    When Jhon navigates to The Gaurdian News home page
    And Picks the first new displayed
    Then Jhon checks for the date of publish is today

  Scenario: Verify the first search result is from The Gaurdian
    Given Jhon opens up google search engine
    When Searches for the 1st news of the gaurdian
    Then Verify the 1st appearing link is from The Gaurdian

  Scenario Outline: Verify the news from other sources
    Given Jhon picks the search result other than The Gardian
    When Checks the news content
    Then Verify the <percentage> of words match to confirm the authenticity

    Examples: 
      | percentage |
      |         60 |
