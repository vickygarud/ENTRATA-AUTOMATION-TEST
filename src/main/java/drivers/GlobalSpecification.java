package drivers;

import org.openqa.selenium.WebDriver;

public class GlobalSpecification{

    public static WebDriver driver;


    /**
     * To Sets up the WebDriver.
     * Throws an exception if the driver failed to create.
     */
    public static void setup() {
        try {
            String browserName = System.getProperty("browserName");
            driver = DriverManager.getDriver(browserName);
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("/n Failed to create the driver! : " + exception);
        }
    }

    /**
     * Tears down the driver
     */
    public static void teardown() {
        try {
            DriverManager.quitDriver();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("/n Failed to quit the driver! : " + exception);
            driver.quit();
        }
    }

}
