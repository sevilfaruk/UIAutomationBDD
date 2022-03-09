package test;

import base.BasePage;
import base.HomePage;
import org.junit.AfterClass;
import org.junit.Test;
import org.testng.annotations.AfterMethod;

public class MainTest extends BasePage {

    @Test
    public void searchWithoutLogin() throws Exception {
        HomePage homePage = new HomePage(driver);
        LoginTest loginPage = new LoginTest(driver);
        BaseTest baseTest = new BaseTest(driver);
        WithoutLogin withoutLogin = new WithoutLogin();


        homePage
                .goToHepsiBurada()
                .assertHomeIsLoaded();

        withoutLogin
                .sendSearchInput()
                .selectProductFromList()
                .addToBasket()
                .closeBrowser();

    }

    @Test
    public void searchWithLogin() throws Exception {
        HomePage homePage = new HomePage(driver);
        LoginTest loginPage = new LoginTest(driver);



        homePage
                .goToHepsiBurada()
                .assertHomeIsLoaded();

    }

}
