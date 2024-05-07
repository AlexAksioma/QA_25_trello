package tests;

import manager.RandomData;
import org.testng.Assert;
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
        Assert.assertTrue(app.getHelperBoard().isTextInElementEquals_boardTitle("QA-"+boardTitle));
    }

    @Test
    public void createNewBoardNegativeTest(){
        app.getHelperBoard().createNewBoard("");
        Assert.assertTrue(app.getHelperBoard().isAttributeDisabled());
    }

    @Test
    public void deleteBoardPositiveTest(){
        String boardTitle = RandomData.randomString(7);
        app.getHelperBoard().createNewBoard("DEL-"+boardTitle);
        if(app.getHelperBoard().isTextInElementEquals_boardTitle("DEL-"+boardTitle)){
            app.getHelperBoard().deleteBoard("DEL-"+boardTitle);
        }else
            System.out.println("board didn't create");
    }

}
