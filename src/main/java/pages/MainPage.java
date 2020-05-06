package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    WebDriver driver;

    private final By usernamePath = By.xpath("//*[@id=\"profile-user-info-subheading\"]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUsername(){
        By button = (By.xpath("//*[@id=\"header-profile-button\"]"));

        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(button));

        driver.findElement(button).click();

        WebDriverWait wait2 = new WebDriverWait(this.driver, 10);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(usernamePath));

        return driver.findElement(usernamePath).getText();
    }

    public UserProfilePage navigateToProfilePage(){
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header-profile-button\"]")));

        driver.findElement(By.xpath("//*[@id=\"header-profile-button\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header-profile-panel\"]/li[6]")));

        driver.findElement(By.xpath("//*[@id=\"header-profile-panel\"]/li[6]")).click();

        return new UserProfilePage(driver);
    }
}
