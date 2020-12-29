package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileDownLoadPage {
    private WebDriver driver;

    public FileDownLoadPage(WebDriver driver) {
        this.driver = driver;
    }



    public void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }
}
