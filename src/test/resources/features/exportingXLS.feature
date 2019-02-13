Feature: Exporting XLS report and verification of data

  Background:
    Given user goes to the main page "url"
    When the correct page loads
    Then user clicks on the link to download the table
    Then user controls if the excel table is downloaded

  @uc
  Scenario Outline: open the web site and download the excel table

    And user verifies the summation of the energy consumed by all states is equal to 97144.7
    Then controls if the column A contains the following "<states>"
    Examples:
      | states         |
      | Georgia        |
      | Hawaii         |
      | North Dakota   |
      | South Dakota   |
      | Texas          |


  Scenario: open the excel file and update data

    Then user records the most energy consuming state in transportation
    Then user records the least energy consuming state in residential
    Then user records the most energy consuming state in commercial
    Then user records the least energy consuming state in industrial
    And user verifies the summation of the cells B6 to B56 are written correctly at the cell B57 as 97144.7
    Then  user verifies that total industrial consumtion is greater than total residential consumtion
    Then user updates the the values as below
      | Colorado | 1955.4                |
      | Texas    | 11555.3               |











