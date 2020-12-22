package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private final String formAuthentication = "Form Authentication";
    private final String dropDown = "Dropdown";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickFormAuthentication(){
        clickLink(formAuthentication);
        return new LoginPage(driver);
    }

    public DropdownPage clickDropDown() {
        clickLink(dropDown);
        return new DropdownPage(driver);
    }
    private void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }
}
