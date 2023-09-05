package screens.order;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import co.nvqa.appium.flutter.common.FlutterBy;
import co.nvqa.appium.flutter.driver.AppiumFlutterDriver;
import co.nvqa.appium.flutter.driver.FlutterElement;
import org.assertj.core.api.Assertions;
import screens.BaseScreen;

@ScenarioScoped
public class OrderDetailsScreen extends BaseScreen {
  AppiumFlutterDriver driver;

  @Inject
  public OrderDetailsScreen(AppiumFlutterDriver driver) {
    super(driver);
    this.driver = driver;
  }

  private FlutterElement getCancelOrderButton() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.orderDetailCancelOrder");
  }

  private FlutterElement getConfirmCancelOrderButton() {
//    return  flutter.descendant(flutter.byType("SizedBox"),
//        flutter.byType("AkiraPrimaryButton"),
//        false,
//        true);
    return driver.findElement(FlutterBy.SEMANTICS_LABEL, "S().confirm_remove_order");
    //return flutter.bySemanticsLabel("S().confirm_remove_order");
    //return flutter.byType("AkiraPrimaryButton");
    //return flutter.byValueKey("KEYS.orderDetailConfirmCancel");
  }

  private FlutterElement getGranularStatusText() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.orderDetailsGranularStatus");
  }

  private FlutterElement getTrackingIdText() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.orderDetailsTrackingId");
  }

  private FlutterElement getEstimatedDeliveryText() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.orderDetailsEstimatedDelivery");
  }


  private FlutterElement getShareOrderButton() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.shareOrderButton");
  }


  private FlutterElement getAirwayBillButton() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.airWaybillBtn");
  }

  public void cancelOrder() {
    getCancelOrderButton().click();
    Assertions.assertThat(isElementDisplayed(getConfirmCancelOrderButton())).isTrue();
    //command.execute(Command.WAIT_FOR, getConfirmCancelOrderButton(), 1000);
    getConfirmCancelOrderButton().click();
  }

}
