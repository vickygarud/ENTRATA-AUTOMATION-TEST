package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WatchDemoPage extends BasePage {

    public final By unitCountDropdown = By.id("Unit_Count__c");

    public WatchDemoPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}

