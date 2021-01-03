package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxPage {
    private final WebDriver driver;
    private final By checkboxes = By.id("checkboxes");
    private final By inputs = By.tagName("input");


    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getCheckBoxes() {
        return driver.findElement(checkboxes).findElements(inputs);
    }

    public WebElement getCheckBoxByIndex(int index) {
        return getCheckBoxes().get(index - 1);
    }

    public void checkCheckBoxByIndex(int index) {
        WebElement checkBox = getCheckBoxes().get(index - 1);
        if (checkBox.isSelected()) return;
        checkBox.click();
    }

    public void uncheckCheckBoxByIndex(int index) {
        WebElement checkBox = getCheckBoxes().get(index - 1);
        if (!checkBox.isSelected()) return;
        checkBox.click();
    }

    @SuppressWarnings("unused")
    public String getCheckBoxByLabel(String label) {
        WebElement checkBoxes = driver.findElement(checkboxes);

        return checkBoxes.getAttribute("innerHTML");
    }
}

