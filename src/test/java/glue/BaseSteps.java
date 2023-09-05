package glue;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javax.inject.Inject;
import org.assertj.core.api.Assertions;
import screens.BaseScreen;

public class BaseSteps {

  @Inject
  BaseScreen baseScreen;

  @When("Dash Shipper taps {string} on bottom navigation bar")
  public void dashShipperTapsOnBottomNavigationBar(String navBar) {
    Assertions.assertThat(baseScreen.navigateUsingBottomNav(navBar))
        .as(String.format("Assert that %s is displayed", navBar))
        .isTrue();
  }

  @Then("Dash Shipper verifies that the message: {string} is displayed")
  public void dashShipperVerifiesThatTheMessageIsDisplayed(String text) {
    Assertions.assertThat(baseScreen.isTextDisplayed(text))
        .as(String.format("Assert that %s is displayed", text))
        .isTrue();
  }
}
