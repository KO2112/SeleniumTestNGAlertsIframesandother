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

public class TC3 {
    WebDriver driver;
    @BeforeMethod
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test1() throws InterruptedException{
        driver.get("http://login1.nextbasecrm.com/");
        WebElement login = driver.findElement(By.className("login-inp"));
        login.sendKeys("Helpdesk2@cybertekschool.com");
        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("UserUser");
        WebElement button = driver.findElement(By.className("login-btn"));
        button.click();
        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println(title);
        BrowserUtil.verifytitle(driver,"Portal");

    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
