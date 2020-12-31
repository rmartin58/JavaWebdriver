package base;

import com.google.common.io.Files;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.EventReporter;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class BaseTests {

    public static Logger logger = LogManager.getLogger(BaseTests.class.getSimpleName());

    public HomePage homePage;

    private final String operatingSystemName;
    private final String operatingSystemVersion;
    private final String windowsChromeDriver;
    private final String macChromeDriver;
    private final String baseURL;
    private EventFiringWebDriver driver;


    public BaseTests() {
        operatingSystemName = System.getProperty("os.name");
        operatingSystemVersion = System.getProperty("os.version");
        windowsChromeDriver = "resources/chromedriver.exe";
        macChromeDriver = "resources/chromedriver";
        baseURL = "https://the-internet.herokuapp.com/";
    }

    @BeforeSuite
    public void suiteSetUp() {
        logger.info("*******************************");
        logger.info(new Date().toString());
        logger.info(String.format("OS name: %s", operatingSystemName));
        logger.info(String.format("OS version: %s", operatingSystemVersion));
        logger.info(String.format("Base URL: %s", baseURL));

        if (operatingSystemName.toLowerCase().contains("windows")) {
            logger.info(String.format("Browser: %s", windowsChromeDriver.split("/")[1].split("\\.")[0]));
            System.setProperty("webdriver.chrome.driver", windowsChromeDriver);
        } else {
            logger.info(String.format("Browser: %s", macChromeDriver));
            System.setProperty("webdriver.chrome.driver", macChromeDriver);
        }
    }

    @AfterSuite
    public void suiteClose() {
        Date endDate = new Date();
        logger.info(String.format("TestSuite Complete: %s", endDate));
        logger.info("*******************************\n");
    }

    @BeforeClass
    public void classSetUp() {
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    @BeforeMethod
    public void goHome() {
        driver.get(baseURL);
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return options;
    }
}
