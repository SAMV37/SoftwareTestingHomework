package test;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.MainPage;

import static org.testng.Assert.assertEquals;


public class LoginTest extends BaseTest
{
    private final String username = "test88sp878";
    private final String password = "TestingPassword";
    private final String wrongPassword = "wrongPassword";
    private final String wrongPasswordErrorMessage = "Invalid password. Please try again";

    @Test
    public void testSuccessfulLogin()
    {
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setUsername(username);
        MainPage mainPage = loginPage.setPassword(password);
        assertEquals(mainPage.getUsername(), username);
    }

    @Test
    public void testFailLogin()
    {
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setUsername(username);
        loginPage.setPassword(wrongPassword);

        assertEquals(loginPage.getIncorrectText(), wrongPasswordErrorMessage);
    }
}