@Login
Feature: Verify OMR Hotel booking Login module

  Scenario Outline: Login to hotel booking page with valid credentials
    Given User is on OMR Branch page
    When User login "<userName>" and "<password>"
    Then User should verify after login success message as "Welcome Srini"

    Examples: 
      | userName            | password        |
      | srinipmps@gmail.com | abEuKW6S@asg3Nv |

  Scenario Outline: Login to hotel booking page with valid credientials using Enter key
    Given User is on OMR Branch page
    When User login "<userName>" and "<password>" using Enter key
    Then User should verify after login success message as "Welcome Srini"

    Examples: 
      | userName            | password        |
      | srinipmps@gmail.com | abEuKW6S@asg3Nv |

  Scenario Outline: Login to hotel booking page with Invalid credentials
    Given User is on OMR Branch page
    When User login "<userName>" and "<password>"
    Then User should verify after login error message as "User does not exist"

    Examples: 
      | userName        | password     |
      | srini@gmail.com | hi@greens123 |
