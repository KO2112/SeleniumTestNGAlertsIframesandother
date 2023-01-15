package com.cbt.utilities;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Set;

public class Tables {

    WebDriver driver;
    @BeforeMethod
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test1() throws InterruptedException {
        System.out.println("table1 text");
        driver.get("https://practice.cydeo.com/tables");
        List<WebElement> elementList = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
        for (WebElement element : elementList) {
            System.out.println(element.getText());
        }
        System.out.println("all table text");
        List<WebElement> allelementlist = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr//td"));
        for (WebElement element : allelementlist) {
            System.out.println(element.getText());
        }
        System.out.println("ALL THE NAMES");
        List<WebElement> allthenames = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr//td[2]"));
        for (WebElement allthename : allthenames) {
            System.out.println(allthename.getText());
        }

    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
