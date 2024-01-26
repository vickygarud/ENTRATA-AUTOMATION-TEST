package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.GeneralModule;

public class HomePage extends BasePage {

    public final By menuList = By.xpath("//div[@class='main-nav-link']");
    private final By dropDownList = By.xpath("//a[@class='fat-nav-links']");
    GeneralModule generalModule = new GeneralModule();

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * To navigate entrata home page
     */
    public void navigateToHomePage() {
        navigateTo(baseUrl);
    }

    /**
     * To select dropdown option from home page header section
     * @param menuOption - menu heading
     * @param dropdownOption - dropdown options
     */
    public void selectDropdownOptionFromMenu(String menuOption, String dropdownOption) {
        WebElement menuOptionELe = generalModule.getElementFromList(this.menuList, menuOption);
        generalModule.hoverOverElement(menuOptionELe);
        generalModule.getElementFromList(this.dropDownList, dropdownOption).click();
    }


}
