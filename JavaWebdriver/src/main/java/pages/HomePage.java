package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;
    private final String formAuthenticationLink;
    private final String dropDownLink;
    private final String forgotPasswordLink;
    private final String hoversLink;
    private final String checkboxesLink;
    private final String fileUploadLink;
    private final String fileDownLoadLink;
    private final String contextMenuLink;
    private final String jsAlertsLink;
    private final String dynamicLoadingLink;
    private final String multipleWindowsLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        formAuthenticationLink = "Form Authentication";
        dropDownLink = "Dropdown";
        forgotPasswordLink = "Forgot Password";
        hoversLink = "Hovers";
        checkboxesLink = "Checkboxes";
        fileUploadLink = "File Upload";
        fileDownLoadLink = "File Download";
        contextMenuLink = "Context Menu";
        jsAlertsLink = "JavaScript Alerts";
        dynamicLoadingLink = "Dynamic Loading";
        multipleWindowsLink = "Multiple Windows";
    }

    private void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public LoginPage clickFormAuthentication() {
        clickLink(formAuthenticationLink);
        return new LoginPage(driver);
    }

    public DropdownPage clickDropDown() {
        clickLink(dropDownLink);
        return new DropdownPage(driver);
    }

    public ForgotPasswordPage clickForgotPassword() {
        clickLink(forgotPasswordLink);
        return new ForgotPasswordPage(driver);
    }

    public HoversPage clickHovers() {
        clickLink(hoversLink);
        return new HoversPage(driver);
    }

    public CheckBoxPage clickCheckBox() {
        clickLink(checkboxesLink);
        return new CheckBoxPage(driver);
    }

    public FileUpLoadPage clickFileUpload() {
        clickLink(fileUploadLink);
        return new FileUpLoadPage(driver);
    }

    public FileDownLoadPage clickFileDownLoad() {
        clickLink(fileDownLoadLink);
        return new FileDownLoadPage(driver);
    }

    public ContextMenuPage clickContextMenu() {
        clickLink(contextMenuLink);
        return new ContextMenuPage(driver);
    }

    public AlertsPage clickJavaScriptAlerts() {
        clickLink(jsAlertsLink);
        return new AlertsPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoading() {
        clickLink(dynamicLoadingLink);
        return new DynamicLoadingPage(driver);
    }

    public MultipleWindowsPage clickMultipleWindows() {
        clickLink(multipleWindowsLink);
        return new MultipleWindowsPage(driver);
    }
}
