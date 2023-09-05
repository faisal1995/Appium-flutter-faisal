package screens.order;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import co.nvqa.appium.flutter.common.FlutterBy;
import co.nvqa.appium.flutter.driver.AppiumFlutterDriver;
import co.nvqa.appium.flutter.driver.FlutterElement;
import java.util.Map;
import screens.BaseScreen;

@ScenarioScoped
public class OrderCreateScreen extends BaseScreen {

  AppiumFlutterDriver driver;

  @Inject
  public OrderCreateScreen(AppiumFlutterDriver driver) {
    super(driver);
    this.driver = driver;
  }

  private FlutterElement getContactTextBox() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.phoneNumberField");
  }

  private FlutterElement getNameTextBox() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.ocCustomerNameField");
  }

  private FlutterElement getEmailTextBox() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.ocCustomerEmailField");
  }

  private FlutterElement getProvinceDropdown() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.ocCustomerProvinceDropdown");
  }

  private FlutterElement getDistrictDropdown() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.ocCustomerDistrictDropdown");
  }

  private FlutterElement getSubDistrictDropdown() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.ocCustomerSubDistrictDropdown");
  }

  private FlutterElement getAddressLine1TextBox() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.ocCustomerAddress1Field");
  }

  private FlutterElement getAddressLine2TextBox() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.ocCustomerAddress2Field");
  }

  private FlutterElement getAddToAddressBookCheckbox() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.saveRecipientInformationCheckBox");
  }

  private FlutterElement getDriverInstructionsTextBox() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.ocPickupLocationInstructions");
  }

  private FlutterElement getRequestedTrackingIdTextBox() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.ocRequestedTidInput");
  }

  private FlutterElement getParcelSizeButton(String parcelSize) {

    String parcelKey = String.format("KEYS.ocParcelSize%s", parcelSize);
    return driver.findElement(FlutterBy.VALUE_KEY, parcelKey);
  }

  private FlutterElement getSpecifyDimensionsLink() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.ocSpecifyDimension");
  }

  private FlutterElement getWidthTextBox() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.ocSpecifyDimensionWidth");
  }

  private FlutterElement getHeightTextBox() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.ocSpecifyDimensionHeight");
  }

  private FlutterElement getLengthTextBox() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.ocSpecifyDimensionLength");
  }

  private FlutterElement getDimensionDoneButton() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.ocSpecifyDimensionDone");
  }

  private FlutterElement getInsuranceToggle() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.toggleInsurance");
  }

  private FlutterElement getTotalParcelValueTextBox() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.ocItemValue");
  }


  private FlutterElement getWhatInsideParcelLink() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.ocItemContentLink");
  }

  private FlutterElement getParcelContentTextBox() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.parcelContentDetailsInput");
  }

  private FlutterElement getConfirmContentButton() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.parcelContentConfirmButton");
  }

  private FlutterElement getDangerousGoodsCheckbox() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.ocCheckboxNotDangerousGoods");
  }

  private FlutterElement getCreateOrderButton() {
    return driver.findElement(FlutterBy.VALUE_KEY, "KEYS.ocCreateOrderButton");
  }


  public void fillInCustomerDetails(Map<String, String> info) {
    getContactTextBox().sendKeys(info.get("contact"));
    getNameTextBox().sendKeys(info.get("name"));
    getEmailTextBox().sendKeys(info.get("emailId"));
    getProvinceDropdown().click();
    getDropdownItem(info.get("province")).click();
    getDistrictDropdown().click();
    getDropdownItem(info.get("district")).click();
    getSubDistrictDropdown().click();
    getDropdownItem(info.get("subDistrict")).click();
    scrollIntoView(getAddressLine1TextBox()).sendKeys(info.get("addressLine1"));
    getAddressLine2TextBox().sendKeys(info.get("addressLine2"));
    getAddToAddressBookCheckbox().click();
    //getDriverInstructionsTextBox().sendKeys(info.get("instructions"));
  }

  public void fillInParcelDetails(Map<String, String> parcel) {
    scrollIntoView(getRequestedTrackingIdTextBox());
    if(parcel.containsKey("trackingId"))
      getRequestedTrackingIdTextBox().sendKeys(parcel.get("trackingId"));
    if(parcel.containsKey("parcelSize"))
      getParcelSizeButton(parcel.get("parcelSize")).click();
  }

  public void specifyDimensions(Map<String, String> dim) {
    scrollIntoView(getSpecifyDimensionsLink());
    getSpecifyDimensionsLink().click();
    if(dim.containsKey("width"))
      getWidthTextBox().sendKeys(dim.get("width"));
    if(dim.containsKey("height"))
      getHeightTextBox().sendKeys(dim.get("height"));
    if(dim.containsKey("length"))
      getLengthTextBox().sendKeys(dim.get("length"));
    getDimensionDoneButton().click();
  }

  public void addParcelContent(String content) {
    scrollIntoView(getWhatInsideParcelLink());
    getWhatInsideParcelLink().click();
    getParcelContentTextBox().sendKeys(content);
    getConfirmContentButton().click();
  }

  public void addInsuranceValue(String totalValue) {
    scrollIntoView(getInsuranceToggle());
    getInsuranceToggle().click();
    getTotalParcelValueTextBox().sendKeys(totalValue);
  }

  public void checkDangerousGoods() {
    scrollIntoView(getDangerousGoodsCheckbox());
    getDangerousGoodsCheckbox().click();
  }

  public void createOrder() {
    scrollIntoView(getCreateOrderButton());
    getCreateOrderButton().click();
  }

}
