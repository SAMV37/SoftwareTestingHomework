package test;

import base.SearchTest;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import base.LoginTest;
import pages.HomePage;

public class FirefoxTest extends BaseTest
{

    @BeforeMethod
    @Override
    public void setUp()
    {
        super.setUp();
        Capabilities firefoxCap = DesiredCapabilities.firefox();
        driver = new RemoteWebDriver(url, firefoxCap);
        driver.get(website);
        homePage = new HomePage(driver);

        loginTest = new LoginTest();

        searchTest = new SearchTest();
    }

    @Test
    public void testSuccessfulLoginFirefox()
    {
        loginTest.testSuccessfulLogin(homePage);
    }

    @Test
    public void testFailFireFox()
    {
        loginTest.testFailLogin(homePage);
    }

    @Test
    public void testUserProfilePage()
    {
        loginTest.testUserProfilePage(homePage);
    }

    @Test
    public void testSearch(){
        searchTest.testSearch(homePage);
    }
}