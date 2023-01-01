package com.cbt.utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class CydeoTest2 {
    WebDriver driver;
    @BeforeMethod
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }
    @Test
    public void test1(){
        WebElement infoalertbuttin = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button[1]"));
        infoalertbuttin.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement text = driver.findElement(By.id("result"));
        String x = text.getText();
        String y = "You successfully clicked an alert";
        Assert.assertEquals(x,y);
    }
    @Test
    public void test2(){
        WebElement confirmbutton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button[2]"));
        confirmbutton.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement text = driver.findElement(By.id("result"));
        String x = "You clicked: Cancel";
        Assert.assertEquals(x,text.getText());
    }
    @Test
    public void test3() throws InterruptedException {
        WebElement promtbutton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button[3]"));
        promtbutton.click();
        WebDriverWait wait =new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.sendKeys("hello");
        alert.accept();
        WebElement text =  driver.findElement(By.id("result"));
        String x = "You entered: hello";
        Assert.assertEquals(x,text.getText());
    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
