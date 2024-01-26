package util;

import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class GeneralModule {

    public final By watchDemoBtn = By.xpath("//div[@class='button-holder']/a");
    public final By signInBtn = By.xpath("//a[@class='button-default outline-dark-button']");

    private WebDriver driver;


    public GeneralModule() {
        this.driver = DriverManager.driverThread.get();
    }

    /**
     * Performs a hover action on a given WebElement.
     *
     * @param target WebElement to hover over
     */
    public void hoverOverElement(WebElement target) {
        Actions actions = new Actions(driver);
        actions.moveToElement(target).perform();
    }

    /**
     * Wait for element to be clickable
     */
    public void waitForElementClickable(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement getElementFromList(By locator, String elementText) {
        return driver.findElements(locator).stream().filter(element -> element.getText().contains(elementText)).findAny().orElse(null);
    }

    public void enterValueByLabel(String label, String text) {
        WebElement labelElement = driver.findElement(By.xpath("//label[text()='" + label + "']"));
        WebElement inputField = labelElement.findElement(By.xpath("./parent::div/input"));
        inputField.sendKeys(text);
    }

    public boolean verifyElementIsDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public void clickOnWatchDemoBtn() {
        this.waitForElementClickable(this.watchDemoBtn, 10);
        driver.findElement(this.watchDemoBtn).click();
    }

    public void clickOnSignInBtn() {
        waitForElementClickable(this.signInBtn, 10);
        WebElement ele = driver.findElement(this.signInBtn);
        scrollToElement(ele);
        ele.click();
    }

    public void selectValueFromDropdown(By locator, String value) {
        WebElement dropdownElement = driver.findElement(locator);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(value);
    }

    public void scrollToElement(WebElement element) {
        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
