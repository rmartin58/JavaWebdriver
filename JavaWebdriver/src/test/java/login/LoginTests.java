package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.EmailSentConfirmationPage;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {


    @Test
    public void shouldBeAbleToSuccessfullyLogin() {
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsernameField("tomsmith");
        loginPage.setPasswordField("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"), "Alert text is incorrect");
    }

    @Test
    public void shouldDisplayUnsuccessfulLoginPassword() {
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsernameField("tomsmith");
        loginPage.setPasswordField("BadPassword");
        loginPage.clickLoginButton();
        assertTrue(loginPage.getAlertText().contains("Your password is invalid!"), "Alert text is incorrect");
    }

    @Test
    public void shouldDisplayUnsuccessfulLoginUserName() {
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsernameField("BadUserName");
        loginPage.setPasswordField("SuperSecretPassword!");
        loginPage.clickLoginButton();
        assertTrue(loginPage.getAlertText().contains("Your username is invalid!"), "Alert text is incorrect");
    }

    @Test
    public void shouldAllowRecoveryOfForgotPassword() {
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPassword();
        forgotPasswordPage.setEmailField("tau@example.com");
        EmailSentConfirmationPage emailSentConfirmationPage = forgotPasswordPage.clickRetrievePasswordButton();
        assertTrue(emailSentConfirmationPage.getContentText().contains("Your e-mail's been sent"));
    }
}
