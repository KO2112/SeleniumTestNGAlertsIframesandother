package com.cbt.utilities;

import org.testng.annotations.Test;

import java.util.Properties;

public class LearningProperties {
    @Test
    public void java_properties_reading_test(){
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.name"));
        Properties properties = new Properties();

    }
}
