package tests;

import dto.UserDTO;
import manager.ApplicationManager;
import manager.PropertiesReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    static ApplicationManager app = new ApplicationManager();
    public Logger logger = LoggerFactory.getLogger(TestBase.class);
    //UserDTO user = new UserDTO("aksiomamedved@gmail.com", "AlexMed123!");
    UserDTO user = new UserDTO(PropertiesReader.getProperty("login.properties", "email"),
            PropertiesReader.getProperty("login.properties", "password"));

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        app.init();
        logger.info("login with email --> " + user.getEmail() + " password --> " + user.getPassword());
        app.getHelperUser().login(user);

    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }
}
