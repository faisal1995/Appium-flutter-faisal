package screens;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import co.nvqa.appium.flutter.common.FlutterBy;
import co.nvqa.appium.flutter.driver.AppiumFlutterDriver;
import co.nvqa.appium.flutter.driver.FlutterElement;
import java.util.Map;
import org.openqa.selenium.interactions.Actions;

@ScenarioScoped
public class EstimateShippingFeeScreen extends BaseScreen {

  AppiumFlutterDriver driver;

  final static String FROM_SECTION_KEY = "KEYS.estimatorAddressDivisionFromSection";
  final static String TO_SECTION_KEY = "KEYS.estimatorAddressDivisionToSection";


  @Inject
  public EstimateShippingFeeScreen(AppiumFlutterDriver driver) {
    super(driver);
    this.driver = driver;
  }

  private FlutterElement getFromProvinceDropdown() {
    return driver.findElement(FlutterBy.VALUE_KEY, FROM_SECTION_KEY + "KEYS.ocCustomerProvinceDropdown");
  }

  private FlutterElement getFromDistrictDropdown() {
    return driver.findElement(FlutterBy.VALUE_KEY, FROM_SECTION_KEY + "KEYS.ocCustomerDistrictDropdown");
  }

  private FlutterElement getFromSubDistrictDropdown() {
    return driver.findElement(FlutterBy.VALUE_KEY, FROM_SECTION_KEY + "KEYS.ocCustomerSubDistrictDropdown");
  }

  private FlutterElement getToProvinceDropdown() {
    return driver.findElement(FlutterBy.VALUE_KEY, TO_SECTION_KEY + "KEYS.ocCustomerProvinceDropdown");
  }

  private FlutterElement getToDistrictDropdown() {
    return driver.findElement(FlutterBy.VALUE_KEY, TO_SECTION_KEY + "KEYS.ocCustomerDistrictDropdown");
  }

  private FlutterElement getToSubDistrictDropdown() {
    return driver.findElement(FlutterBy.VALUE_KEY, TO_SECTION_KEY + "KEYS.ocCustomerSubDistrictDropdown");
  }

  private FlutterElement getParcelWeight() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.ocParcelWeight");
  }


  public void fillInFromAddress(Map<String, String> fromAddress) {
    getFromProvinceDropdown().click();
    getDropdownItem(fromAddress.get("province")).click();
    getFromDistrictDropdown().click();
    getDropdownItem(fromAddress.get("district")).click();
    getFromSubDistrictDropdown().click();
    getDropdownItem(fromAddress.get("subDistrict")).click();
  }

  public void fillInToAddress(Map<String, String> toAddress) {
    scrollIntoView(getFromProvinceDropdown());
    getToProvinceDropdown().click();
    getDropdownItem(toAddress.get("province")).click();
    getToDistrictDropdown().click();
    getDropdownItem(toAddress.get("district")).click();
    getToSubDistrictDropdown().click();
    getDropdownItem(toAddress.get("subDistrict")).click();
  }

  public void setParcelWeight(int point) {
    Actions actions = new Actions(driver);
    actions.clickAndHold(getParcelWeight())
        .moveByOffset(0, getParcelWeight().getSize().getWidth()*(point/100))
        .build().perform();
  }
}
