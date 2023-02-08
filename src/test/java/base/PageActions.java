package base;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class PageActions {
public void scrollToAnElementByText(String text, AndroidDriver driver) {
        driver.findElement(AppiumBy.androidUIAutomator
                (String.format("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"%s\").instance(0))", text)));
    }
}
