package base;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

public class HomePage extends BasePage{
    private WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(HomePage.class.getName());
    public static final String baseURL = "https://www.hepsiburada.com";

    public HomePage (WebDriver driver){
        this.driver = driver;
    }


    @FindBy(css = "#oldHeader_0f883dac-df25-40d7-0dde-f3214c9decc3 > div > div > div.sf-OldHeader-vf8w1 > div.sf-OldHeader-2I4tx > div > a")
    public WebElement logoHepsiburada;

    @FindBy(css = "div.cookie-info > img")
    public WebElement closeCookieBaloon;

    @FindBy(css = "div#SearchBoxOld input")
    public WebElement searchBox;

    @FindBy(css = "#SearchBoxOld > div > div > div.SearchBoxOld-buttonContainer")
    public WebElement searchButton;

    @FindBy(css = "#categorySuggestionList > div.category-suggestion-title > h1")
    public WebElement searchTextKeyword;


    public HomePage assertHomeIsLoaded() {
        //System.out.println("Confirming the page is loading");
        //Assert.assertTrue("logo is not displayed on homepage", logoHepsiburada.isDisplayed());
        Assert.assertEquals("https://www.hepsiburada.com/", driver.getCurrentUrl());
        return this;
    }


    public HomePage goToHepsiBurada(){
        LOGGER.info("Go to HepsiBurada: "+ LOGGER.getName());
        driver.get(baseURL);
        return this;
    }

    public HomePage assertKeywordIsSearched() {
        searchBox.click();
        searchBox.sendKeys("Macbook Air M1");
        searchButton.click();
        Assert.assertEquals("Macbook Air M1", searchTextKeyword.getText());
        System.out.println("Confirmed the keyword is searched and equals to Macbook Air M1");
        return this;
    }
}
