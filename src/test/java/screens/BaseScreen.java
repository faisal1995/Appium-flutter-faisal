package screens;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;

import co.nvqa.appium.flutter.command.FlutterCommand;
import co.nvqa.appium.flutter.common.Command;
import io.cucumber.guice.ScenarioScoped;
import co.nvqa.appium.flutter.common.FlutterBy;
import co.nvqa.appium.flutter.driver.AppiumFlutterDriver;
import co.nvqa.appium.flutter.driver.FlutterElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.TimeoutException;

@ScenarioScoped
public class BaseScreen {

  AppiumFlutterDriver driver;
  protected FlutterCommand command;

  @Inject
  public BaseScreen(AppiumFlutterDriver driver) {
    this.driver = driver;
    this.command = new FlutterCommand(driver);
  }

  public void doneKeyboard() {
    Map<String, Object> params = new HashMap<>();
    params.put("action", "done");
    driver.executeScript("flutter:setTextEntryEmulation", true);
    driver.executeScript("flutter:sendTextInputAction", "done");
  }

  protected FlutterElement getDropdownItem(String itemName) {
    String itemKeyName = String.format("KEYS.generalSearchItemScreen %s", itemName);
    FlutterElement item = driver.findElement(FlutterBy.VALUE_KEY, itemKeyName);
    scrollIntoView(item);
    return item;
  }

  protected FlutterElement scrollIntoView(FlutterElement element) {
    command.execute(Command.SCROLL_INFO_VIEW, element, ImmutableMap.of("alignment", 0.1));
//    driver.executeScript("flutter:scrollIntoView", element, new HashMap<String, Object>() {{
//      put("alignment", 0.1);
//    }});
    return element;
  }

  public boolean isTextDisplayed(String text) {
    try {
      command.execute(Command.WAIT_FOR, driver.findElement(FlutterBy.TEXT, text), 5000);
      //driver.executeScript("flutter:waitFor", driver.findElement(FlutterBy.TEXT, text), 5000);
      return true;
    } catch (TimeoutException e) {
      return false;
    }
  }

  public boolean isElementDisplayed(FlutterElement element){
    try {
      command.execute(Command.WAIT_FOR, element, 5000);
      return true;
    }catch (Exception e){
      return false;
    }
  }

  public boolean isTextDisplayed(List<String> texts) {
    try {
      texts.forEach(text -> {
        command.execute(Command.WAIT_FOR, driver.findElement(FlutterBy.TEXT, text), 5000);
        //driver.executeScript("flutter:waitFor", driver.findElement(FlutterBy.VALUE_KEY, text));
      });
      return true;
    } catch (TimeoutException e) {
      return false;
    }
  }

  private FlutterElement getHomeNav() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.homeBottomNavBarHome");
  }

  private FlutterElement getOrdersNav() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.homeBottomNavBarOrders");
  }

  private FlutterElement getShippingNav() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.homeBottomNavBarShipping");
  }

  private FlutterElement getPaymentsNav() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.homeBottomNavBarPayments");
  }

  private FlutterElement getAccountNav() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.homeBottomNavBarAccount");
  }

  public boolean navigateUsingBottomNav(String navBar) {
    switch (navBar) {
      case "Home":
        getHomeNav().click();
        return isTextDisplayed("Welcome");
      case "Orders":
        getOrdersNav().click();
        return isTextDisplayed("Orders");
      case "Shipping":
        getShippingNav().click();
        return isTextDisplayed("Shipping");
      case "Payments":
        getPaymentsNav().click();
        return isTextDisplayed("Payments");
      case "Account":
        getAccountNav().click();
        return isTextDisplayed("Account");
      default:
        return false;
    }
  }

}
