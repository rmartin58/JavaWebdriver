package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    private final WebDriver driver;
    private final By statusAlert;

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
        statusAlert = By.id("flash");
    }

    public String getAlertText(){
        return driver.findElement(statusAlert).getText();
    }
}
