package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {

    public final By loginButtons = By.xpath("//div[@class='button-holder']/a");

    public SignInPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Selects a login type for the user.
     *
     * @param loginType The type of login to be selected (e.g., "Property Manager Login" or "Resident Login").
     */
    public void selectUserLoginType(String loginType){
        generalMod.getElementFromList(loginButtons, loginType).click();
    }

}

