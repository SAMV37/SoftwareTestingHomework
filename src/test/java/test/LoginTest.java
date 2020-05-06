package test;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.MainPage;
import pages.UserProfilePage;

import static org.testng.Assert.assertEquals;


public class LoginTest extends BaseTest
{
    private final String username = "test88sp878";
    private final String password = "TestingPassword";
    private final String wrongPassword = "wrongPassword";
    private final String wrongPasswordErrorMessage = "Invalid password. Please try again";


    //////////Homework 4
    private final String firstName = "Samvel";
    private final String lastName = "Petrosyan";

    private final String gender = "Male";
    private final String birthday = "December 12, 2000";
    private final String nickname = "Samvel";

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

    @Test
    public void testUserProfilePage(){
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setUsername(username);
        MainPage mainPage = loginPage.setPassword(password);
        UserProfilePage userProfilePage = mainPage.navigateToProfilePage();
        assertEquals(userProfilePage.getFirstName(), firstName);
        assertEquals(userProfilePage.getLastName(), lastName);
        assertEquals(userProfilePage.getGender(), gender);
        assertEquals(userProfilePage.getBirthday(), birthday);
        assertEquals(userProfilePage.getNickname(), nickname);
    }
}