Feature: Prueba base

  @tag1
  Scenario: Title of your scenario
    Given I want to write a step with precondition
    When I complete action
    Then some other action

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
