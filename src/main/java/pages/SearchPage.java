package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    WebDriver driver;

    SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public ArrayList<String> getSearchResults(){
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("lh-24")));
        List<WebElement> elements = driver.findElements(By.className("lh-24"));

        ArrayList<String> list = new ArrayList<>();

        for (WebElement element : elements) {
            list.add(element.getText());
        }

        return list;
    }

}
