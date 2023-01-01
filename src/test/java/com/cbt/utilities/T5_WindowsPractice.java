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

import java.util.ArrayList;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class T5_WindowsPractice {
    WebDriver driver;
    @BeforeMethod
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/windows");
    }
    @Test
    public void test1(){
        String title = driver.getTitle();
        Assert.assertEquals(title, "Windows");
        WebElement clcikhere = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
        clcikhere.click();
        ArrayList<String> windows = new ArrayList(driver.getWindowHandles());
        for (int i = 0; i < windows.size(); i++) {
            driver.switchTo().window(windows.get(i));
            System.out.println("current windows: " + driver.getTitle());
        }
        Assert.assertEquals(driver.getTitle(), "New Window");
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
