package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTests {
  @Test
  public void shouldAcceptAlert() {
	  var alertsPage = homePage.clickJavaScriptAlerts();
	  alertsPage.triggerAlert();
	  assertEquals(alertsPage.alert_getText(), "I am a JS Alert", "Alert text is incorrect!");
	  alertsPage.alert_clickToAccept();
	  assertEquals(alertsPage.getResult(), "You successfuly clicked an alert", "Results did not match expected!");
  }
  
  @Test
  public void shouldGetTextFromAlert() {
	  var alertsPage = homePage.clickJavaScriptAlerts();
	  alertsPage.triggerConfirm();
	  String text = alertsPage.alert_getText();
	  alertsPage.alert_clickToDismiss();
	  assertEquals(text, "I am a JS Confirm", "Alert text is incorrect!");
	  assertEquals(alertsPage.getResult(), "You clicked: Cancel", "Results did not match expected!");
  }
  
  @Test
  public void shouldAcceptTextToPrompt() {
	  var alertsPage = homePage.clickJavaScriptAlerts();
	  alertsPage.triggerPrompt();
	  String text = alertsPage.alert_getText();
	  assertEquals(text, "I am a JS prompt", "Alert text is incorrect!");
	  text = "TAU Rocks!";
	  alertsPage.alert_setInput(text);
	  alertsPage.alert_clickToAccept();
	  assertEquals(alertsPage.getResult(), "You entered: " + text, "Results did not match expected!");
  }
}

