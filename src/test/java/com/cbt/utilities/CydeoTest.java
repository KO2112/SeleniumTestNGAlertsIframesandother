package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CydeoTest {
    WebDriver driver;
    @BeforeMethod
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(enabled = false)
    public void test1(){
        driver.get("https://practice.cydeo.com/add_remove_elements/ ");
        WebElement add = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/button"));
        add.click();
        WebElement delete = driver.findElement(By.className("added-manually"));
        Boolean isdisplayed = delete.isDisplayed();
        System.out.println(isdisplayed);
        delete.click();

        try {
            System.out.println(delete.isDisplayed());
        }catch (StaleElementReferenceException e){
            System.out.println("its not dispalyed");
        }
    }
    @Test
    public void test2(){
        driver.get("https://practice.cydeo.com/radio_buttons");
        List<WebElement> buttons = driver.findElements(By.name("color"));
        for (WebElement element: buttons) {
            System.out.println(element.getText() + "" + element.getAttribute("id"));
        }
    }
    public void clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String idValue){
        List<WebElement> buttons = driver.findElements(By.name(nameAttribute));
        for (WebElement each: buttons) {
            String eachid = each.getAttribute("id");
            if (eachid.equals(idValue)){
                each.click();
                System.out.println(eachid + "is selected" + each.isSelected());
                break;
            }
        }
    }
    @Test
    public void test3(){
        driver.get("https://practice.cydeo.com/dropdown");
        WebElement element = driver.findElement(By.id("dropdown"));
        Select select = new Select(element);
        List<WebElement> alloptions = select.getOptions();
        for (WebElement element1: alloptions) {
            System.out.println(element1.getText());
        }
    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
