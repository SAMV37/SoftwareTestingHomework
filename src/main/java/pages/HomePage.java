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
        driver.findElement(By.xpath("//*[@id=\"header-signin-link\"]")).click();
        return new LoginPage(driver);
    }
}
