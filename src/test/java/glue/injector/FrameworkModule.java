package glue.injector;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import co.nvqa.appium.flutter.driver.AppiumFlutterDriver;
import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.guice.ScenarioScoped;
import java.net.URL;
import java.time.Duration;

public final class FrameworkModule extends AbstractModule {


  @Provides
  @ScenarioScoped
  AppiumFlutterDriver providesDriverInstance() throws Exception {
    AppiumDriverLocalService service = new AppiumServiceBuilder()
        .usingAnyFreePort().build();
    service.start();
    if (service == null || !service.isRunning()) {
      throw new AppiumServerHasNotBeenStartedLocallyException(
          "An appium server node is not started!");
    }
    BaseOptions options = new BaseOptions()
        .setPlatformName("Android")
        .setAutomationName("Flutter")
        .setNewCommandTimeout(Duration.ofSeconds(0))
        //.setNoReset(true)
        .amend("unlockType", "pin")
        .amend("unlockKey", "0303")
        .amend("appium:app",
            "/Users/faisal/Downloads/app-qa-debug-veera.apk")
        .amend("autoGrantPermissions", "true");
    AppiumFlutterDriver driver = new AppiumFlutterDriver(service.getUrl(), options);
    return driver;
  }

//  @Provides
//  @ScenarioScoped
//  @Inject
//  FlutterFinder providesFlutterFinder(AppiumDriver driver) {
//    FlutterFinder flutter = new FlutterFinder(driver);
//    return flutter;
//  }

}




