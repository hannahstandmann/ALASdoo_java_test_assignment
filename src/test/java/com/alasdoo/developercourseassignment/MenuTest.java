package com.alasdoo.developercourseassignment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MenuTest extends FunctionalTest{
    @Test
    public void checkMenuItems(){
        driver.get("http://localhost:3000");

        MainPage entrance = new MainPage(driver);
        Assertions.assertEquals("Student", entrance.pageTitle());


    }
}
