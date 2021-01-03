package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailSentConfirmationPage {
    private final WebDriver driver;
    private final By textId = By.id("content");

    public EmailSentConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getContentText() {
        return driver.findElement(textId).getText();
    }
}
