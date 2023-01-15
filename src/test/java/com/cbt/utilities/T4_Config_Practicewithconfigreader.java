package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T4_Config_Practicewithconfigreader {
//    public WebDriver driver;
//    @BeforeMethod
//    public void setDriver(){
//        String browser = ConfigurationReader.getProperty("browser");
//        driver = WebDriverFactory.getDriver("chrome");
//        driver.manage().window().maximize();
//        driver.get("https://www.google.com/");
//    }
    @Test
    public void test1(){

        Driver.getDriver().get("https://www.google.com/");
        Driver.getDriver().findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
        WebElement googlesearchbox = Driver.getDriver().findElement(By.xpath("//input[@name='q']"));
        googlesearchbox.sendKeys("apple" + Keys.ENTER);

        String expectedtitle = "apple - Google Search";
        String actualtitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualtitle,expectedtitle);



    }

}
