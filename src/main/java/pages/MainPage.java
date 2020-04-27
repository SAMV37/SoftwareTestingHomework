package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    WebDriver driver;

    private final By nicknameText = By.xpath("/html/body/div[1]/header/div[7]/details/details-menu/div[1]/a/strong");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUsername(){
        WebElement userImage = driver.findElement(By.xpath("/html/body/div[1]/header/div[7]/details/summary"));

        if(userImage.isDisplayed()) {
            userImage.click();
            return driver.findElement(nicknameText).getText();
        }else{
            driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/button")).click();
            return driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/nav/a[5]")).getText();
        }
    }
}
