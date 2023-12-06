package com.sergii.tests.pages;

import com.sergii.code.pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePageTest {

    private HomePage homePage;
    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(HomePageTest.class);
    
    



    @BeforeEach
    public void beforeHook() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.get("https://www.amazon.com/");
        log.info("Web site is opened");
    }

    @Test
    @DisplayName(value = "Text name test")
    public void textTest(){

        log.info("Text name test is started");

        String text = homePage.getText();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        homePage.getText();
        Assertions.assertThat(text).isEqualTo("Make Money with Us");


        log.info("Text name test is finished");

    }

    @Test
    @DisplayName(value = "Title click test")
    public void titleClickTest(){

        log.info("Title click test is started");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        homePage.clickTitle();


        log.info("Title click test is finished");

    }

    @Test
    @DisplayName(value = "Cart click test")
    public void cartClickTest(){

        log.info("Cart click test is started");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        homePage.clickCart();


        log.info("Cart click test is finished");

    }



    @AfterEach
    public void afterHook(){
        driver.quit();
        log.info("Web site is closed");
    }

}
