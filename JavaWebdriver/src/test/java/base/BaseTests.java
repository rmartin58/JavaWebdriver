package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

public class BaseTests {
    protected static Logger logger = LogManager.getLogger(BaseTests.class.getSimpleName());

    protected static WebDriver driver;
    public HomePage homePage;

    private final String operatingSystemName;
    private final String operatingSystemVersion;
    private final String windowsChromeDriver;
    private final String macChromeDriver;
    private final String baseURL;

    public BaseTests() {
        operatingSystemName = System.getProperty("os.name");
        operatingSystemVersion = System.getProperty("os.version");
        windowsChromeDriver = "resources/chromedriver.exe";
        macChromeDriver = "resources/chromedriver";
        baseURL = "https://the-internet.herokuapp.com/";
    }

    @BeforeClass
    public void classSetUp() {
        logger.trace("*******************************");
        logger.info(String.format("OS name: %s", operatingSystemName));
        logger.info(String.format("OS version: %s", operatingSystemVersion));
        logger.info(String.format("Base URL: %s", baseURL));

        if (operatingSystemName.toLowerCase().contains("windows")) {
            logger.info(String.format("Setting Browser: %s",windowsChromeDriver));
            System.setProperty("webdriver.chrome.driver", windowsChromeDriver);
        } else {
            System.out.printf("Setting Browser: %s%n",macChromeDriver);
            System.setProperty("webdriver.chrome.driver", macChromeDriver);
        }

        driver = new ChromeDriver();
        driver.get(baseURL);
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void getOSDetails() {
        System.out.println(operatingSystemName);
        System.out.println(operatingSystemVersion);
    }

}
