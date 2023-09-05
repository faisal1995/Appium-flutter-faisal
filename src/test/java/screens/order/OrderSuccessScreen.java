package screens.order;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import co.nvqa.appium.flutter.common.FlutterBy;
import co.nvqa.appium.flutter.driver.AppiumFlutterDriver;
import co.nvqa.appium.flutter.driver.FlutterElement;
import screens.BaseScreen;

@ScenarioScoped
public class OrderSuccessScreen extends BaseScreen {
  AppiumFlutterDriver driver;

  @Inject
  public OrderSuccessScreen(AppiumFlutterDriver driver) {
    super(driver);
    this.driver = driver;
  }

  private FlutterElement getCloseButton() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.ocSuccessCloseButton");
  }

  public void closeButton() {
    getCloseButton().click();
  }

}
