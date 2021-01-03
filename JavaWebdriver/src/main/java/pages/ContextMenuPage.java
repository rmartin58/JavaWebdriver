package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ContextMenuPage {
	private final WebDriver driver;

	private final By hotSpot;


	public ContextMenuPage(WebDriver driver) {
		this.driver = driver;
		hotSpot = By.id("hot-spot");
	}

	public void alert_clickToAccept() {
		driver.switchTo().alert().accept();
	}

	public String alert_getText() {
		return driver.switchTo().alert().getText();
	}

	public void triggerHotSpot() {
		WebElement hotspot = driver.findElement(hotSpot);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(hotspot).moveToElement(hotspot).contextClick().perform();
	}
}
