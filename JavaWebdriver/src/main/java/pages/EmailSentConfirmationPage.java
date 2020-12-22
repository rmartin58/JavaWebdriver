package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailSentConfirmationPage {
    private WebDriver driver;

    public EmailSentConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getContentText() {
        return driver.findElement(By.id("content")).getText();
    }
}
