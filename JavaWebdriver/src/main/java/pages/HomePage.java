package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private final String formAuthentication = "Form Authentication";
    private final String dropDown = "Dropdown";
    private final String forgotPassword = "Forgot Password";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public LoginPage clickFormAuthentication(){
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
}
