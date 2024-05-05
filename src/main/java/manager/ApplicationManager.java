package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver driver;
    private HelperUser helperUser;
    private HelperBoard helperBoard;

    public void init() {
        driver = new ChromeDriver();
        driver.navigate().to("https://trello.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        helperUser = new HelperUser(driver);
        helperBoard = new HelperBoard(driver);
    }

    public void stop() {
//        if (driver != null)
//            driver.quit();
    }

    public HelperUser getHelperUser(){
        return helperUser;
    }
    public HelperBoard getHelperBoard(){
        return helperBoard;
    }


}
