package screens.order;

import static glue.injector.util.switchToContext;
import com.google.inject.Inject;

import co.nvqa.appium.flutter.common.Command;
import io.appium.java_client.android.nativekey.AndroidKey;
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
    switchToContext(driver,"NATIVE");
    driver.executeScript("Search "+searchText);
//    Command command1 = Command.valueOf("Search "+searchText);
//    driver.getCommandExecutor().execute(command1);

//    doneKeyboardNative();
//   switchToContext(driver,"FLUTTER");
    //doneKeyboard();
    //To implement TextInputAction
    //https://github.com/flutter/flutter/blob/master/packages/flutter_driver/lib/src/common/text_input_action.dart
  }

  public void tabOnAnyOrderInList() {
    getFirstItemFromOrderList().click();
  }

}
