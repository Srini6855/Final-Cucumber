Feature: Verify OMR Hotel Change Booking module

  Scenario Outline: Verify modified Check-in Date
    Given User is on OMR Branch page
    When User login "<userName>" and "<password>"
    Then User should verify after login success message as "Welcome Srini"
    When User search hotel "<state>","<room type>","<check-in>","<check-out>","<No of Room>","<No of Adults>" and "<No of Childs>"
    Then User should verify after search hotel success message "Select Hotel"
    When User should verify the first Hotel name "<room type>" and Price
    Then User should click the first hotel
    And User should Accept alert
    Then User should verify after select hotel success message "Book Hotel -"
    When User add Guest Details "<Select Salutation>","<First Name>","<Last Name>","<Mobile No.>" and "<Email>"
    And User add GST Details "<Enter Registration No.>","<Enter Company Name>" and "<Enter Company Address>"
    Then User add Special Request "<Request>"
    When User enter payment details, procced with Card Type "<Card Type>"
      | Select Card | Card No          | Card Name | Month | Year | CVV |
      | Visa        | 5555555555552222 | Srini     | July  | 2025 | 123 |
      | MasterCard  | 5555555555554444 | Srini     | July  | 2025 | 123 |
      | Amex        | 5555555555550000 | Srini     | July  | 2025 | 123 |
      | Discover    | 5555555555556666 | Srini     | July  | 2025 | 123 |
    And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    Then User should verify same selected Hotel is booked or not
    When User navigate to My Booking page
    Then User should verify after navigate to My Booking page success message as "Bookings"
    When User search the Order ID
    Then User should verify same booked Order ID is present or not
    And User should verify same booked Hotel Name is present or not
    Then User should verify same booked Hotel Price is present or not
    When User edit the Check-in Date "<Modify Date>"
    Then User should verify after modify check-in date success message "Booking updated successfully"

    Examples: 
      | userName            | password        | state      | room type | check-in   | check-out  | No of Room | No of Adults | No of Childs | Select Salutation | First Name | Last Name | Mobile No. | Email               | Enter Registration No. | Enter Company Name     | Enter Company Address | Request            | Card Type  | Modify Date |
      | srinipmps@gmail.com | abEuKW6S@asg3Nv | Tamil Nadu | Deluxe    | 2024-05-23 | 2024-05-26 | 1-One      | 3-Three      |            2 | Mr.               | Srinivasu  | Aruchamy  | 9487715046 | srinipmps@gmail.com |             9043592058 | Greens Tech OMR Branch | Thoraipakkam          | Veg preference veg | Debit Card | 2024-05-25  |

  @Run2
  Scenario Outline: Verify modified Check-in Date for existing Order ID
    Given User is on OMR Branch page
    When User login "<userName>" and "<password>"
    Then User should verify after login success message as "Welcome Srini"
    When User navigate to My Booking page
    Then User should verify after navigate to My Booking page success message as "Bookings"
    When User search the Order ID "<orderId>"
    Then User should verify same booked Order ID is present or not
    When User edit the Check-in Date "<Modify Date>"
    Then User should verify after modify check-in date success message "Booking updated successfully"

    Examples: 
      | userName            | password        | orderId    | Modify Date |
      | srinipmps@gmail.com | abEuKW6S@asg3Nv | OYZEG17936 | 2024-05-25  |

  @Run2
  Scenario Outline: Verify modified Check-in Date for first displayed Order ID
    Given User is on OMR Branch page
    When User login "<userName>" and "<password>"
    Then User should verify after login success message as "Welcome Srini"
    When User navigate to My Booking page
    Then User should verify after navigate to My Booking page success message as "Bookings"
    When User edit the Check-in Date for the first displayed Order ID "<Modify Date>"
    Then User should verify after modify check-in date success message "Booking updated successfully"

    Examples: 
      | userName            | password        | Modify Date |
      | srinipmps@gmail.com | abEuKW6S@asg3Nv | 2024-05-24  |
