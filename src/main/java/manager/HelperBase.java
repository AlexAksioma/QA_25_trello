package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.TreeMap;

public class HelperBase {
    WebDriver driver;
    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement findElementBase(By locator){
        return driver.findElement(locator);
    }

    public void clickBase(By locator){
        WebElement element = findElementBase(locator);
        element.click();
    }

    public void typeBase(By locator, String text){
        WebElement element = findElementBase(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public boolean isElementPresent(By locator){
        return !driver.findElements(locator).isEmpty();
    }

    public void pause(int time){
        try {
            Thread.sleep(1000L *time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
