package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage
{
    private final WebDriver driver;

    private final By usernameField = By.id("login_field");
    private final By passwordField = By.id("password");
    private final By loginButton = By.xpath("//*[@id=\"login\"]/form/div[4]/input[9]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void setUsername(String username) {
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password) {
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    public MainPage clickBtn() {
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
        return new MainPage(driver);
    }

    public String getIncorrectText() {
        return driver.findElement(By.xpath("//*[@id=\"js-flash-container\"]/div/div")).getText();
    }
}
