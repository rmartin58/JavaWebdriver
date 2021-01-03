package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

	private final WebDriver driver;
	private final By triggerAlertButton;
	private final By triggerConfirmButton;
	private final By triggerPromptButton;
	private final By results;

	public AlertsPage(WebDriver driver) {
		this.driver = driver;
		triggerAlertButton = By.xpath(".//button[contains(text(),'Click for JS Alert')]");
		triggerConfirmButton = By.xpath(".//button[contains(text(),'Click for JS Confirm')]");
		triggerPromptButton = By.xpath(".//button[contains(text(),'Click for JS Prompt')]");
		results = By.id("result");
	}

	public void triggerAlert() {
		driver.findElement(triggerAlertButton).click();
	}

	public void alert_clickToAccept() {
		driver.switchTo().alert().accept();
	}
	
	public String getResult() {
		return driver.findElement(results).getText();
	}
	
	public void triggerConfirm() {
		driver.findElement(triggerConfirmButton).click();
	}

	public void alert_clickToDismiss() {
		driver.switchTo().alert().dismiss();
	}
	
	public String alert_getText() {
		return driver.switchTo().alert().getText();
	}
	
	public void triggerPrompt() {
		driver.findElement(triggerPromptButton).click();
	}
	
	public void alert_setInput(String text) {
		driver.switchTo().alert().sendKeys(text);
	}

}
