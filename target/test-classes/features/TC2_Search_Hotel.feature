Feature: Verify OMR Hotel booking Search Hotel module

  Scenario Outline: Verify Search Hotel and enter all fields
    Given User is on OMR Branch page
    When User login "<userName>" and "<password>"
    Then User should verify after login success message as "Welcome Srini"
    When User search hotel "<state>","<roomType>","<checkIn>","<check-out>","<No of Room>","<No of Adults>" and "<No of Childs>"
    Then User should verify after search hotel success message "Select Hotel"

    Examples: 
      | userName            | password        | state      | roomType | checkIn    | check-out  | No of Room | No of Adults | No of Childs |
      | srinipmps@gmail.com | abEuKW6S@asg3Nv | Tamil Nadu | Deluxe   | 2024-05-23 | 2024-05-26 | 1-One      | 3-Three      |            2 |

  Scenario Outline: Verify Search Hotel and enter mandatory fields
    Given User is on OMR Branch page
    When User login "<userName>" and "<password>"
    Then User should verify after login success message as "Welcome Srini"
    When User search hotel "<state>","<city>","<check-in>","<check-out>","<No of Room>" and "<No of Adults>"
    Then User should verify after search hotel success message "Select Hotel"

    Examples: 
      | userName            | password        | state      | check-in   | check-out  | No of Room | No of Adults |
      | srinipmps@gmail.com | abEuKW6S@asg3Nv | Tamil Nadu | 2024-05-23 | 2024-05-26 | 1-One      | 3-Three      |

  Scenario Outline: Verify Search Hotel and without enter values in the fileds
    Given User is on OMR Branch page
    When User login "<userName>" and "<password>"
    Then User should verify after login success message as "Welcome Srini"
    When User click search button
    Then User should verify after search hotel error message "Please select state","Please select city","Please select Check-in date","Please select Check-out date","Please select no. of rooms" and "Please select no. of adults"

    Examples: 
      | userName            | password        |
      | srinipmps@gmail.com | abEuKW6S@asg3Nv |

  Scenario Outline: Verify selected roomtype is ends with Hotel Name
    Given User is on OMR Branch page
    When User login "<userName>" and "<password>"
    Then User should verify after login success message as "Welcome Srini"
    When User search hotel "<state>","<room type>","<check-in>","<check-out>","<No of Room>","<No of Adults>" and "<No of Childs>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should verify all hotel listed in the selected room type "<room type>"

    Examples: 
      | userName            | password        | state      | room type | check-in   | check-out  | No of Room | No of Adults | No of Childs |
      | srinipmps@gmail.com | abEuKW6S@asg3Nv | Tamil Nadu | Deluxe    | 2024-05-23 | 2024-05-26 | 1-One      | 3-Three      |            2 |

  Scenario Outline: Verify all selected room type displayed in Header
    Given User is on OMR Branch page
    When User login "<userName>" and "<password>"
    Then User should verify after login success message as "Welcome Srini"
    When User search hotel "<state>","<room type>","<check-in>","<check-out>","<No of Room>","<No of Adults>" and "<No of Childs>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should verify the header contains "Standard/Deluxe/Suite/Luxury/Studio"

    Examples: 
      | userName            | password        | state      | room type                           | check-in   | check-out  | No of Room | No of Adults | No of Childs |
      | srinipmps@gmail.com | abEuKW6S@asg3Nv | Tamil Nadu | Standard/Deluxe/Suite/Luxury/Studio | 2024-05-23 | 2024-05-26 | 1-One      | 3-Three      |            2 |

  Scenario Outline: Verify sorting functionality hotel price from Low to High
    Given User is on OMR Branch page
    When User login "<userName>" and "<password>"
    Then User should verify after login success message as "Welcome Srini"
    When User search hotel "<state>","<room type>","<check-in>","<check-out>","<No of Room>","<No of Adults>" and "<No of Childs>"
    Then User should verify after search hotel success message "Select Hotel"
    When User select the option to sort hotels by price from Low to High
    Then User should verify the displayed hotels name are in Low to High

    Examples: 
      | userName            | password        | state      | room type | check-in   | check-out  | No of Room | No of Adults | No of Childs |
      | srinipmps@gmail.com | abEuKW6S@asg3Nv | Tamil Nadu | Standard  | 2024-05-23 | 2024-05-26 | 1-One      | 3-Three      |            2 |

  @Run1
  Scenario Outline: Verify sorting functionality hotel price from High to Low
    Given User is on OMR Branch page
    When User login "<userName>" and "<password>"
    Then User should verify after login success message as "Welcome Srini"
    When User search hotel "<state>","<room type>","<check-in>","<check-out>","<No of Room>","<No of Adults>" and "<No of Childs>"
    Then User should verify after search hotel success message "Select Hotel"
    When User select the option to sort hotels by price from High to Low
    Then User should verify the displayed hotels name are in High to Low

    Examples: 
      | userName            | password        | state      | room type | check-in   | check-out  | No of Room | No of Adults | No of Childs |
      | srinipmps@gmail.com | abEuKW6S@asg3Nv | Tamil Nadu | Standard  | 2024-05-23 | 2024-05-26 | 1-One      | 3-Three      |            2 |

  Scenario Outline: Verify sorting functionality hotel name is in Ascending order
    Given User is on OMR Branch page
    When User login "<userName>" and "<password>"
    Then User should verify after login success message as "Welcome Srini"
    When User search hotel "<state>","<room type>","<check-in>","<check-out>","<No of Room>","<No of Adults>" and "<No of Childs>"
    Then User should verify after search hotel success message "Select Hotel"
    When User select the option to sort hotels by name in Ascending order
    Then User should verify the displayed hotels name are in Ascending order

    Examples: 
      | userName            | password        | state      | room type | check-in   | check-out  | No of Room | No of Adults | No of Childs |
      | srinipmps@gmail.com | abEuKW6S@asg3Nv | Tamil Nadu | Standard  | 2024-05-23 | 2024-05-26 | 1-One      | 3-Three      |            2 |

  Scenario Outline: Verify sorting functionality hotel name is in Descending order
    Given User is on OMR Branch page
    When User login "<userName>" and "<password>"
    Then User should verify after login success message as "Welcome Srini"
    When User search hotel "<state>","<room type>","<check-in>","<check-out>","<No of Room>","<No of Adults>" and "<No of Childs>"
    Then User should verify after search hotel success message "Select Hotel"
    When User select the option to sort hotels by name in Descending order
    Then User should verify the displayed hotels name are in Descending order

    Examples: 
      | userName            | password        | state      | room type | check-in   | check-out  | No of Room | No of Adults | No of Childs |
      | srinipmps@gmail.com | abEuKW6S@asg3Nv | Tamil Nadu | Standard  | 2024-05-23 | 2024-05-26 | 1-One      | 3-Three      |            2 |
