package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage
{
    private final WebDriver driver;

    private final By usernameField = By.xpath("//*[@id=\"login-username\"]");
    private final By passwordField = By.xpath("//*[@id=\"login-passwd\"]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void setUsername(String username) {
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).sendKeys(username + "\n");
    }

    public MainPage setPassword(String password) {
        WebDriverWait wait = new WebDriverWait(this.driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password + "\n");
        return new MainPage(driver);
    }


    public String getIncorrectText() {
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password-challenge\"]/form/p")));
        return driver.findElement(By.xpath("//*[@id=\"password-challenge\"]/form/p")).getText();
    }
}
