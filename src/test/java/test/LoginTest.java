package test;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.MainPage;

import static org.testng.Assert.assertEquals;


public class LoginTest extends BaseTest
{
    public final String username = "test88878";
    public final String password = "TestingPassword";
    public final String wrongPassword = "wrongPassword";

    @Test
    public void testSuccessfulLogin()
    {
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        MainPage mainPage = loginPage.clickBtn();
        assertEquals(mainPage.getUsername(), username);
    }

    @Test
    public void testFailLogin()
    {
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setUsername(username);
        loginPage.setPassword(wrongPassword);
        loginPage.clickBtn();

        assertEquals(loginPage.getIncorrectText(), "Incorrect username or password.");
    }
}