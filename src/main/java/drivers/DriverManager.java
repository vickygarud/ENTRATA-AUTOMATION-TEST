package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverManager {

    private static WebDriver driver;
    public static ThreadLocal<WebDriver> driverThread = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver(String browserName) {
        if (driver == null) {
            initializeDriver(browserName);
        }
        return driverThread.get();
    }

    private static void initializeDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--window-size=1280,720");
                chromeOptions.addArguments("--disable-notifications");
                WebDriverManager.chromedriver().setup();
                driverThread.set(new ChromeDriver(chromeOptions));
                driverThread.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
                break;
            case "firefox":
                driver = WebDriverManager.firefoxdriver().create();
                break;
            case "edge":
                driver = WebDriverManager.edgedriver().create();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser: " + browser);
        }
    }

    public static void quitDriver() {
        if (driverThread.get() != null) {
            driverThread.get().quit();
            driverThread.set(null);
        }
    }

}
