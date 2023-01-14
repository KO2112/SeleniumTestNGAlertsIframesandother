package com.cbt.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtil {
    public static void switchWindowAndVerify(WebDriver driver, String expectedinurl, String expectedtitle) throws InterruptedException {
        Set<String> allwindowhandles = driver.getWindowHandles();
        for (String each  : allwindowhandles) {
            Thread.sleep(1000);
            driver.switchTo().window(each);
            System.out.println("current url " + driver.getCurrentUrl());
            if (driver.getCurrentUrl().contains(expectedtitle)){
                break;
            }
        }
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedtitle));
    }
    public static void verifytitle(WebDriver driver, String expectedtitle){
        Assert.assertEquals(driver.getTitle(),expectedtitle);
    }
    public static String returnOrderDate(WebDriver driver, String customersname){
        String locator ="//td[.='"+customersname+"']/following-sibling::td[3]";
        WebElement customerdatecell = driver.findElement(By.xpath(locator));
        return customerdatecell.getText();
    }
    public static void orderverify(WebDriver driver, String customersname, String expectedorderdate){
        String locator ="//td[.='"+customersname+"']/following-sibling::td[3]";
        WebElement customerdatecell = driver.findElement(By.xpath(locator));
        String actualorderdate = customerdatecell.getText();
        Assert.assertEquals(actualorderdate,expectedorderdate);
    }
    public static void getTableGetEmail(WebDriver driver, String tablenum, String firstname){
        driver.findElement(By.xpath("//table[@id='"+tablenum+"']//td[.='"+firstname+"']"));

    }
    public static void logintosmartbear (WebDriver driver){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        WebElement element = driver.findElement(By.id("ctl00_MainContent_username"));
        element.sendKeys("Tester");
        WebElement element1 = driver.findElement(By.id("ctl00_MainContent_password"));
        element1.sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
    }
}
