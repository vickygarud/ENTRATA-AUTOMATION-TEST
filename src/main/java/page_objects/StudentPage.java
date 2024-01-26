package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class StudentPage extends BasePage {

    public final By entrataStudentHeading = By.xpath("//h1[normalize-space()='Entrata Student']");

    public StudentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}

