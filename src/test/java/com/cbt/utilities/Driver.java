package com.cbt.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {

    /* CREATING A PRIVATE CONST SO WE ARE COSING ACCESS TO THE OBJECT OF THIS CLASS FROM OUTSIDE THE CLASS*/

    private Driver(){}

    // we make it private because we need getters and setters
    // we also make it static cus we will use it in a static method
    private static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver == null){
            // get the browsertpe from configs, so we can control the browser type
            String browsertype = ConfigurationReader.getProperty("browser");
            switch (browsertype){
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\kemal\\IdeaProjects\\BasicNavigationTestss\\chromedriver.exe");
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
                case "ie":
                    System.setProperty("webdriver.ie.driver", "drivers//IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                    driver.manage().window().maximize();
                    break;
                case "firefox":
                    System.setProperty("geckodriver.exe", "C:\\Users\\kemal\\IdeaProjects\\BasicNavigationTestss\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
                default:
                    driver = null;
                    break;
            }

        }
        return driver;
    }
}
