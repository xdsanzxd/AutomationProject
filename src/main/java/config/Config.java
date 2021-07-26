package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;

public class Config {
    public WebDriver driver;
    String browser = "chrome";

    @BeforeSuite
    public void beforTest(){
        System.setProperty("webdriver.chrome.driver", "/home/odak/Documents/chromedriver_linux64/chromedriver");
        if(browser == "chrome"){
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
    }
    @AfterSuite
    public void afterTest(){
        driver.close();
        //driver.quit();
    }
}
