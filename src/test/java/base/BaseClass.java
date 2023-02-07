package base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utility.ReadConfig;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    private DesiredCapabilities dc;
    private URL url;
    private ReadConfig rc;
    public AndroidDriver driver;
    public static ThreadLocal<WebDriver> tdriver;

    @BeforeClass
    public void setUp() throws InterruptedException, MalformedURLException {
        tdriver = new ThreadLocal<WebDriver>();
        rc = new ReadConfig();

        dc = new DesiredCapabilities();
//        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
//        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
////      dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, 10.0);
//        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");

        dc.setCapability("appPackage", "com.swaglabsmobileapp");
        dc.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");

        url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(url, dc);
        tdriver.set(driver);
//        tdriver.get();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(2000);
    }

    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
