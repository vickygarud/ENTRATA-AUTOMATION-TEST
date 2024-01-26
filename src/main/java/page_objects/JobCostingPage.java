package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class JobCostingPage extends BasePage {

    public final By jobCostingHeading = By.xpath("//h1[normalize-space()='Job Costing']");

    public JobCostingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}

