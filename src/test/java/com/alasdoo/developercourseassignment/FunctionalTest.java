package com.alasdoo.developercourseassignment;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FunctionalTest {
        protected static WebDriver driver;
      //  protected static Process frontendProcess;

        @BeforeAll
        public static void setUp() throws IOException {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          //  frontendProcess = new ProcessBuilder("../../../../frontend", "start").start();
        }

        @AfterEach
        public void cleanUp(){
            driver.manage().deleteAllCookies();
        }

        @AfterAll
        public static void tearDown(){
            driver.close();
        }
}
