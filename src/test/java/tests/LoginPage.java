package tests;

import base.BaseClass;
import objectRepo.LoginPageRepo;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import utility.IConstantPath;
import utility.PropertyLoader;
import utility.ReadConfigKeys;
import utility.ReadLogin;

import java.io.IOException;

//@Listeners({AllureListener.class})
public class LoginPage extends BaseClass {
    private LoginPageRepo lp;
    private PropertyLoader pl;

    @Description("Verify the login by logging as standard user")
    @Epic("EP001")
    @Feature("Feature1:Login")
    @Story("Story: Should login as standard user")
    @Step("Verify login")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1, description = "Verify login")
    public void loginAsStandardUser() throws InterruptedException, IOException {
        //1.Arrange
        this.lp = new LoginPageRepo(driver);
        pl=new PropertyLoader();
        pl.loadPropertyFile(IConstantPath.LOGIN_PROPERTY_FILE);
        lp.loginToApp(pl.getDataFromPropertyFile(ReadLogin.STANDAR_USER.convertToString()),ReadLogin.PASSWORD.convertToString());
        Thread.sleep(2000);

        //2.Act
        lp.loginButton().click();
        Thread.sleep(2000);

        //3.Assert
        assertion.assertImageIsDisplayed(lp.getProductDashboardImage());
    }
}