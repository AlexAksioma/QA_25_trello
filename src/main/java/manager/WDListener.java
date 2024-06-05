package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static manager.TakeScreenShot.takeScreenShot;

public class WDListener extends AbstractWebDriverEventListener {
    Logger logger = LoggerFactory.getLogger(WDListener.class);

    public WDListener(Logger logger) {
        this.logger = logger;
    }

    public WDListener() {
        super();
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        logger.info("before click to element ---> "+element.getTagName());
        super.beforeClickOn(element, driver);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        super.afterClickOn(element, driver);
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        super.beforeChangeValueOf(element, driver, keysToSend);
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        super.afterChangeValueOf(element, driver, keysToSend);
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
        super.beforeScript(script, driver);
    }

    @Override
    public void afterScript(String script, WebDriver driver) {
        super.afterScript(script, driver);
    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        logger.info("switch to window --> "+windowName);
        super.afterSwitchToWindow(windowName, driver);
    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        super.beforeSwitchToWindow(windowName, driver);
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        logger.error("start exception --> "+throwable.toString());
        takeScreenShot((TakesScreenshot) driver);
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
        super.beforeGetScreenshotAs(target);
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
        super.afterGetScreenshotAs(target, screenshot);
    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        super.beforeGetText(element, driver);
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        super.afterGetText(element, driver, text);
    }
}
