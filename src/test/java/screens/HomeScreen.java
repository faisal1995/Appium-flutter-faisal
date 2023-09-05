package screens;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import co.nvqa.appium.flutter.common.FlutterBy;
import co.nvqa.appium.flutter.driver.AppiumFlutterDriver;
import co.nvqa.appium.flutter.driver.FlutterElement;

@ScenarioScoped
public class HomeScreen extends BaseScreen {
  AppiumFlutterDriver driver;

  @Inject
  public HomeScreen(AppiumFlutterDriver driver) {
    super(driver);
    this.driver = driver;
  }

  private FlutterElement getTrackingTextBox() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.homeTrackingBtn");
  }

  private FlutterElement getCreateOrderButton() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.homeCreateBtn");
  }

  private FlutterElement getNinjaPointsButton() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.homeNinjaPointsBtn");
  }

  private FlutterElement getShippingFeeButton() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.homeShippingRateBtn");
  }

  private FlutterElement getReportProblemButton() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.homeReportAProblemBtn");
  }

  public void tapOrderCreate(){
    getCreateOrderButton().click();
  }

  public void tapShippingFee(){
    getShippingFeeButton().click();
  }
}
