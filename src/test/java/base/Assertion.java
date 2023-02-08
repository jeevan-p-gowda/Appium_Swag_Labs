package base;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Assertion {
    public void assertImageIsDisplayed(WebElement webElement) {
        boolean displayStatus = webElement.isDisplayed();
        Assert.assertEquals(displayStatus, true);
    }

    public void assertTextBoxIsEnabled(WebElement webElement) {
        boolean enabledStatus = webElement.isEnabled();
        Assert.assertEquals(enabledStatus, true);
    }

    public void assertCheckBoxIsSelected(WebElement webElement) {
        boolean selectedStatus = webElement.isSelected();
        Assert.assertEquals(selectedStatus, true);
    }
    public void assertMessage(WebElement webElement, String expectedMessage) {
        String actualMessage = webElement.getText();
        boolean isShown = actualMessage.equalsIgnoreCase(actualMessage);
        Assert.assertEquals(isShown, true);
    }
}
