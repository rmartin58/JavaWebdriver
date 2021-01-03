package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUpLoadPage {
    private final WebDriver driver;
    private final By inputField;
    private final By uploadButton;
    private final By uploadedFiles;


    public FileUpLoadPage(WebDriver driver) {
        this.driver = driver;
        inputField = By.id("file-upload");
        uploadButton = By.id("file-submit");
        uploadedFiles = By.id("uploaded-files");
    }

    public void clickUploadButton() {
        driver.findElement(uploadButton).click();
    }

    public void uploadFile(String absolutePathOfFile) {
        driver.findElement(inputField).sendKeys(absolutePathOfFile);
        clickUploadButton();
    }


    public String getUploadedFiles() {
        return driver.findElement(uploadedFiles).getText();
    }
}
