package glue;

import io.cucumber.java.en.When;
import java.util.Map;
import javax.inject.Inject;
import org.assertj.core.api.Assertions;
import screens.order.OrderCreateScreen;
import screens.order.OrderSuccessScreen;

public class OrderCreateSteps {

  @Inject
  private OrderCreateScreen orderCreateScreen;

  @Inject
  private OrderSuccessScreen orderSuccessScreen;

  @When("Dash Shipper fill the following customer details on the oc form")
  public void dashShipperFillTheFollowingCustomerDetailsOnTheOcForm(Map<String, String> customer) {
    orderCreateScreen.fillInCustomerDetails(customer);
  }

  @When("Dash Shipper add the following parcel details:")
  public void dashShipperAddTheFollowingParcelDetails(Map<String, String> parcelInfo) {
    orderCreateScreen.fillInParcelDetails(parcelInfo);
  }

  @When("Dash Shipper add the parcel dimension details as follows:")
  public void dashShipperAddTheParcelDimensionDetailsAsFollows(Map<String, String> dimensions) {
    orderCreateScreen.specifyDimensions(dimensions);
  }

  @When("Dash Shipper add the parcel total insurance value as {string}")
  public void dashShipperAddTheParcelTotalInsuranceValueAs(String insuranceValue) {
    orderCreateScreen.addInsuranceValue(insuranceValue);
  }
  @When("Dash Shipper add the parcel content description as {string}")
  public void dashShipperAddTheParcelContentDescriptionAs(String content) {
    orderCreateScreen.addParcelContent(content);
  }
  @When("Dash Shipper check the option 'is dangerous goods?' as {string}")
  public void dashShipperCheckTheOptionAs( String option) {
    if(option.equalsIgnoreCase("No"))
      orderCreateScreen.checkDangerousGoods();
  }
  @When("Dash Shipper submit the order and confirm that it is created")
  public void dashShipperSubmitTheOrderAndConfirmThatItIsCreated() {
    orderCreateScreen.createOrder();
    boolean isDisplayed = orderSuccessScreen.isTextDisplayed("Order created!");
    Assertions.assertThat(isDisplayed).as("Assert that the order is created")
        .isTrue();
  }

}
