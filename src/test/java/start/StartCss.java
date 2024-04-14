package start;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class StartCss {
    WebDriver driver = new ChromeDriver();

    @Test
    public void startingCss() {
        driver.navigate().to("https://trello.com/");
        WebElement btnLogin = driver.findElement(
                By.cssSelector("a[data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']"));
        System.out.println("--> " + btnLogin.getText());
        WebElement inputEmail = driver.findElement
                (By.cssSelector("input[data-testid='ui-email-signup-input']"));
        System.out.println("--> " + inputEmail.getAttribute("placeholder"));
        List<WebElement> listButtons = driver.findElements(By.cssSelector("button[type='submit']"));
        for (WebElement e:listButtons) {
            System.out.println("buttons text --> "+e.getText());
        }

        WebElement elementP = driver.findElement
                (By.cssSelector("div[class='UiFeatureSectionstyles__BodyCopy-sc-1sxbkhi-4 hlCKXj']>p"));
        System.out.println("--> "+elementP.getText());

        WebElement elementA = driver.findElement
                (By.cssSelector("div[class='UiFeatureSectionstyles__BodyCopy-sc-1sxbkhi-4 hlCKXj'] a"));
        System.out.println("href --> "+elementA.getAttribute("href"));

        btnLogin.click();
        //driver.quit();

    }

}
