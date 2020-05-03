Feature: Validate AutoTrader page for car search

  @run
  Scenario Outline: Verify on Auto Trader home page the elements are present
    Given Launch AutoTrader Application
    Then Validate AutoTrader HomePage is displayed
    And Validate Browse by Make, Browse by Style, Advanced Search are present
    And Validate Search button is present
    And Validate Make and Model dropdowns are present
    When Click on advanced search link
    And Enter "<zipcode>" in the zip code field
    And Select the Certified check box under Condition
    And Select the Convertible check box under Style
    And Select "<FromYear>" from From Year drop down
    And Select "<ToYear>" from To Year drop down
    And Select Make as "<Brand>" under Make, Model & Trim section
    And Click the button Search at the bottom of the page
    Then Validate that only "<Brand>" cars are displayed in the results page

    Examples: 
      | zipcode | FromYear | ToYear | Brand |
      |   30004 |     2017 |   2020 | BMW   |
