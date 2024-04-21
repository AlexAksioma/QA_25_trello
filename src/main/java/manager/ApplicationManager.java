package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    WebDriver driver;
    HelperUser helperUser;

    public void init() {
        driver = new ChromeDriver();
        driver.navigate().to("https://trello.com/");
        driver.manage().window().maximize();
        helperUser = new HelperUser(driver);
    }

    public void stop() {
//        if (driver != null)
//            driver.quit();
    }

    public HelperUser getHelperUser(){
        return helperUser;
    }


}
