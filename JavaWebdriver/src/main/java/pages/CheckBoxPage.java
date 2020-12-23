package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxPage {
    private WebDriver driver;
    private By checkboxes = By.id("checkboxes");
    private By inputs = By.tagName("input");

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getCheckBoxes() {
        return driver.findElement(checkboxes).findElements(inputs);
    }

    public
}
