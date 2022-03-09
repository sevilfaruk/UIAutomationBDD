package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginTest extends BaseTest{

    WebDriver driver;

    public LoginTest(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"myAccount\"]/span/span[1]")
    public WebElement clickLoginButton;

    @FindBy(css = "#myAccount > span > span.sf-OldMyAccount-PhY-T")
    public WebElement hoverLoginButton;

    public LoginTest hoverElement() {
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.linkText("Giriş Yap"));
        builder.moveToElement(element).build().perform();

        return this;
    }



    public LoginTest clickLoginButton() {
        clickLoginButton.click();
        System.out.println("Login Clicked");
        return this;
    }

}
