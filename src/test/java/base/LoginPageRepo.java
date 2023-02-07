package base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPageRepo {
//    public AndroidDriver driver;

    @FindBy(className = "android.widget.EditText")
    private WebElement userNameTextBox;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Password']")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-LOGIN']/android.widget.TextView")
    private WebElement loginButton;

    @FindBy(className = "android.widget.TextView")
    private WebElement dashboardContext;

    public LoginPageRepo(AndroidDriver driver) {
//        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement userNameTextBox() {
        return userNameTextBox;
    }

    public WebElement passwordTextBox() {
        return passwordTextBox;
    }

    public WebElement loginButton() {
        return loginButton;
    }

    public WebElement getDashboardContext() {
        return dashboardContext;
    }

    public void assertDashboardContextIsDisplayed() {
        boolean displayed = getDashboardContext().isDisplayed();
        Assert.assertEquals(displayed, true);

    }

    public void loginToApp(String userName, String password) {
        userNameTextBox().sendKeys(userName);
        passwordTextBox().sendKeys(password);
    }

    /*public void autoFillCredentialsWithAvailableData() {
        driver.findElement(AppiumBy.androidUIAutomator
                (String.format("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"%s\").instance(0))", "standard_user"))).click();
    }*/
}

