Feature: Verify OMR Hotel booking Book Hotel module

  Scenario Outline: Verify Book Hotel including GST and Debit card with special request
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

    Examples: 
      | userName            | password        | state      | room type | check-in   | check-out  | No of Room | No of Adults | No of Childs | Select Salutation | First Name | Last Name | Mobile No. | Email               | Enter Registration No. | Enter Company Name     | Enter Company Address | Request        | Card Type  |
      | srinipmps@gmail.com | abEuKW6S@asg3Nv | Tamil Nadu | Deluxe    | 2024-05-23 | 2024-05-26 | 1-One      | 3-Three      |            2 | Mr.               | Srinivasu  | Aruchamy  | 9487715046 | srinipmps@gmail.com |             9043592058 | Greens Tech OMR Branch | Thoraipakkam          | Veg preference | Debit Card |

  @Run2
  Scenario Outline: Verify Book Hotel including GST and Credit card with special request
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
      | Visa        | 5555555555552223 | Srini     | July  | 2025 | 123 |
      | MasterCard  | 5555555555554444 | Srini     | July  | 2025 | 123 |
      | Amex        | 5555555555550000 | Srini     | July  | 2025 | 123 |
      | Discover    | 5555555555556666 | Srini     | July  | 2025 | 123 |
    Then User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    And User should verify same selected Hotel is booked or not

    Examples: 
      | userName            | password        | state      | room type | check-in   | check-out  | No of Room | No of Adults | No of Childs | Select Salutation | First Name | Last Name | Mobile No. | Email               | Enter Registration No. | Enter Company Name     | Enter Company Address | Request        | Card Type   |
      | srinipmps@gmail.com | abEuKW6S@asg3Nv | Tamil Nadu | Deluxe    | 2024-05-23 | 2024-05-26 | 1-One      | 3-Three      |            2 | Mr.               | Srinivasu  | Aruchamy  | 9487715046 | srinipmps@gmail.com |             9043592058 | Greens Tech OMR Branch | Thoraipakkam          | Veg preference | Credit Card |

  @Run2
  Scenario Outline: Verify Book Hotel including GST and Debit card without special request
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
    And User Click next in special request page
    When User enter payment details, procced with Card Type "<Card Type>"
      | Select Card | Card No          | Card Name | Month | Year | CVV |
      | Visa        | 5555555555552222 | Srini     | July  | 2025 | 123 |
      | MasterCard  | 5555555555554444 | Srini     | July  | 2025 | 123 |
      | Amex        | 5555555555550000 | Srini     | July  | 2025 | 123 |
      | Discover    | 5555555555556666 | Srini     | July  | 2025 | 123 |
    Then User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    And User should verify same selected Hotel is booked or not

    Examples: 
      | userName            | password        | state      | room type | check-in   | check-out  | No of Room | No of Adults | No of Childs | Select Salutation | First Name | Last Name | Mobile No. | Email               | Enter Registration No. | Enter Company Name     | Enter Company Address | Card Type  |
      | srinipmps@gmail.com | abEuKW6S@asg3Nv | Tamil Nadu | Deluxe    | 2024-05-23 | 2024-05-26 | 1-One      | 3-Three      |            2 | Mr.               | Srinivasu  | Aruchamy  | 9487715046 | srinipmps@gmail.com |             9043592058 | Greens Tech OMR Branch | Thoraipakkam          | Debit Card |

  @Run2
  Scenario Outline: Verify Book Hotel including GST and Credit card without special request
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
    And User Click next in special request page
    When User enter payment details, procced with Card Type "<Card Type>"
      | Select Card | Card No          | Card Name | Month | Year | CVV |
      | Visa        | 5555555555552223 | Srini     | July  | 2025 | 123 |
      | MasterCard  | 5555555555554444 | Srini     | July  | 2025 | 123 |
      | Amex        | 5555555555550000 | Srini     | July  | 2025 | 123 |
      | Discover    | 5555555555556666 | Srini     | July  | 2025 | 123 |
    Then User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    And User should verify same selected Hotel is booked or not

    Examples: 
      | userName            | password        | state      | room type | check-in   | check-out  | No of Room | No of Adults | No of Childs | Select Salutation | First Name | Last Name | Mobile No. | Email               | Enter Registration No. | Enter Company Name     | Enter Company Address | Card Type   |
      | srinipmps@gmail.com | abEuKW6S@asg3Nv | Tamil Nadu | Deluxe    | 2024-05-23 | 2024-05-26 | 1-One      | 3-Three      |            2 | Mr.               | Srinivasu  | Aruchamy  | 9487715046 | srinipmps@gmail.com |             9043592058 | Greens Tech OMR Branch | Thoraipakkam          | Credit Card |

  @mmmm
  Scenario Outline: Verify Book Hotel without GST and Debit card with special request
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
    And User Click next
    Then User add Special Request "<Request>"
    When User enter payment details, procced with Card Type "<Card Type>"
      | Select Card | Card No          | Card Name | Month | Year | CVV |
      | Visa        | 5555555555552222 | Srini     | July  | 2025 | 123 |
      | MasterCard  | 5555555555554444 | Srini     | July  | 2025 | 123 |
      | Amex        | 5555555555550000 | Srini     | July  | 2025 | 123 |
      | Discover    | 5555555555556666 | Srini     | July  | 2025 | 123 |
    Then User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    And User should verify same selected Hotel is booked or not

    Examples: 
      | userName            | password        | state      | room type | check-in   | check-out  | No of Room | No of Adults | No of Childs | Select Salutation | First Name | Last Name | Mobile No. | Email               | Request        | Card Type  |
      | srinipmps@gmail.com | abEuKW6S@asg3Nv | Tamil Nadu | Deluxe    | 2024-05-23 | 2024-05-26 | 1-One      | 3-Three      |            2 | Mr.               | Srinivasu  | Aruchamy  | 9487715046 | srinipmps@gmail.com | Veg preference | Debit Card |

  @Run2
  Scenario Outline: Verify Book Hotel without GST and Credit card without special request
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
    And User click next untill payment page comes
    When User enter payment details, procced with Card Type "<Card Type>"
      | Select Card | Card No          | Card Name | Month | Year | CVV |
      | Visa        | 5555555555552223 | Srini     | July  | 2025 | 123 |
      | MasterCard  | 5555555555554444 | Srini     | July  | 2025 | 123 |
      | Amex        | 5555555555550000 | Srini     | July  | 2025 | 123 |
      | Discover    | 5555555555556666 | Srini     | July  | 2025 | 123 |
    Then User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    And User should verify same selected Hotel is booked or not

    Examples: 
      | userName            | password        | state      | room type | check-in   | check-out  | No of Room | No of Adults | No of Childs | Select Salutation | First Name | Last Name | Mobile No. | Email               | Enter Registration No. | Card Type   |
      | srinipmps@gmail.com | abEuKW6S@asg3Nv | Tamil Nadu | Deluxe    | 2024-05-23 | 2024-05-26 | 1-One      | 3-Three      |            2 | Mr.               | Srinivasu  | Aruchamy  | 9487715046 | srinipmps@gmail.com | Credit Card            | Credit Card |

  @Run2
  Scenario Outline: Verify Book Hotel without entering payment details and verify error messsage
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
    When User without entering payment deatils and click Submit
    Then User should verify after payment details error message "Please select your card type","Please select your card","Please provide your card number","Please provide name on your card","Please provide your Card Expiry Date" and "Please provide your Card's security code"

    Examples: 
      | userName            | password        | state      | room type | check-in   | check-out  | No of Room | No of Adults | No of Childs | Select Salutation | First Name | Last Name | Mobile No. | Email               | Enter Registration No. | Enter Company Name     | Enter Company Address | Request        | Card Type  |
      | srinipmps@gmail.com | abEuKW6S@asg3Nv | Tamil Nadu | Deluxe    | 2024-05-23 | 2024-05-26 | 1-One      | 3-Three      |            2 | Mr.               | Srinivasu  | Aruchamy  | 9487715046 | srinipmps@gmail.com |             9043592058 | Greens Tech OMR Branch | Thoraipakkam          | Veg preference | Debit Card |
