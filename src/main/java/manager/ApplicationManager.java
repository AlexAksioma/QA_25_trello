package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

@Listeners(TestNGListener.class)

public class ApplicationManager {
    //WebDriver driver;
    EventFiringWebDriver driver;
    ChromeOptions options;

    public Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    private HelperUser helperUser;
    private HelperBoard helperBoard;
    private HelperProfile helperProfile;

    static String browser;
    static String url;

    public ApplicationManager() {
        browser = System.getProperty("browser", BrowserType.CHROME);
    }


    public void init() {
//        options = new ChromeOptions();
//        options.addArguments("--lang=en");
//        driver = new EventFiringWebDriver(new ChromeDriver(options));
        if (browser.equals(BrowserType.FIREFOX)) {
            FirefoxOptions options1 = new FirefoxOptions();
            options1.addPreference("intl.accept_languages", "en");
            driver = new EventFiringWebDriver(new FirefoxDriver(options1));
            logger.info("testing on FIREFOX");
        } else {
            options = new ChromeOptions();
            options.addArguments("--lang=en");
            driver = new EventFiringWebDriver(new ChromeDriver(options));
        }

        //driver.navigate().to("https://trello.com/");
        url = PropertiesReader.getProperty("login.properties", "url");
        driver.navigate().to(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logger.info("start testing --- navigate to --> " + url);
        helperUser = new HelperUser(driver);
        helperBoard = new HelperBoard(driver);
        helperProfile = new HelperProfile(driver);
        driver.register(new WDListener());
    }

    public void stop() {
//        if (driver != null)
//            driver.quit();
        logger.info("stop testing  --> https://trello.com/");
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperBoard getHelperBoard() {
        return helperBoard;
    }

    public HelperProfile getHelperProfile() {
        return helperProfile;
    }


}
