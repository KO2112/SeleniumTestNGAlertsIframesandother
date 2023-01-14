package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTablePractice {
    WebDriver driver;
    @BeforeMethod
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test1(){
        driver.get("https://practice.cydeo.com/web-tables");
        WebElement bobmartin = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));
        String name = "Bob Martin";
        Assert.assertEquals(name,bobmartin.getText());
        WebElement bobmartindateexpected = driver.findElement(By.xpath("//table[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[7]/td[5]"));
        String bobmartinactualdate = "12/31/2021";
        Assert.assertEquals(bobmartinactualdate, bobmartindateexpected.getText());
    }
    @Test
    public void test2(){
        driver.get("https://practice.cydeo.com/web-tables");
        String customerorderdate1 = BrowserUtil.returnOrderDate(driver,"Samuel Jackson");
        System.out.println(customerorderdate1);
        BrowserUtil.orderverify(driver,"Samuel Jackson", "12/21/2021");

    }
    @Test
    public void test3(){
        driver.get("https://practice.cydeo.com/tables");

    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
