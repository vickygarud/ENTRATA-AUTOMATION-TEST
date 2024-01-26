package Tests.base_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import util.GeneralModule;

public class BaseTest {

    public WebDriver driver;

    public GeneralModule generalMod;


    /**
     * Assertion method to check if a condition is true
     */
    public void assertTrue(String message, boolean condition) {
        Assert.assertTrue(condition, message);
    }

    /**
     * Assertion method to check if two values are equal
     */
    public void assertEquals(String message, Object expected, Object actual) {
        Assert.assertEquals(actual, expected, message);
    }

    /**
     * Assertion method to verify if a string contains another string
     */
    public void assertContains(String message, String actual, String expected) {
        assertTrue(message, actual.contains(expected));
    }

    public void verifyInputValueByLabel(String label, String expectedValue) {
        WebElement labelElement = driver.findElement(By.xpath("//label[text()='" + label + "']"));
        WebElement inputField = labelElement.findElement(By.xpath("./parent::div/input"));
        String actualValue = inputField.getAttribute("value");
        this.assertTrue("Expected value is equal to actual value", actualValue.equals(expectedValue));
    }
    public boolean isElementTextEqualToExpected(By locator, String expectedText) {
        WebElement element = driver.findElement(locator);
        String actualText = element.getText();
        return actualText.equals(expectedText);
    }

}
