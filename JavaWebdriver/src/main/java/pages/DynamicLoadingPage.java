package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {

    private final WebDriver driver;
    private final String linkXpath_Format;
    private final By link_Example1;
    private final By link_Example2;

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
        linkXpath_Format = ".//a[contains(text(), '%s')]";
        link_Example1 = By.xpath(String.format(linkXpath_Format, "Example 1"));
        link_Example2 = By.xpath(String.format(linkXpath_Format, "Example 2"));
    }

    public DynamicLoadingExample1Page clickExample1() {
        driver.findElement(link_Example1).click();
        return new DynamicLoadingExample1Page(driver);
    }

    public DynamicLoadingExample2Page clickExample2(){
        driver.findElement(link_Example2).click();
        return new DynamicLoadingExample2Page(driver);
    }

}
