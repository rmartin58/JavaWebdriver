package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final By usernameField;
    private final By passwordField;
    private final By loginButton;
    private final By statusAlert;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        usernameField = By.id("username");
        passwordField = By.id("password");
        loginButton = By.cssSelector("#login button");
        statusAlert = By.id("flash");
    }

    public void setUsernameField(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public SecureAreaPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }

    public String getAlertText() {
        return driver.findElement(statusAlert).getText();
    }
}

