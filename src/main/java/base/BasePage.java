package base;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;


public class BasePage {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static String browser;

    @Before
    public void initialize() throws Exception {
        browser = System.getProperty("browser");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certifcate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-gpu");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-plugins");
        options.addArguments("--disable-plugins-discovery");
        options.addArguments("--disable-preconnect");
        options.addArguments("--disable-notifications");
        options.addArguments("'--dns-prefetch-disable'");
        options.setAcceptInsecureCerts(true);
        options.addArguments("test-type");


        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);

        /*Config configuration = new Config();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
        driver.get(configuration.getBaseUrl());*/

    }
    static {
        System.setProperty("webdriver.chrome.driver",
                findFile(BasePage.class.getResource("/driver/chromedriver").getPath()));

    }

    static private String findFile(String fileName){
        String paths[] = {"", "bin/", "target/classes"};
            for(String path : paths){
                if(new File(path + fileName).exists()){
                    return path + fileName;
                }
            }
            return "";
    }
}
