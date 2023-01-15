package com.cbt.day16;

import com.cbt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.rmi.UnexpectedException;

public class uploadfile  {
    @Test
    public void test1() throws InterruptedException {
        Driver.getDriver().get("https://practice.cydeo.com/upload");
        String path = "C:\\Users\\kemal\\Desktop\\OS cevaplar\\2.jpg";

        WebElement uploadbutton = Driver.getDriver().findElement(By.id("file-upload"));
        Thread.sleep(1000);
        uploadbutton.sendKeys(path);

        WebElement sumbitbutton = Driver.getDriver().findElement(By.id("file-submit"));
        sumbitbutton.click();

        WebElement fileuploadedheader = Driver.getDriver().findElement(By.tagName("H3"));

        Assert.assertTrue(fileuploadedheader.isDisplayed());
    }
}
