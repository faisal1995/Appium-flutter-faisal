package glue;

import io.cucumber.java.en.When;
import javax.inject.Inject;
import screens.LoginScreen;

public class LoginSteps {

  @Inject
  LoginScreen loginScreen;

  @When("Dash Shipper logon using email: {string} and password: {string}")
  public void dashShipperLogonUsingEmailAndPassword(String email, String password) {
    loginScreen.logIn(email, password);
  }
}
