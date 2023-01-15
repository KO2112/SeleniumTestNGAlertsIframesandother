package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public static WebDriver getDriver(String browsertype){
        if (browsertype.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            WebDriver driver  = new ChromeDriver();
            return new ChromeDriver();
        }
        else if (browsertype.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
        else {
            System.out.println("no browser name");
            return null;
        }

    }
}
