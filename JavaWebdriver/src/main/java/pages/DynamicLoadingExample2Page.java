package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingExample2Page {

    private final WebDriver driver;
    private final By startButton;
    private final By loadedText;

    public DynamicLoadingExample2Page(WebDriver driver){
        this.driver = driver;
        startButton = By.cssSelector("#start button");
        loadedText = By.id("finish");
    }

    public void clickStartWaitForPresence(){
        driver.findElement(startButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(loadedText));
    }

    public String getLoadedText(){
        return driver.findElement(loadedText).getText();
    }
}
