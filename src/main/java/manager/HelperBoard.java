package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBoard extends HelperBase{
    public HelperBoard(WebDriver driver) {
        super(driver);
    }
    By btnCreateNewBoard = By.xpath("//li[@data-testid='create-board-tile']");
    By inputBoardTitle = By.xpath("//input[@data-testid='create-board-title-input']");

    public void createNewBoard(String boardTitle) {
        clickBase(btnCreateNewBoard);
        pause(3);
        typeBase(inputBoardTitle, boardTitle);
    }
}
