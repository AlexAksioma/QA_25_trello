package tests;

import org.testng.annotations.Test;

public class ProfileTests extends TestBase{

    @Test
    public void changeProfileAvatarPositiveTest(){
        app.getHelperProfile().changeAvatar("qa_blue.jpg");
    }
}
