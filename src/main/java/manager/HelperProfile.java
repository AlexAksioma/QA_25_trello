package manager;

import interfaces.Path;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HelperProfile extends HelperBase implements Path {
    public HelperProfile(WebDriver driver) {
        super(driver);
    }

    By btnAccount = By.xpath("//button[@data-testid='header-member-menu-button']");
    By btnManageAccount = By.xpath("//a[@data-testid='manage-account-link']");
    By btnProfilePhoto = By.xpath("//div[@data-test-selector='profile-hover-info']");
    By btnChangeProfilePhoto = By.xpath("//button[@data-testid='change-avatar']");
    By btnUploadPhoto = By.xpath("//input[@id='image-input']");
    By btnUpload = By.xpath("//button[@type='submit']");
    By popUpMessageAvatarAdded = By.xpath("//span[@class='css-47z6js']");
    By messageWrongFileFormat = By.xpath("//span[@class='css-d8rbi4']");
    By btnCanselProfile = By.xpath("//div[@role='group']/button[@class='css-1luyhz2']");
    public void changeAvatar(String fileName) {
        clickBaseWait(btnAccount, 3);
        clickBaseWait(btnManageAccount, 3);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(btnProfilePhoto)).perform();
        clickBaseWait(btnProfilePhoto, 3);
        clickBaseWait(btnChangeProfilePhoto, 3);

        File file = new File(PHOTOS_PATH+fileName);
        String path = file.getAbsolutePath();
        System.out.println(path);
        driver.findElement(btnUploadPhoto).sendKeys(path);
        clickBaseWait(btnUpload, 3);
    }

    public boolean isTextInElementPresent_AvatarAdded() {
        //pause(5);
        return isTextInElementEquals(popUpMessageAvatarAdded, "Avatar added",5);
    }
    public boolean isTextInElementPresent_wrongFileFormat() {
        return isTextInElementEquals(messageWrongFileFormat, "Upload a photo or select from some default options",5);
    }

    public void clickBtnCanselProfile() {
        clickBase(btnCanselProfile);
    }

    public void closeWindowAtlassianAccount() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)).close();
        driver.switchTo().window(tabs.get(0));
    }
}
