package base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utility.PropertyLoader;
import utility.ReadConfigKeys;

import java.net.URL;

public class BaseClassVariables {
    protected DesiredCapabilities dc;
    protected URL url;
    protected ReadConfigKeys rc;
    public AndroidDriver driver;
    protected static ThreadLocal<AndroidDriver> tdriver;
    protected Assertion assertion;
    protected PropertyLoader propertyLoader;
}
