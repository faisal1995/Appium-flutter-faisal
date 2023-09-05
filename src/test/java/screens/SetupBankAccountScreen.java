package screens;

import static glue.injector.util.getAlphaNumericString;

import com.google.inject.Inject;
import io.appium.java_client.AppiumDriver;
import io.cucumber.guice.ScenarioScoped;
import co.nvqa.appium.flutter.common.FlutterBy;
import co.nvqa.appium.flutter.driver.AppiumFlutterDriver;
import co.nvqa.appium.flutter.driver.FlutterElement;
import java.util.Map;
import org.assertj.core.api.Assertions;

@ScenarioScoped
public class SetupBankAccountScreen extends BaseScreen {

  AppiumFlutterDriver driver;

  @Inject
  public SetupBankAccountScreen(AppiumFlutterDriver driver) {
    super(driver);
    this.driver = driver;
  }

  private FlutterElement getBankNameDropdown() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.bankNameDropdown");
  }

  private FlutterElement getBankAccountCodeTextBox() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.bankAccountCodeInput");
  }

  private FlutterElement getBankAccountNumberTextBox() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.bankAccountNumberInput");
  }

  private FlutterElement getBankAccountHolderTextBox() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.bankAccountHolderInput");
  }

  private FlutterElement getSaveBankAccountButton() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.bankNameButton");
  }


  public void setUpBankAccount(Map<String, String> bankAccount) {
    getBankNameDropdown().click();
    scrollIntoView(getDropdownItem(bankAccount.get("bankName"))).click();
    Assertions.assertThat(isTextDisplayed(bankAccount.get("bankCode")))
        .as("Assert that bank code is correct").isTrue();
    getBankAccountNumberTextBox()
        .sendKeys(bankAccount.get("accountNumber"));
//    getBankAccountHolderTextBox()
//        .sendKeys(bankAccount.get("accountHolderName"));
    getBankAccountHolderTextBox().sendKeys(getAlphaNumericString(10));
    getSaveBankAccountButton().click();
  }


}
