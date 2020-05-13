package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickLoginButton() {
        driver.findElement(By.xpath("//*[@id=\"header-signin-link\"]")).click();
        return new LoginPage(driver);
    }

    public SearchPage search(String searchText){
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header-search-input\"]")));
        driver.findElement(By.xpath("//*[@id=\"header-search-input\"]")).sendKeys(searchText);
        driver.findElement(By.xpath("//*[@id=\"header-desktop-search-button\"]")).click();

        return new SearchPage(driver);
    }
}
