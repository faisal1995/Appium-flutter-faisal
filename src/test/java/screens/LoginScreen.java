package screens;

import static glue.injector.util.switchToContext;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import co.nvqa.appium.flutter.common.FlutterBy;
import co.nvqa.appium.flutter.driver.AppiumFlutterDriver;
import co.nvqa.appium.flutter.driver.FlutterElement;

@ScenarioScoped
public class LoginScreen extends BaseScreen {
  AppiumFlutterDriver driver;

  @Inject
  public LoginScreen(AppiumFlutterDriver driver) {
    super(driver);
    this.driver = driver;
  }

  private FlutterElement getEmailTextBox() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.loginEmailField");
  }

  private FlutterElement getPasswordTextBox() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.loginPasswordField");
  }

  private FlutterElement getLoginButton() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.loginButton");
  }

  public void logIn(String email, String password){
    switchToContext(driver,"FLUTTER");
    getEmailTextBox().sendKeys(email);
    getPasswordTextBox().sendKeys(password);
    getLoginButton().click();

  }

}
