package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/a[1]"));
        if (!loginButton.isDisplayed()) {
            driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/button")).click();
        }
        loginButton.click();
        return new LoginPage(driver);
    }
}
