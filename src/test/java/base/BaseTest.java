package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import event.EventReporter;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;

    protected URL url;
    protected String website;

    protected LoginTest loginTest;

    protected SearchTest searchTest;

    @BeforeClass
    public void setUp() {
        try {
            url = new URL("http://localhost:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        website = "https://yahoo.com";
    }

    @AfterMethod
    public void off(ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
        {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try
            {
                Files.move(screenshot, new File("src/main/resources/screenshots" + result.getName() + ".png"));
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        driver.quit();
    }
}
