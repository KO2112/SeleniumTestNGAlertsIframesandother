package com.cbt.utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.IOException;
public class BrowserFactory {
    WebDriver driver;
    @BeforeMethod
    @Parameters("browser")
    public void init(String browser){
        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\kemal\\IdeaProjects\\BasicNavigationTestss\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", "drivers//IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
            case "firefox":
                System.setProperty("geckodriver.exe", "C:\\Users\\kemal\\IdeaProjects\\BasicNavigationTestss\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                driver = null;
                break;
        }
    }
    @Test
    public void verifyPageTitle() {
        driver.get("https://www.google.com");
        String googletitle = driver.getTitle();
        driver.get("https://etsy.com");
        String etstitle =  driver.getTitle();
        driver.navigate().back();
        String secondgoogletitle = driver.getTitle();
        System.out.println(secondgoogletitle);
        driver.navigate().forward();
        String secondetsytitle = driver.getTitle();
        System.out.println(secondetsytitle);
        if (googletitle.equals(secondgoogletitle) && etstitle.equals(secondetsytitle)) assert true;
        else assert false;
    }
    @AfterMethod
    public void tearDown() throws IOException {
        driver.quit();
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
    }
}