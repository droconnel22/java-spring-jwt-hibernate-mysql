Feature: A sample Timesheet API with a seeded database.

  Scenario: Get All TimeSheets
    Given A Seeded Database of 588 records

    When A Client calls GET "timesheet"

    Then The Client receives a valid response status code of 200
    And The Client receives a valid response body with a collection
    And The Client receives a collection of timesheets with a count of 588


  Scenario: Get Existing Timesheet by Id
    Given A Seeded Database of 588 records

    When A Client calls GET "timesheet" with an Id of 588

    Then The Client receives a response status code of 200
    And The Client receives a valid response body
    And The Client receives a Timesheet with Id equal to 588
    And The  Client receives a Timesheet with a Client Name of "Prosaria"

  Scenario: Get Existing Timesheet by Search Criteria of client
    Given A Seeded Database of 588 records

    When A Client calls GET "timesheet/search" with a client name of "Roonder Technologies LLC"

    Then The Client receives a valid response status code of 200
    And The Client receives a valid response body with a collection
    And The Client receives a collection of timesheets with a count of 94
    And The Client only receives a collection of Timesheets with a Client Name of "Roonder Technologies LLC"

  Scenario: Create a new Timesheet
    Given A Seeded Database of 588 records

    When A Client calls POST "timesheet" with Data:
    | approved| billable| billable_rate| client| cost_amount| cost_rate|                  currency|               date|      department| employee| external_referenceurl| first_name| hours| hours_rounded| invoiced|     last_name|            project| project_code|        task|
    |0        |0        |            20| LeetSp|           0|         0|United States Dollar - USD|2019-01-10 00:00:00|     Engineering|        0|                      |     Dennis|  8.25|             8|        0|      OCONNELL| Big Little Company|       GGG001| Development|


    Then The Client receives a response status code of 200
    And The Client receives a valid response body
    And The Client receives a Timesheet with Id equal to 589
    And The  Client receives a Timesheet with a Client Name of "LeetSp"
    Then The Client calls DELETE "timesheet" on created Timesheet

  Scenario: Update an existing Timesheet
    Given A Seeded Database of 588 records
    And A Client calls GET "timesheet" with an Id of 45

    When A Client calls PUT "timesheet" with Id of 45 and an update of Client of "FooClient"


    Then The Client receives a response status code of 200
    And The Client receives a valid response body
    And The Client receives a Timesheet with Id equal to 45
    And The  Client receives a Timesheet with a Client Name of "FooClient"
