package ui.utils;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverUtils {

    private static WebDriver driver;

    private DriverUtils(){}

    public static WebDriver getDriver(){
        String browser = ConfigReader.readProperty("browser");
        String remoteUrl = "http://54.172.206.147:4444";
        if (driver == null){
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "chromeremote":
                    File chromeFile = new File("C:\\Users\\Administrator\\Downloads\\chromedriver.exe");
                    System.setProperty("webdriver.chrome.driver", chromeFile.getAbsolutePath());
                    DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
                    chromeCapabilities.setBrowserName("chrome");
                    chromeCapabilities.setPlatform(Platform.ANY);
                    try {
                        driver = new RemoteWebDriver(new URL(remoteUrl), chromeCapabilities);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "firefoxremote":
                    File firefoxFile = new File("C:\\Users\\Administrator\\Downloads\\geckodriver.exe");
                    System.setProperty("webdriver.gecko.driver", firefoxFile.getAbsolutePath());
                    DesiredCapabilities firefoxCapabilities = DesiredCapabilities.firefox();
                    firefoxCapabilities.setBrowserName("firefox");
                    firefoxCapabilities.setPlatform(Platform.ANY);
                    try {
                        driver = new RemoteWebDriver(new URL(remoteUrl), firefoxCapabilities);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }
        return driver;
    }

    public static void tearDown(){
        driver.quit();
        driver = null;
    }
}
