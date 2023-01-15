package com.cbt.day16;

import com.cbt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3actions {
    @Test
    public void hoveringtest() throws InterruptedException{
        Driver.getDriver().get("https://practice.cydeo.com/hovers");

        WebElement img1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement img2 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement img3 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user3']"));

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(img1).perform();
        Assert.assertTrue(user1.isDisplayed());

        Thread.sleep(1000);

        actions.moveToElement(img2).perform();
        Assert.assertTrue(user2.isDisplayed());

        Thread.sleep(1000);

        actions.moveToElement(img3).perform();
        Assert.assertTrue(user3.isDisplayed());
    }
    @Test
    public void test2() throws InterruptedException{
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            javascriptExecutor.executeScript("window.scrollBy(0,750)");
        }
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            javascriptExecutor.executeScript("window.scrollBy(0,-750)");
        }
    }
}
