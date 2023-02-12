package base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utility.IConstantPath;
import utility.PropertyLoader;
import utility.ReadConfigKeys;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

//@Listeners({AllureListener.class})
public class BaseClass extends BaseClassVariables {
    @BeforeClass
    public void setUp() throws IOException {
        tdriver = new ThreadLocal<AndroidDriver>();
        propertyLoader=new PropertyLoader();
        propertyLoader.loadPropertyFile(IConstantPath.CONFIG_PROPERTY_FILE);
        dc = new DesiredCapabilities();
        dc.setCapability(propertyLoader.getDataFromPropertyFile(ReadConfigKeys.APPPACKAGE_KEY.convertToString()), propertyLoader.getDataFromPropertyFile(ReadConfigKeys.APPPACKAGE_VALUE.convertToString()));
        dc.setCapability(propertyLoader.getDataFromPropertyFile(ReadConfigKeys.APPACTIVITY_KEY.convertToString()), propertyLoader.getDataFromPropertyFile(ReadConfigKeys.APPACTIVITY_VALUE.convertToString()));

        url = new URL(propertyLoader.getDataFromPropertyFile(ReadConfigKeys.URL.convertToString()));

        driver = new AndroidDriver(url, dc);
        tdriver.set(driver);
//        tdriver.get();
        assertion=new Assertion();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static synchronized AndroidDriver getDriver() {
        return tdriver.get();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}