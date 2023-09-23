package screens;

import static glue.injector.util.switchToContext;
import com.google.inject.Inject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import io.appium.java_client.MobileBy;
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

  private WebElement getEmailTextBox() {
    //return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.loginEmailField");
//    return driver.findElement(By.xpath("//android.widget.EditText[1]"));
    return driver.findElement(By.xpath("//android.widget.EditText[1]"));

  }

  private WebElement getPasswordTextBox() {
//    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.loginPasswordField");
    return driver.findElement(By.xpath("//android.widget.EditText[2]"));

  }

  private WebElement getLoginButton() {
//    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.loginButton");
    return driver.findElement(By.xpath("//android.view.View[@content-desc='Log in']"));

  }

  public void logIn(String email, String password){
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    getEmailTextBox().sendKeys(email);
    //List<WebElement> elements =  driver.findElements(By.xpath("//android.widget.EditText"));
    getPasswordTextBox().click();
    getPasswordTextBox().sendKeys(password);
    getLoginButton().click();
    switchToContext(driver,"FLUTTER");


  }

}
