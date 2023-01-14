package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;

public class T4_Config_Practice {
    WebDriver driver;
    @BeforeMethod
    public void setDriver(){
        String browser = ConfigurationReader.getProperty("browser");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test1(){
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
        WebElement googlesearchbox = driver.findElement(By.xpath("//input[@name='q']"));
        googlesearchbox.sendKeys("apple" + Keys.ENTER);

        String expectedtitle = "apple - Google Search";
        String actualtitle = driver.getTitle();
        Assert.assertEquals(actualtitle,expectedtitle);



    }

}
