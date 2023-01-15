package com.cbt.utilities;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Locale;

public class JavaFaker {
    @Test
    public void test1(){
        Faker faker = new Faker(new Locale("tr"));

        System.out.println("faker.name().firstname() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        String randomnumber = faker.numerify("###-###-###");
        System.out.println("randomnumber = " + randomnumber);
        String randomnumber2 = faker.numerify("421-###-#");
        System.out.println(randomnumber2);
        System.out.println("faker.letterify(\"????\") = " + faker.letterify("????-???"));
        System.out.println("faker.bothify(\"##?#-##?#?-##??\") = " + faker.bothify("##?#-##?#?-##??"));
        System.out.println("faker.finance() = " + faker.finance().creditCard().replaceAll("-",""));
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());
    }
}
