package tests;

import manager.RandomData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BoardTests extends TestBase{

    @BeforeClass
    public void login(){
        app.getHelperUser().login(user);
    }

    @Test
    public void createNewBoardPositiveTest(){
        String boardTitle = RandomData.randomString(7);
        app.getHelperBoard().createNewBoard("QA-"+boardTitle);
    }
}
