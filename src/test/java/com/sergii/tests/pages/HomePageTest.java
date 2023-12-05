package com.sergii.tests.pages;

import com.sergii.code.pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePageTest {

    private HomePage homePage;
    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(HomePageTest.class);
    private WebElement revealed;
    
    



    @BeforeEach
    public void beforeHook() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.get("https://www.amazon.com/");
        log.info("Web site is opened");
    }

    @Test
    @DisplayName(value = "Logo name test")
    public void logoTest(){

        log.info("Logo name test is started");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        homePage.getLogoText();


        log.info("Logo name test is finished");

    }

    @Test
    @DisplayName(value = "Title click test")
    public void titleClickTest(){

        log.info("Title click test is started");

        homePage.clickTitle();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        log.info("Title click test is finished");

    }

    @Test
    @DisplayName(value = "Cart click test")
    public void cartClickTest(){

        log.info("Cart click test is started");

        homePage.clickCart();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        log.info("Cart click test is finished");

    }



    @AfterEach
    public void afterHook(){
        driver.quit();
        log.info("Web site is closed");
    }

}
