package com.cbt.singletonandjavafaker;

import org.testng.annotations.Test;

public class single_understand_test1 {
    @Test(priority = 2)
    public void singleunderstand(){
        String str = Singleton.getWord();
        System.out.println("str = " + str);
        String str1 = Singleton.getWord();
        System.out.println("str = " + str);
        String str2 = Singleton.getWord();
        System.out.println("str = " + str);
    }
    @Test(priority = 1)
    public void singletonunderstandingtest1(){
        String str4 = Singleton.getWord();
        System.out.println("str = " + str4);
    }

}
