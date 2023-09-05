@Smoke @ShippingFee
Feature: Shipping Fee estimator related scenarios

  Scenario Outline: Shipping fee estimator
    Given Dash Shipper taps 'Log in' on welcome screen
    When Dash Shipper logon using email: "<UserName>" and password: "<Password>"
    And Dash Shipper open shipping fee estimator from home screen
    And Dash Shipper fill customer's from address as follows:
      | province    | Jawa Timur    |
      | district    | Kota Surabaya |
      | subDistrict | Gubeng        |
    And Dash Shipper fill customer's to address as follows:
      | province    | Jambi      |
      | district    | Kota Jambi |
      | subDistrict | Kota Baru  |
    And Dash Shipper slide parcel weight to 50 percentage and set weight as 35 kg
    And Dash Shipper verify the estimated prices as '<EstimatedPrice>'

    Examples:
      | UserName                                    | Password   | EstimatedPrice |
      | dashqaautomobile+id.mobile_only.2@gmail.com | Ninjitsu89 | 32.352,00 IDR  |