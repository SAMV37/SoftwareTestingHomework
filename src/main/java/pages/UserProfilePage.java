package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserProfilePage {

    WebDriver driver;

    UserProfilePage(WebDriver driver){
        this.driver = driver;
    }

    public String getFirstName(){
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"txt-first-name\"]")));

        return driver.findElement(By.xpath("//*[@id=\"txt-first-name\"]")).getText();
    }

    public String getLastName(){
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"txt-last-name\"]")));

        return driver.findElement(By.xpath("//*[@id=\"txt-last-name\"]")).getText();
    }

    public String getGender(){
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"txt-gender\"]")));

        return driver.findElement(By.xpath("//*[@id=\"txt-gender\"]")).getText();
    }

    public String getBirthday(){
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"txt-birthfield\"]")));

        return driver.findElement(By.xpath("//*[@id=\"txt-birthfield\"]")).getText();
    }

    public String getNickname(){
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"txt-nickname\"]")));

        return driver.findElement(By.xpath("//*[@id=\"txt-nickname\"]")).getText();
    }
}
