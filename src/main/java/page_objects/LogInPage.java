package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends BasePage {

    public final By usernameField = By.id("entrata-username");
    public final By passwordField = By.id("entrata-password");
    public final By signInBtn = By.xpath("//button[@type='submit']");
    public final By invalidCredentialsErrorMsg = By.xpath("//p[@id='statusMessage']");

    public LogInPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void login(String username, String password){
        generalMod.waitForElementClickable(usernameField,10);
        enterText(usernameField, username);
        generalMod.waitForElementClickable(passwordField,10);
        enterText(passwordField, password);
        clickOnElement(signInBtn);
    }

}

