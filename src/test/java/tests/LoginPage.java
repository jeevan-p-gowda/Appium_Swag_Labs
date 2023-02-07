package tests;

import base.BaseClass;
import base.LoginPageRepo;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class LoginPage extends BaseClass {
    private LoginPageRepo lp;

    @Description("Verify the login by logging as standard user")
    @Epic("EP001")
    @Feature("Feature1:Login")
    @Story("Story: Should login as standard user")
    @Step("Verify login")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1, description = "Verify login")
    public void loginAsStandardUser() throws InterruptedException {
        //1.Arrange
        this.lp = new LoginPageRepo(driver);
        lp.loginToApp("standard_user", "secret_sauce");
//        driver.findElement(AppiumBy.androidUIAutomator
//                (String.format("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"%s\").instance(0))", "standard_user"))).click();
////        lp.autoFillCredentialsWithAvailableData();
        Thread.sleep(2000);

        //2.Act
        lp.loginButton().click();
        Thread.sleep(2000);

        //3.Assert
        lp.assertDashboardContextIsDisplayed();
    }
}