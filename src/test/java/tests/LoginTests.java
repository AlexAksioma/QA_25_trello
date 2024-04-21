package tests;

import manager.RandomData;
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
}
