package base;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class PageActions {
public WebElement scrollToAnElementByText(String text, AndroidDriver driver) {
       return driver.findElement(AppiumBy.androidUIAutomator
                (String.format("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"%s\").instance(0))", text)));
    }
}
