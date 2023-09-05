package glue;

import io.cucumber.java.en.When;
import java.util.Map;
import javax.inject.Inject;
import screens.AccountScreen;
import screens.SetupBankAccountScreen;

public class AccountSteps {

  @Inject
  private AccountScreen accountScreen;

  @Inject
  private SetupBankAccountScreen setupBankAccountScreen;

  @When("Dash Shipper navigates to 'Set up bank account' screen first time")
  public void dashShipperNavigatesToScreenFirstTime() {
    accountScreen.navigateToSetupAccountFirstTime();
  }

  @When("Dash Shipper navigates to 'Set up bank account' screen")
  public void dashShipperNavigatesToScreen() {
    accountScreen.navigateToSetupAccount();
  }

  @When("Dash Shipper sets up bank account with the following info:")
  public void dashShipperSetsUpBankAccountWithTheFollowingInfo(Map<String, String> bank) {
    setupBankAccountScreen.setUpBankAccount(bank);
  }
}
