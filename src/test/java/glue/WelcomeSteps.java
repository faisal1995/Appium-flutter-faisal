package glue;

import io.cucumber.java.en.Given;
import javax.inject.Inject;
import screens.HomeScreen;
import screens.WelcomeScreen;

public class WelcomeSteps {

  @Inject
  private WelcomeScreen welcomeScreen;

  @Given("Dash Shipper taps 'Log in' on welcome screen")
  public void dashShipperTapsOnWelcomeScreen() {
    welcomeScreen.tapLogIn();
  }
}
