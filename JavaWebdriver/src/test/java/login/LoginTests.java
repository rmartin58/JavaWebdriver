package login;

import base.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.EmailSentConfirmationPage;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @DataProvider(name = "validCredentials")
    private static Object[][] getValidCredentials() {
        return new Object[][]{
                {"tomsmith", "SuperSecretPassword!", "You logged into a secure area!"},
        };
    }

    @Test(dataProvider = "validCredentials")
    public void shouldBeAbleToSuccessfullyLogin(String userName, String passWord, String msg) {
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsernameField(userName);
        loginPage.setPasswordField(passWord);
        var secureAreaPage = loginPage.clickLoginButton();
        assertTrue(secureAreaPage.getAlertText().contains(msg), "Alert text is incorrect");
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

    @DataProvider(name = "inValidCredentials")
    private static Object[][] getInvalidCredentials() {
        return new Object[][]{
                {"tomsmith", "BadPassword", "Your password is invalid!"},
                {"BadUserName", "SuperSecretPassword!", "Your username is invalid!"}
        };
    }

    @Test(dataProvider = "inValidCredentials")
    public void shouldDisplayUnsuccessfulLoginMsg(String userName, String passWord, String msg) {
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsernameField(userName);
        loginPage.setPasswordField(passWord);
        loginPage.clickLoginButton();
        assertTrue(loginPage.getAlertText().contains(msg), "Alert text is incorrect");
    }

}
