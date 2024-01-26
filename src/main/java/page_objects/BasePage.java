package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.GeneralModule;

public class BasePage {

    public final By acceptCookieBtn = By.xpath("//button[@id='rcc-confirm-button']");
    public String baseUrl = System.getProperty("baseUrl");

    GeneralModule generalMod = new GeneralModule();
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method to navigate to a specified URL
     */
    public void navigateTo(String url) {
        driver.get(url);
    }

    /**
     * Method to click on a WebElement
     */
    public void clickOnElement(By locator) {
        driver.findElement(locator).click();
    }

    /**
     * Method to enter text into a text field
     */
    public void enterText(By locator, String text) {
        WebElement ele = driver.findElement(locator);
        ele.click();
        ele.sendKeys(text);
    }

    /**
     * Method to get the text of a WebElement
     */
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    /**
     * Method to wait for a specified duration (in seconds)
     *
     * @param seconds - no fo seconds
     */
    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * To accept cookie popup
     */
    public void handleCookiePopup() {
        WebElement acceptButton = driver.findElement(this.acceptCookieBtn);
        if (acceptButton.isDisplayed()) {
            acceptButton.click();
        }
    }


}
