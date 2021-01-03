package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailSentConfirmationPage {
    private final WebDriver driver;
    private final By textId;

    public EmailSentConfirmationPage(WebDriver driver) {
        this.driver = driver;
        textId = By.id("content");
    }

    public String getContentText() {
        return driver.findElement(textId).getText();
    }
}
