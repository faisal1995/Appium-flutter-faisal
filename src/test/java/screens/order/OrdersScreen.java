package screens.order;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import co.nvqa.appium.flutter.common.FlutterBy;
import co.nvqa.appium.flutter.driver.AppiumFlutterDriver;
import co.nvqa.appium.flutter.driver.FlutterElement;
import screens.BaseScreen;

@ScenarioScoped
public class OrdersScreen extends BaseScreen {

  AppiumFlutterDriver driver;

  @Inject
  public OrdersScreen(AppiumFlutterDriver driver) {
    super(driver);
    this.driver = driver;
  }

  private FlutterElement getSearchOrderButton() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.searchOrderButton");
  }

  private FlutterElement getSearchTextBox() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.searchOrderField");
  }

  private FlutterElement getFirstItemFromOrderList() {
     return driver.findDescendantElement(
        driver.findElement(FlutterBy.TYPE, "DefaultRefreshIndicator"),
        driver.findElement(FlutterBy.TYPE, "AkiraListItem"),
        false,
        true);
  }

  public void searchOrder(String searchText) {
    getSearchOrderButton().click();
    getSearchTextBox().sendKeys(searchText);
    doneKeyboard();
    //To implement TextInputAction
    //https://github.com/flutter/flutter/blob/master/packages/flutter_driver/lib/src/common/text_input_action.dart
  }

  public void tabOnAnyOrderInList() {
    getFirstItemFromOrderList().click();
  }

}
