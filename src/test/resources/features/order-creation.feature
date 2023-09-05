@Smoke @OrderCreate
Feature: Order Creation related scenarios

  Scenario Outline: Create an order
    Given Dash Shipper taps 'Log in' on welcome screen
    When Dash Shipper logon using email: "<UserName>" and password: "<Password>"
    And Dash Shipper open create order form from home screen
    And Dash Shipper fill the following customer details on the oc form
      | contact      | 0218619271     |
      | name         | expert         |
      | emailId      | e@e.com        |
      | province     | Banten         |
      | district     | Kota Serang    |
      | subDistrict  | Curug          |
      | addressLine1 | 1 first street |
      | addressLine2 | 2 second line  |
    And Dash Shipper add the following parcel details:
      | trackingId | TDB901070 |
      | parcelSize | Medium    |
    And Dash Shipper add the parcel dimension details as follows:
      | width  | 28 |
      | height | 44 |
      | length | 21 |
    And Dash Shipper add the parcel total insurance value as "1000"
    And Dash Shipper add the parcel content description as "1 x chocolate"
    And Dash Shipper check the option 'is dangerous goods?' as 'Yes'
    And Dash Shipper submit the order and confirm that it is created

    Examples:
      | UserName                                    | Password   |
      | dashqaautomobile+id.mobile_only.2@gmail.com | Ninjitsu89 |