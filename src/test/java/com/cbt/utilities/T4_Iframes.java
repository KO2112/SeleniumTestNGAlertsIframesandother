package com.cbt.utilities;

import com.cbt.base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T4_Iframes extends TestBase {
    @Test
    public void test1(){
        driver.get("https://practice.cydeo.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement text =  driver.findElement(By.id("tinymce"));
        driver.switchTo().parentFrame();
        WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
        Assert.assertTrue(element.isDisplayed());
    }
}

