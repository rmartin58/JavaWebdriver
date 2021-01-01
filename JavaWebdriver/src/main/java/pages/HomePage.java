package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private final String formAuthentication = "Form Authentication";
    private final String dropDown = "Dropdown";
    private final String forgotPassword = "Forgot Password";
    private final String hovers = "Hovers";
    private final String checkboxes = "Checkboxes";
    private final String fileUpload = "File Upload";
    private final String fileDownLoad = "File Download";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public LoginPage clickFormAuthentication() {
        clickLink(formAuthentication);
        return new LoginPage(driver);
    }

    public DropdownPage clickDropDown() {
        clickLink(dropDown);
        return new DropdownPage(driver);
    }

    public ForgotPasswordPage clickForgotPassword() {
        clickLink(forgotPassword);
        return new ForgotPasswordPage(driver);
    }

    public HoversPage clickHovers() {
        clickLink(hovers);
        return new HoversPage(driver);
    }

    public CheckBoxPage clickCheckBox() {
        clickLink(checkboxes);
        return new CheckBoxPage(driver);
    }

    public FileUpLoadPage clickFileUpload() {
        clickLink(fileUpload);
        return new FileUpLoadPage(driver);
    }

    public FileDownLoadPage clickFileDownLoad() {
        clickLink(fileDownLoad);
        return new FileDownLoadPage(driver);
    }

    public ContextMenuPage clickContextMenu() {
        clickLink("Context Menu");
        return new ContextMenuPage(driver);
    }

    public AlertsPage clickJavaScriptAlerts() {
        clickLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoading(){
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }

    public MultipleWindowsPage clickMultipleWindows() {
        clickLink("Multiple Windows");
        return new MultipleWindowsPage(driver);
    }
}
