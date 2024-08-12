@tag
Feature: Login and Reserve a Name

  @tag1
  Scenario Outline: Login and Reserve a Name for a new LLP
    Given User open the browser and navigate to the login page
    When User log in with "<username>" and "<password>"
    Then User navigate to the Reserved Names section
    And User proceed to reserve a name for a new LLP
    Then User is logged out successfully

    Examples:
      | username      | password   |
      | 3520210509845 | Malik@e009 |