package tests;

import dto.UserDTO;
import manager.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    static ApplicationManager app = new ApplicationManager();
    public Logger logger = LoggerFactory.getLogger(TestBase.class);
    UserDTO user = new UserDTO("aksiomamedved@gmail.com", "AlexMed123!");

    @BeforeSuite
    public void setUp() {
        app.init();
        logger.info("login with email --> " + user.getEmail() + " password --> " + user.getPassword());
        app.getHelperUser().login(user);

    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }
}
