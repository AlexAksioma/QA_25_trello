package manager;

import interfaces.Path;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.TreeMap;

public class HelperBase implements Path {
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
    public void clickBaseWait(By locator, int time){
        new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(locator)).click();

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
    public boolean isTextInElementEquals(By locator, String text){
        return findElementBase(locator).getText().equals(text);
    }
    public void createScreenShot(){
        TakeScreenShot.takeScreenShot((TakesScreenshot) driver);
    }

}
