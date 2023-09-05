@Smoke @Orders
Feature: Order related scenarios

  Scenario Outline: Cancel order
    Given Dash Shipper taps 'Log in' on welcome screen
    When Dash Shipper logon using email: "<UserName>" and password: "<Password>"
    And Dash Shipper taps 'Orders' on bottom navigation bar
    And Dash Shipper search orders with the text: "NVIDNINJATDB900070" in orders screen

    Examples:
      | UserName                                    | Password   | Message                      |
      | dashqaautomobile+id.mobile_only.2@gmail.com | Ninjitsu89 | We’ve got your bank account! |