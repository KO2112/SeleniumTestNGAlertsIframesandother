package com.cbt.day15;

import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class tc1registformtest {
    @Test
    public void regtest(){
        Faker faker = new Faker();
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        WebElement inputfirstname = Driver.getDriver().findElement(By.name("firstname"));
        inputfirstname.sendKeys(faker.name().firstName());

        WebElement inputlastname = Driver.getDriver().findElement(By.name("lastname"));
        inputlastname.sendKeys(faker.name().lastName());

        WebElement inputusername = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));

//      inputusername.sendKeys(faker.name().username().replaceAll(".",""));
        String user = faker.bothify("helpdesk####");
        inputusername.sendKeys(user);

        WebElement inputemail = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        inputemail.sendKeys(user+"@gmail.com");

    }
}
