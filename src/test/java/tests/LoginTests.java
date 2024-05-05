package tests;

import dto.UserDTO;
import manager.RandomData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void validateTest(){
        for (int i = 0; i < 5; i++) {
            System.out.println(RandomData.randomString(10));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(RandomData.breedOfCats());
        }

    }

    @Test
    public void loginPositiveTest(){
        //UserDTO user = new UserDTO("aksiomamedved@gmail.com","AlexMed123!");
        app.getHelperUser().login(user);
        Assert.assertTrue(app.getHelperUser().isElementPresent_btnAccount());
    }
}
