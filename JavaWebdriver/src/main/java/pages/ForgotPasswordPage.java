package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private final WebDriver driver;

    private final By emailField;
    private final By retrievePasswordButton;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        emailField = By.id("email");
        retrievePasswordButton = By.id("form_submit");
    }

    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public EmailSentConfirmationPage clickRetrievePasswordButton() {
        driver.findElement(retrievePasswordButton).click();
        return new EmailSentConfirmationPage(driver);
    }
}
