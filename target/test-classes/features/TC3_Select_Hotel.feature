Feature: Verify OMR Hotel booking Select Hotel module

  Scenario Outline: Verify select hotel and verify navigate to book hotel upon accepting the alert
    Given User is on OMR Branch page
    When User login "<userName>" and "<password>"
    Then User should verify after login success message as "Welcome Srini"
    When User search hotel "<state>","<room type>","<check-in>","<check-out>","<No of Room>","<No of Adults>" and "<No of Childs>"
    Then User should verify after search hotel success message "Select Hotel"
    When User should verify the first Hotel name "<room type>" and Price
    Then User should click the first hotel
    And User should Accept alert
    Then User should verify after select hotel success message "Book Hotel -"

    Examples: 
      | userName            | password        | state      | room type | check-in   | check-out  | No of Room | No of Adults | No of Childs |
      | srinipmps@gmail.com | abEuKW6S@asg3Nv | Tamil Nadu | Deluxe    | 2024-05-23 | 2024-05-26 | 1-One      | 3-Three      |            2 |

  Scenario Outline: Select hotel and verify navigate in the same page upon dismiss the alert
    Given User is on OMR Branch page
    When User login "<userName>" and "<password>"
    Then User should verify after login success message as "Welcome Srini"
    When User search hotel "<state>","<room type>","<check-in>","<check-out>","<No of Room>","<No of Adults>" and "<No of Childs>"
    Then User should verify after search hotel success message "Select Hotel"
    When User should click the first hotel
    And User should Dismiss alert
    Then User should verify is in same page success message "Select Hotel"

    Examples: 
      | userName            | password        | state      | room type | check-in   | check-out  | No of Room | No of Adults | No of Childs |
      | srinipmps@gmail.com | abEuKW6S@asg3Nv | Tamil Nadu | Deluxe    | 2024-05-23 | 2024-05-26 | 1-One      | 3-Three      |            2 |
