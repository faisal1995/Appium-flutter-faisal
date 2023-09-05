package glue.injector;

import java.util.ArrayList;
import java.util.Set;

import co.nvqa.appium.flutter.driver.AppiumFlutterDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.SupportsContextSwitching;

public class util {
    public static void switchToContext(AppiumFlutterDriver driver, String switchTo) {
        Set<String> contexts = ((SupportsContextSwitching) driver).getContextHandles();
        System.out.println("CONTEXT=" + contexts);  //prints CONTEXT=[NATIVE_APP, WEBVIEW_chrome]
        for (String context : contexts) {
            if (context.contains(switchTo)) {
                ((SupportsContextSwitching) driver).context(context);
                break;
            }
        }
    }

    public static String getAlphaNumericString(int n) {

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }


}
