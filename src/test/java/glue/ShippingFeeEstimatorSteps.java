package glue;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Map;
import javax.inject.Inject;
import org.assertj.core.api.Assertions;
import screens.EstimateShippingFeeScreen;
import screens.HomeScreen;

public class ShippingFeeEstimatorSteps {

  @Inject
  private EstimateShippingFeeScreen estimateShippingFeeScreen;

  @When("Dash Shipper fill customer's from address as follows:")
  public void dashShipperFillCustomerSFromAddressAsFollows(Map<String, String> fromAddress) {
    estimateShippingFeeScreen.fillInFromAddress(fromAddress);
  }

  @When("Dash Shipper fill customer's to address as follows:")
  public void dashShipperFillCustomerSToAddressAsFollows(Map<String, String> toAddress) {
    estimateShippingFeeScreen.fillInToAddress(toAddress);
  }

  @Then("Dash Shipper verify the estimated prices as {string}")
  public void dashShipperVerifyTheEstimatedPricesAs(String estimatedFee) {
    Assertions.assertThat(estimateShippingFeeScreen.isTextDisplayed(estimatedFee))
        .as("Assert that shipping is correctly displayed")
        .isTrue();
  }

  @When("Dash Shipper slide parcel weight to {int} percentage and set weight as {int} kg")
  public void dashShipperSlideParcelWeightToPercentageAndSetWeightAsKg(Integer wtPercentage, Integer kg) {
    estimateShippingFeeScreen.setParcelWeight(wtPercentage);
  }
}
