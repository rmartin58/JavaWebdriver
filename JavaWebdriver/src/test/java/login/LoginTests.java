package login;

import base.BaseTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @AfterMethod
    public void goToHomePage() {
        driver.navigate().to("https://the-internet.herokuapp.com/");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsernameField("tomsmith");
        loginPage.setPasswordField("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"), "Alert text is incorrect");
    }

    @Test
    public void testUnsuccessfulLoginPassword() {
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsernameField("tomsmith");
        loginPage.setPasswordField("BadPassword");
        loginPage.clickLoginButton();
        assertTrue(loginPage.getAlertText().contains("Your password is invalid!"), "Alert text is incorrect");
    }

    @Test
    public void testUnsuccessfulLoginUserName() {
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsernameField("BadUserName");
        loginPage.setPasswordField("SuperSecretPassword!");
        loginPage.clickLoginButton();
        assertTrue(loginPage.getAlertText().contains("Your username is invalid!"), "Alert text is incorrect");
    }

    @Test
    public void testForgotPassword() {
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPassword();
        forgotPasswordPage.setEmailField("tau@example.com");
        EmailSentConfirmationPage emailSentConfirmationPage = forgotPasswordPage.clickRetrievePasswordButton();
        assertTrue(emailSentConfirmationPage.getContentText().contains("Your e-mail's been sent"));
    }
}
