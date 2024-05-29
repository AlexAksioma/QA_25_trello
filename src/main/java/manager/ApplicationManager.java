package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver driver;
    ChromeOptions options;

    public Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    private HelperUser helperUser;
    private HelperBoard helperBoard;

    public void init() {
        options = new ChromeOptions();
        options.addArguments("--lang=en");

        driver = new ChromeDriver(options);
        driver.navigate().to("https://trello.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logger.info("start testing --- navigate to --> https://trello.com/");
        helperUser = new HelperUser(driver);
        helperBoard = new HelperBoard(driver);
    }

    public void stop() {
//        if (driver != null)
//            driver.quit();
        logger.info("stop testing  --> https://trello.com/");
    }

    public HelperUser getHelperUser(){
        return helperUser;
    }
    public HelperBoard getHelperBoard(){
        return helperBoard;
    }


}
