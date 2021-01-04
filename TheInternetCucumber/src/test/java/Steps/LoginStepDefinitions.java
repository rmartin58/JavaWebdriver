package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.Collections;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginStepDefinitions {

    WebDriver driver;
    private static final String baseUrl = "https://the-internet.herokuapp.com/";
    private static final String fileSeparator = File.separator;
    private static final String chromeDriverPath = System.getProperty("user.home") + fileSeparator + "src" + fileSeparator + "chromedriver";
    @Before
    public void setUp() {
        System.out.println(chromeDriverPath);
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver(getChromeOptions());
//        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
//        driver.register(new EventReporter());

        driver.get(baseUrl);
    }

    @Then("I am on the homepage")
    public void i_am_on_the_homepage() {
        assertEquals(driver.getTitle(), "The Internet");
        assertEquals(driver.getCurrentUrl(),baseUrl);
    }

    @When("I click the Form Authentication link")
    public void i_click_the_form_authentication_link() {
        driver.findElement(By.linkText("Form Authentication")).click();
    }

    @Then("I should be taken to the login page")
    public void i_should_be_taken_to_the_login_page() {
        assertEquals(driver.getCurrentUrl(),baseUrl+"login");
        assertTrue(driver.findElement(By.id("username")).isDisplayed());
        assertTrue(driver.findElement(By.id("password")).isDisplayed());
    }

    @When("I navigate back")
    public void i_navigate_back() {
        driver.navigate().back();
    }

    @When("I Login")
    public void i_login() {
        String userName = "tomsmith";
        String passWord = "SuperSecretPassword!";

        i_click_the_form_authentication_link();
        i_should_be_taken_to_the_login_page();
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(passWord);
        driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
    }

    @Then("I should be taken to the secure area page")
    public void i_should_be_taken_to_the_secure_area_page() {
        assertEquals(driver.getCurrentUrl(), baseUrl+"secure");
    }

    @Then("I should see the secure area alert")
    public void i_should_see_the_secure_area_alert() {
        By statusAlert = By.id("flash");
        String alertText = driver.findElement(statusAlert).getText();
        assertTrue(alertText.contains("You logged into a secure area!"));
    }

    @When("I Logout")
    public void i_logout() {
        driver.findElement(By.linkText("Logout")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
//        options.addArguments("--headless");
        return options;
    }

}
