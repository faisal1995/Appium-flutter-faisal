package glue;

import io.cucumber.java.en.When;
import javax.inject.Inject;
import screens.HomeScreen;

public class HomeSteps {

  @Inject
  private HomeScreen homeScreen;

  @When("Dash Shipper open create order form from home screen")
  public void dashShipperOpenCreateOrderFormFromHomeScreen() {
    homeScreen.tapOrderCreate();
  }

  @When("Dash Shipper open shipping fee estimator from home screen")
  public void dashShipperOpenShippingFeeEstimatorFromHomeScreen() {
    homeScreen.tapShippingFee();
  }

}
