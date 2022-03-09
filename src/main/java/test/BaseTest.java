package test;

import base.BasePage;
import base.HomePage;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.logging.Logger;

public class BaseTest extends BasePage {
    private static final Logger LOGGER = Logger.getLogger(HomePage.class.getName());
    public WebDriver driver;
    public HomePage homePage;

    public BaseTest(WebDriver driver) {
        super();
    }

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void methodLevelSetup() {
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void methodLevelTeardown(){
        driver.manage().deleteAllCookies();

    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
