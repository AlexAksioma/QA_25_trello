package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ProfileTests extends TestBase{


    @Test(groups = {"smoke"})
    public void changeProfileAvatarPositiveTest(){
        app.getHelperProfile().changeAvatar("qa_blue.jpg");
        Assert.assertTrue(app.getHelperProfile().isTextInElementPresent_AvatarAdded());
    }

    @Test
    public void changeProfileAvatarNegativeTest_wrongFileFormat(){
        app.getHelperProfile().changeAvatar("boards.csv");
        Assert.assertTrue(app.getHelperProfile().isTextInElementPresent_wrongFileFormat());
    }

    @AfterMethod
    public void afterTest(){
        if(app.getHelperProfile().isTextInElementPresent_wrongFileFormat())
            app.getHelperProfile().clickBtnCanselProfile();
        app.getHelperProfile().closeWindowAtlassianAccount();
    }

}
