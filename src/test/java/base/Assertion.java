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
    public void assertMessage(WebElement element, String expectedMessage) {
        boolean isShown = element.getText().contains(expectedMessage);
        Assert.assertEquals(isShown, true);
    }
}
