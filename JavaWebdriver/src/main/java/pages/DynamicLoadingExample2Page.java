package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingExample2Page {

    private final WebDriver driver;
    private final By startButton = By.cssSelector("#start button");
    private final By loadedText = By.id("finish");

    public DynamicLoadingExample2Page(WebDriver driver){
        this.driver = driver;
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
