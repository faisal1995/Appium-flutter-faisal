package screens;

import com.google.inject.Inject;

import co.nvqa.appium.flutter.common.FlutterBy;
import co.nvqa.appium.flutter.driver.AppiumFlutterDriver;
import co.nvqa.appium.flutter.driver.FlutterElement;
import io.cucumber.guice.ScenarioScoped;


@ScenarioScoped
public class AccountScreen extends BaseScreen {
  AppiumFlutterDriver driver;

  @Inject
  public AccountScreen(AppiumFlutterDriver driver) {
    super(driver);
    this.driver = driver;
  }

  private FlutterElement getAccountDetailsButton() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.accountDetailsButton");
  }

  private FlutterElement getEmptySetupBankAccountButton() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.bankAccountButtonEmpty");
  }

  private FlutterElement getSetupBankAccountButton() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.bankAccountButton");
  }

  private FlutterElement getPickupLocationButton() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.accountPagePickupLocationButton");
  }

  private FlutterElement getAirwayBillPrinterLink() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.accountPagePrinterSetup");
  }

  private FlutterElement getNotificationsLink() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.accountNotificationsButton");
  }

  private FlutterElement getHelpdeskButton() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.accountSettingsHelpdeskButton");
  }

  public boolean navigateToAccountDetails() {
    getAccountDetailsButton().click();
    return isTextDisplayed("You");
  }

  public boolean navigateToSetupAccountFirstTime() {
    getEmptySetupBankAccountButton().click();
    return isTextDisplayed("Set up bank account");
  }

  public boolean navigateToSetupAccount() {
    getSetupBankAccountButton().click();
    return isTextDisplayed("Set up bank account");
  }

  public boolean navigateToLocations() {
    getPickupLocationButton().click();
    return isTextDisplayed("Locations");
  }

  public boolean navigateToAirwayBillPrinterSetup() {
    getAirwayBillPrinterLink().click();
    return isTextDisplayed("Connect Printer");
  }

  public boolean navigateToNotifications() {
    getNotificationsLink().click();
    return isTextDisplayed("Push notifications");
  }

  public boolean navigateToHelpdesk() {
    getHelpdeskButton().click();
    return isTextDisplayed("FAQs");
  }

}
