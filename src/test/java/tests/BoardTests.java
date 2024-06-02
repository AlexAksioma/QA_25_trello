package tests;

import dto.BoardDTO;
import manager.RandomData;
import manager.RetryAnalyzer;
import manager.TakeScreenShot;
import manager.TestNGListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Listeners(TestNGListener.class)

public class BoardTests extends TestBase{

    Logger logger = LoggerFactory.getLogger(BoardTests.class);

    @BeforeClass
    public void login(){
        app.getHelperUser().login(user);
    }

    @Test
    public void createNewBoardPositiveTest(Method method){
        String boardTitle = RandomData.randomString(7);
        BoardDTO board = BoardDTO.builder()
                .boardTitle("QA"+boardTitle)
                //.boardTitle("")
                .build();
        logger.info("start test "+method.getName() + " board title --> "+ board.getBoardTitle());
        app.getHelperBoard().createNewBoard(board);
        Assert.assertTrue(app.getHelperBoard().isTextInElementEquals_boardTitle(board.getBoardTitle()));
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void createNewBoardNegativeTest(){
        BoardDTO board = BoardDTO.builder()
                .boardTitle("111")
                .build();
        app.getHelperBoard().createNewBoard(board);
        //app.getHelperBoard().createScreenShot();
        //Assert.assertTrue(app.getHelperBoard().isAttributeDisabled());
        Assert.assertTrue(app.getHelperBoard().isElementPresent_textBoardTitleRequired());
    }

    @Test
    public void deleteBoardPositiveTest(Method method){
        String boardTitle = RandomData.randomString(7);
        BoardDTO board = BoardDTO.builder()
                .boardTitle("DEL"+boardTitle)
                .build();
        app.getHelperBoard().createNewBoard(board);
        if(app.getHelperBoard().isTextInElementEquals_boardTitle(board.getBoardTitle())){
            logger.info("start test "+method.getName() + " board title --> "+ board.getBoardTitle());
            app.getHelperBoard().deleteBoard();
            Assert.assertTrue(app.getHelperBoard().isTextInElementPresent_BoardDeleted());
        }else{
            System.out.println("board didn't create");
            logger.info("in test "+method.getName()+" board didn't create");
            Assert.fail("board didn't create");
        }
    }

//    @AfterMethod
//    public void afterTest(){
//        if(app.getHelperBoard().isAttributeDisabled())
//            app.getHelperBoard().closeCreateBoardForm();
//    }

}
