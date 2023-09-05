@Smoke @Account
Feature: Account related scenarios

  Scenario Outline: Set up a bank account
    Given Dash Shipper taps 'Log in' on welcome screen
    When Dash Shipper logon using email: "<UserName>" and password: "<Password>"
    And Dash Shipper taps 'Account' on bottom navigation bar
    And Dash Shipper navigates to 'Set up bank account' screen
    Then Dash Shipper sets up bank account with the following info:
      | bankName          | BANK MEGA  |
      | bankCode          | 426        |
      | accountNumber     | 1293939334 |
      | accountHolderName | Auto Name  |
    And Dash Shipper verifies that the message: "<Message>" is displayed

    Examples:
      | UserName                                    | Password   | Message                      |
      | dashqaautomobile+id.mobile_only.2@gmail.com | Ninjitsu89 | We’ve got your bank account! |