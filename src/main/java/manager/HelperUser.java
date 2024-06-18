package manager;

import dto.UserDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver driver) {
        super(driver);
    }
    By btnLoginOnHeader = By.cssSelector("a[data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']");
    By inputLogin = By.id("username");
    By btnContinue = By.id("login-submit");
    By inputPassword = By.id("password");
    By btnLoginSubmit = By.id("login-submit");
    By btnAccount = By.cssSelector("button[data-testid='header-member-menu-button']");

    By btnWOTwoStepVerification = By.id("mfa-promote-dismiss");

    public void login(UserDTO user) {
        clickBase(btnLoginOnHeader);
        typeBase(inputLogin, user.getEmail());
        clickBase(btnContinue);
        typeBase(inputPassword, user.getPassword());
        clickBase(btnLoginSubmit);
        //===============================
        clickBase(btnWOTwoStepVerification);

    }


    public boolean isElementPresent_btnAccount(){
        return isElementPresent(btnAccount);
    }
}
