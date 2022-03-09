package test;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class WithoutLogin {

    WebDriver driver;
    WebDriverWait wait;
    By activePage = By.xpath("//a[contains(@class,'active ')]");

    public WithoutLogin() {
        driver = BasePage.driver;
        wait = BasePage.wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#SearchBoxOld > div > div > div.SearchBoxOld-buttonContainer")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"SearchBoxOld\"]/div/div/div[1]/div[2]/input")
    public WebElement searchBox;

    @FindBy(css = "#i1")
    public WebElement selectProduct;

    @FindBy(css = "body > div.wrapper > main > div.product-detail-module > section.detail-main > div.container.contain-lg-4.contain-md-4.contain-sm-1.fluid > div > div.productDetailRight.col.lg-2.md-2.sm-1.grid-demo-fluid > div.merchantLists.col.lg-5.sm-1.no-padding > div.merchantList.hbus.fd54b3e3-cf8d-4642-9f2b-25c95b54f042 > div > div.marketplace-list > table > tbody > tr:nth-child(1) > td.form-area > div > form > button")
    public WebElement addToBasketOne;

    @FindBy(css = "body > div.wrapper > main > div.product-detail-module > section.detail-main > div.container.contain-lg-4.contain-md-4.contain-sm-1.fluid > div > div.productDetailRight.col.lg-2.md-2.sm-1.grid-demo-fluid > div.merchantLists.col.lg-5.sm-1.no-padding > div.merchantList.hbus.fd54b3e3-cf8d-4642-9f2b-25c95b54f042 > div > div.marketplace-list > table > tbody > tr:nth-child(2) > td.form-area > div > form > button")
    public WebElement addToBasketTwo;

    public WithoutLogin sendSearchInput() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBox)).click();
        wait.until(ExpectedConditions.elementToBeClickable(searchBox)).sendKeys("Macbook Air M1");
        //Assert.assertEquals("Macbook Air M1", (searchBox));
        //System.out.println("Confirmed the keyword is searched and equals to Macbook Air M1");
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

        return this;
    }

    public WithoutLogin selectProductFromList() {
        wait.until(ExpectedConditions.elementToBeClickable(selectProduct)).click();
        return this;
    }

    public WithoutLogin handleNewWindow() {
        WebElement element = driver.findElement(By.cssSelector("#product-name"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
        return this;
    }

    public WithoutLogin addToBasket() throws InterruptedException {

        driver.getCurrentUrl();
        System.out.println("New Title " + driver.getCurrentUrl());

        //wait.until(ExpectedConditions.elementToBeClickable(addToBasketOne)).click();
        //wait.until(ExpectedConditions.elementToBeClickable(addToBasketTwo)).click();
        return this;
    }

    public WithoutLogin closeBrowser() throws InterruptedException {
        driver.close();
        return this;
    }

}
