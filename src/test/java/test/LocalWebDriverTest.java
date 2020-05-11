package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import base.LoginTest;
import event.EventReporter;
import pages.HomePage;

public class LocalWebDriverTest extends BaseTest
{


    @BeforeMethod
    @Override
    public void setUp()
    {
        super.setUp();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        ((EventFiringWebDriver) driver).register(new EventReporter());
        driver.get(website);
        homePage = new HomePage(driver);
        loginTest = new LoginTest();
    }

    private ChromeOptions getChromeOptions()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return options;
    }

    @Test
    public void testSuccessfulLogin()
    {
        loginTest.testSuccessfulLogin(homePage);
    }

    @Test
    public void testFail()
    {
        loginTest.testFailLogin(homePage);
    }

    @Test
    public void testUserProfilePage()
    {
        loginTest.testUserProfilePage(homePage);
    }
}