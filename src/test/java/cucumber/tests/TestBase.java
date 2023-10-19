package cucumber.tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected String baseUrl = "https://www.saucedemo.com/";

    public void setUpDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    public WebDriver getDriver() {
        return driver;
    }
    public void quitDriver(){
        if(driver != null){
            driver.quit();
        }
    }

}
