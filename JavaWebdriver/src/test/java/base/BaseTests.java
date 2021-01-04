package base;

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
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;

import static com.google.common.io.Files.move;

public class BaseTests {

    protected final Logger logger = LogManager.getLogger(BaseTests.class.getName());
    private final String screenshotsDir = ("screenshots" + File.separator);

    public HomePage homePage;
    private final String operatingSystemName;
    private final String operatingSystemVersion;
    private final String fileSeparator;
    private final String webdriverDir;

    private final String baseURL;
    private EventFiringWebDriver driver;


    public BaseTests() {
        operatingSystemName = System.getProperty("os.name");
        operatingSystemVersion = System.getProperty("os.version");
        baseURL = "https://the-internet.herokuapp.com/";
        fileSeparator = File.separator;
        webdriverDir = System.getProperty("user.home") + fileSeparator + "src" + fileSeparator;
    }

    @BeforeSuite
    public void suiteSetUp() {
        logger.trace("this is a trace msg");
        logger.debug("this is a debug msg");
        logger.info("this is an info msg");
        logger.warn("this is a warning msg");
        logger.error("this is an error msg");
        logger.fatal("this is a fatal msg");

        logger.info("*******************************");
        logger.info(new Date().toString());
        logger.info(String.format("OS name: %s", operatingSystemName));
        logger.info(String.format("OS version: %s", operatingSystemVersion));
        logger.info(String.format("Base URL: %s", baseURL));

        String chromedriver = "chromedriver";
        if (operatingSystemName.toLowerCase().contains("windows")) {
            logger.info(String.format("Browser: %s.exe", chromedriver));
            System.setProperty("webdriver.chrome.driver", webdriverDir + chromedriver +".exe");
        } else {
            logger.info(String.format("Browser: %s", chromedriver));
            System.setProperty("webdriver.chrome.driver", webdriverDir + chromedriver);
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
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss.SSSS");
        LocalDateTime localDateTime = LocalDateTime.now();
        String ldtString = FORMATTER.format(localDateTime);
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                move(screenshot, new File(screenshotsDir + ldtString + "." + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
//        options.addArguments("--headless");
        return options;
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }
}
