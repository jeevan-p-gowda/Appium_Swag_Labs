package tests;

import base.BaseClass;
import base.PageActions;
import io.qameta.allure.*;
import objectRepo.LoginPageRepo;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.IConstantPath;
import utility.PropertyLoader;

import java.io.IOException;

//@Listeners({AllureListener.class})
public class LoginPage extends BaseClass {
    private LoginPageRepo lp;
    private PropertyLoader pl;
    private PageActions pa;

    @BeforeMethod
    public void beforeMethod() throws IOException {
        this.lp = new LoginPageRepo(driver);
        pl = new PropertyLoader();
        pl.loadPropertyFile(IConstantPath.LOGIN_PROPERTY_FILE);
        pa = new PageActions();
    }

    @Description("Verify the login by logging as standard user")
    @Epic("EP001")
    @Feature("Feature1:Login")
    @Story("Story: Should login as standard user")
    @Step("Verify login")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1, description = "Verify login")
    public void loginAsStandardUser() throws InterruptedException {
        //1.Arrange
//        lp.loginToApp(pl.getDataFromPropertyFile(ReadLogin.STANDARD_USER.convertToString()),ReadLogin.PASSWORD.convertToString());
        pa.scrollToAnElementByText("standard_user", driver).click();

        //2.Act
        lp.loginButton().click();

        //3.Assert
        Thread.sleep(2000);
        assertion.assertImageIsDisplayed(lp.getProductDashboardImage());
    }

    @Description("Verify the login by logging as locked out user")
    @Epic("EP001")
    @Feature("Feature1:Login")
    @Story("Story: Should login as locked out user")
    @Step("Verify login")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 2, description = "Verify login")
    public void loginAsLockedOutUser() throws InterruptedException {
        //1.Arrange
        pa.scrollToAnElementByText("locked_out_user", driver).click();

        //2.Act
        lp.loginButton().click();

        //3.Assert
        Thread.sleep(2000);
        assertion.assertMessage(lp.getErrorMessage(), "Sorry, this user has been locked out.");
    }
}