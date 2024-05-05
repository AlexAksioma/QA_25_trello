package tests;

import dto.UserDTO;
import manager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    static ApplicationManager app = new ApplicationManager();
    UserDTO user = new UserDTO("aksiomamedved@gmail.com","AlexMed123!");

    @BeforeSuite
    public void setUp(){
        app.init();
    }

    @AfterSuite
    public void tearDown(){
        app.stop();
    }
}
