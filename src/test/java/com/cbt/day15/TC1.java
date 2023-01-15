package com.cbt.day15;

import com.cbt.utilities.BrowserUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TC1 {
    WebDriver driver;
    @Test
    public void test1(){
        BrowserUtil.logintosmartbear(driver);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        int count = 0;
        for (WebElement link : links) {
            System.out.println(link.getAttribute("href") + " " + link.getText());
            count++;
        }
        System.out.println(count);
        driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();

        Select select = new Select(driver.findElement(By.name("ctl00$MainContent$fmwOrder$ddlProduct")));
        List<WebElement> elementList  = select.getOptions();
        select.selectByVisibleText("FamilyAlbum");
        WebElement quant =  driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quant.clear();
        quant.sendKeys("2");
        driver.findElement(By.className("btn_dark")).click();

    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
