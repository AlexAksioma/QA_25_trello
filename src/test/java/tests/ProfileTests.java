package tests;

import org.testng.annotations.Test;

public class ProfileTests extends TestBase{

    @Test(groups = {"smoke"})
    public void changeProfileAvatarPositiveTest(){
        app.getHelperProfile().changeAvatar("qa_blue.jpg");
    }
}
