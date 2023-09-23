package screens;

import static glue.injector.util.switchToContext;
import com.google.inject.Inject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.cucumber.guice.ScenarioScoped;
import co.nvqa.appium.flutter.common.FlutterBy;
import co.nvqa.appium.flutter.driver.AppiumFlutterDriver;
import co.nvqa.appium.flutter.driver.FlutterElement;
@ScenarioScoped
public class WelcomeScreen extends BaseScreen {
  AppiumFlutterDriver driver;

  @Inject
  public WelcomeScreen(AppiumFlutterDriver driver) {
    super(driver);
    this.driver = driver;
  }

  private FlutterElement getSignUpButton() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.welcomeSignUpButton");
  }

  private WebElement getLogInButton() {
    switchToContext(driver,"NATIVE");
    String test = driver.getPageSource();
    //return driver.findElement(By.xpath("//android.view.View[@content-desc='Log in']"));
    return driver.findElement(new AppiumBy.ByAccessibilityId("Log in"));
    // return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.welcomeLoginButton");
  }

  private FlutterElement getUseAsGuestLink() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.guestLink");
  }

  public void tapLogIn() {
    getLogInButton().click();
  }

  public void signUp() {
    getSignUpButton().click();
  }

  public void useAsGuest() {
    getUseAsGuestLink().click();
  }

}
